package controller;

import view.ConsoleLog;
import controller.SelectionController;
import model.Culture;

public class PlayerPanel {
    private PlayerController player;
    private BattleController battle;

    public void newGame(){
        Culture playerCulture = SelectionController.getSelectedCulture();
        this.player = new PlayerController(playerCulture);
        EnemyBot enemy = new EnemyBot();
        this.battle = new BattleController(player, enemy);
        // battleLoop();
    }
    int selectedIndex = -1;

    public void ChangeWarrior() {
        selectedIndex += 1;
        if (selectedIndex >= player.getWarriorTeam().size() ){
            selectedIndex = -1;
        }
    }

    public void basicAttack(){
        battle.playerTurn(selectedIndex, 1);
    }
    public void specialAttack(){
        battle.playerTurn(selectedIndex, 2);
    }
}
