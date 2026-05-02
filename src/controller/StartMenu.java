package controller;

import view.*;

import java.util.Scanner;

public class StartMenu {
    private MainMenuView view = new MainMenuView();
    private BattleInConsole battleView = new BattleInConsole();
    private Scanner sc = new Scanner(System.in);

    public void start() {
        view.showTitle();
        view.showMenu();

        if (!sc.hasNextInt()) {
            System.out.println("Entrada inválida");
            sc.next();
            return;
        }

        int menu = sc.nextInt();

        if (menu == 1) {
            SelectionController selector = new SelectionController(sc);
            var playerCulture = selector.selectCulture();

            PlayerController player = new PlayerController(playerCulture);
            EnemyBot enemy = new EnemyBot();

            view.clear();
            view.showNewBattle(player, enemy);

            int next = sc.nextInt();
            view.clear();

            int round = 1;
            BattleController battle = new BattleController(
                    player,
                    enemy);
            // battleView.showAvailableWarriors(player);
            int change = sc.nextInt();
            while (!battle.isBattleOver()) {
                view.clear();
                System.out.println(battle.getBattleStatus());

                battleView.attackSelector();
                int atk = sc.nextInt();

                battle.playerTurn(change, atk);

                if (battle.isBattleOver()) {
                    break;
                }

                battle.enemyTurn();

                round++;

                int nextCombat = sc.nextInt();
            }
            System.out.println(
                    battle.getResult());

            sc.close();

        } else if (menu == 0) {
            view.showExit();
            return;

        } else {
            System.out.println("Opción inválida");
        }

    }
}
