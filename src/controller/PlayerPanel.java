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
        int selectedIndex = -1;
        EnemyBot enemy = new EnemyBot();
        this.battle = new BattleController(player, enemy);
        // battleLoop();
        System.out.println(this);
        
    }

    public BattleController getBattle(){
        return this.battle;
    }
    

    public void ChangeWarrior() {
        ConsoleLog.Log("GUERRERO ACTUAL: " + player.getActiveWarrior());
        selectedIndex += 1;
        
        if (selectedIndex >= player.getWarriorTeam().size() ){
            selectedIndex = -1;
        }
        player.switchWarrior(selectedIndex);
        ConsoleLog.Log("selectIndex = " + selectedIndex);
        
        ConsoleLog.Log("Cambia a: " + player.getWarriorTeam());
    }

    public void basicAttack(){
        System.out.println(this);
        this.battle.playerTurn(selectedIndex, 1);
    }
    public void specialAttack(){
        this.battle.playerTurn(selectedIndex, 2);
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
