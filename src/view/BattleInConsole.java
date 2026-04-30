package view;
import controller.*;
import model.Warrior;

public class BattleInConsole {

    public static void FirstRound (PlayerController player,EnemyBot enemy){
        System.out.println("\n=============================");
        System.out.println("| PRIMERA BATALLA |");
        System.out.println("=============================");
        System.out.printf("\nContrincante: %s \nVida: %s \nDefenza: %s \nArma: %s",enemy.getEnemyWarrior().getName(), enemy.getEnemyWarrior().getLife(), enemy.getEnemyWarrior().getDefence(), enemy.getEnemyWarrior().getArmor());
        System.out.println("----------------------------------");
        
        showAvailableWarriors(player);
    }

    public static void showAvailableWarriors(PlayerController player){
        System.out.println("Jugador, Eligue a tu combatiente: ");
        for (int i=0;
             i<player.getWarriorTeam().size();
             i++) {

            var w = player.getWarriorTeam().get(i);

            System.out.printf(
                    "%d) %s | %s | vida:%.1f atk:%.2f def:%.2f%n | arma:%s \n",
                    i,
                    w.getWarriorType(),
                    w.getName(),
                    w.getLife(),
                    w.getAttack(),
                    w.getDefence(),
                    w.getArmor());
        }
    }

    public static void showWarriorChange(Warrior activeWarrior){
        System.out.printf(
                    "# Guerrero seleccionado: %s | %s | vida:%.1f atk:%.2f def:%.2f%n | arma:%s ",
                    activeWarrior.getWarriorType(),
                    activeWarrior.getName(),
                    activeWarrior.getLife(),
                    activeWarrior.getAttack(),
                    activeWarrior.getDefence(),
                    activeWarrior.getArmor());
    }

    public static void attackSelector(){
        System.out.println("- Lanzar ataque -");
        System.out.println("[1]: Basico \n[2]: Especial");
    }

    public static void showAttack(Warrior attacker, Warrior target, double damage ){
        System.out.printf("\n> %s Ataca con %s a %s \n- %s Recive %s puntos de daño.",attacker.getName(), attacker.getArmor(), target.getName(),target.getName(), damage);

    }
    public void showBattleStatus(PlayerController player, EnemyBot enemy) {

        Warrior pw = player.getActiveWarrior();
        Warrior ew = enemy.getEnemyWarrior();

        String.format(
            "%n ── Estado actual ──────────────%n" +
            " [Jugador] %-12s vida: %5.1f atk: %.2f def: %.2f%n [ VS ]\n" +
            " [Enemigo] %-12s vida: %5.1f atk: %.2f def: %.2f%n",
            pw.getName(),
            pw.getLife(),
            pw.getAttack(),
            pw.getDefence(),
            ew.getName(),
            ew.getLife(),
            ew.getAttack(),
            ew.getDefence()
        );
    }

}
