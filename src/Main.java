import java.util.Scanner;

import controller.BattleController;
import controller.EnemyBot;
import controller.PlayerController;
import controller.SelectionController;
// MAIN DE PRUEBA. MODELO DE COMBATE OK.
public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("==================================");
        System.out.println("  PRUEBAS DEL SISTEMA RoKGame");
        System.out.println("==================================\n");

        // -----------------------------
        // 1. Selección y creación jugador
        // -----------------------------

        SelectionController selector =
                new SelectionController(sc);

        var playerCulture = selector.selectCulture();

        PlayerController player =
                new PlayerController(playerCulture);

        // -----------------------------
        // 2. Generación bot enemigo
        // -----------------------------

        EnemyBot enemy = new EnemyBot();

        System.out.println("\n--- CULTURA JUGADOR ---");
        System.out.println(
                player.getPlayerCulture().getName());

        System.out.println("\nEquipo jugador:");

        for (int i=0;
             i<player.getWarriorTeam().size();
             i++) {

            var w = player.getWarriorTeam().get(i);

            System.out.printf(
                    "%d) %s | %s | arma:%s | vida:%.1f atk:%.2f def:%.2f%n",
                    i,
                    w.getName(),
                    w.getWarriorType(),
                    w.getArmor(),
                    w.getLife(),
                    w.getAttack(),
                    w.getDefence());
        }


        System.out.println("\n--- CULTURA ENEMIGA ---");
        System.out.println(
                enemy.getEnemyCulture().getName());


        // -----------------------------
        // 3. Crear batalla
        // -----------------------------

        BattleController battle =
                new BattleController(
                        player,
                        enemy
                );


        int round = 1;

        while (!battle.isBattleOver()) {

            System.out.println(
                    "\n=============================");

            System.out.println(
                    "RONDA " + round);

            System.out.println(
                    "=============================\n");

            System.out.println(
                    battle.getBattleStatus());


            //---------------------------------
            // cambio opcional de guerrero
            //---------------------------------

            System.out.println(
               "Cambiar guerrero? (-1 no cambiar)");

            for(int i=0;
                i<player.getWarriorTeam().size();
                i++){

                System.out.println(
                    i + " -> " +
                    player.getWarriorTeam()
                          .get(i)
                          .getName()
                );
            }

            int change = sc.nextInt();


            //---------------------------------
            // elegir ataque
            //---------------------------------

            System.out.println(
              "Ataque: 1 basico | 2 especial");

            int atk = sc.nextInt();


            //---------------------------------
            // turno jugador
            //---------------------------------

            System.out.println(
                battle.playerTurn(change,atk)
            );

            if (battle.isBattleOver()) {
                break;
            }


            //---------------------------------
            // turno bot
            //---------------------------------

            System.out.println(
                battle.enemyTurn()
            );

            round++;
        }


        System.out.println(
                battle.getResult()
        );

        sc.close();
    }
}