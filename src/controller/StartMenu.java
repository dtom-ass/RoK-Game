package controller;
import view.*;

import java.util.Scanner;

public class StartMenu {
    private MainMenuView view = new MainMenuView();
    private Scanner sc = new Scanner(System.in);

    public void start(){
        view.showTitle();
        view.showMenu();

        int menu = sc.nextInt();

        if (menu == 1){
            SelectionController selector = new SelectionController(sc);
            
            var playerCulture = selector.selectCulture();

            PlayerController player = new PlayerController(playerCulture);

            view.showPlayerWarriors(player);

            EnemyBot enemy = new EnemyBot();
            view.showNewBattle(player, enemy);

        }else{
            view.showExit();
            
        }

    }
}
