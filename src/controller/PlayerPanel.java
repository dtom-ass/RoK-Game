package controller;

import controller.SelectionController;
import model.Culture;
import view.console.ConsoleLog;

public class PlayerPanel {
    private PlayerController player;
    private BattleController battle;
    private int selectedIndex;

    public void newGame(Culture playerCulture){
        this.player = new PlayerController(playerCulture);
        int selectedIndex = 0;
        EnemyBot enemy = new EnemyBot();
        this.battle = new BattleController(player, enemy);
        // battleLoop();
        
    }
    

    public void ChangeWarrior() {
        selectedIndex += 1;
        if (selectedIndex >= player.getWarriorTeam().size() ){
            selectedIndex = -1;
        }
    }

    public void basicAttack(){
        this.battle.playerTurn(1, 1);
    }
    public void specialAttack(){
        this.battle.playerTurn(1, 2);
    }
    /**
     * TURNO ENEMIGO SE COMPRUEBA DESPUES DEL ATAQUE DEL JUGADOR ##
            *if (battle.isEnemyAlive()) {
            *    battle.enemyTurn();
            *
            *}
            * 
            * Aun no lo defino, el juego fue planeado para que los ataques sean por turnos, pero podria hacerlo en combate mas tradicional.
            * Si se ejecuta el ataque enemigo de manera seudoaleatoria y no se limitan ataques del jugador.
            */

}
