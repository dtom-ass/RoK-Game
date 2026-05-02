package controller;

import model.Warrior;
import view.BattleInConsole;
import view.ConsoleView;

/**
 * Controla el flujo de la batalla.
 */
public class BattleController {

    private static final int SPECIAL_ATTACK = 2;

    private final PlayerController player;
    private final EnemyBot enemy;
    private final ConsoleView view = new ConsoleView();

    public BattleController(PlayerController player, EnemyBot enemy) {
        this.player = player;
        this.enemy = enemy;
    }

    /**
     * Turno del jugador.
     */
    public String playerTurn(int selectedWarriorIndex, int attackType) {

        if (player.getActiveWarrior() == null || enemy.getEnemyWarrior() == null) {
            return "Combate inválido";
        }

        if (selectedWarriorIndex >= 0) {
            player.switchWarrior(selectedWarriorIndex);
        }

        Warrior attacker = player.getActiveWarrior();
        Warrior target = enemy.getEnemyWarrior();

        String targetName = target.getName();

        double rawDamage = (attackType == 2)
                ? player.specialAttack()
                : player.basicAttack();

        double finalDamage = calculateDamage(rawDamage, target.getDefence());

        BattleInConsole.showAttack(attacker, target, finalDamage);

        boolean killed = enemy.receiveAttack(finalDamage);

        if (killed) {
            System.out.println(">>> " + targetName + " ha sido eliminado.");

            if (enemy.getEnemyWarrior() != null) {
                System.out.println(">>> Nuevo enemigo: "
                        + enemy.getEnemyWarrior().getName());
            }
        }

        return "";
    }

    /**
     * Turno del enemigo.
     */
    public String enemyTurn() {

        if (player.getActiveWarrior() == null || enemy.getEnemyWarrior() == null) {
            return "Combate inválido";
        }

        System.out.println("\n--- TURNO DEL ENEMIGO ---");

        Warrior attacker = enemy.getEnemyWarrior();
        Warrior target = player.getActiveWarrior();

        String targetName = target.getName(); // guardar antes

        double rawDamage = enemy.playTurn();
        double finalDamage = calculateDamage(rawDamage, target.getDefence());

        BattleInConsole.showAttack(attacker, target, finalDamage);

        boolean killed = player.receiveAttack(finalDamage);

        if (killed) {
            System.out.println(">>> " + targetName + " ha sido eliminado.");

            // Mostrar nuevo guerrero activo automáticamente
            if (player.getActiveWarrior() != null) {
                System.out.println(">>> Nuevo guerrero activo: "
                        + player.getActiveWarrior().getName());
            }
        }

        return "";
    }

    /**
     * Cálculo de daño.
     */
    private double calculateDamage(double attack, double defence) {

        // Normaliza defensa para evitar valores fuera de rango
        double def = Math.max(0, Math.min(defence, 1));

        return Math.max((attack * 30) * (1 - def), 1.0);
    }

    public boolean isPlayerAlive() {
        return player.isAlive();
    }

    public boolean isEnemyAlive() {
        return enemy.isAlive();
    }

    public boolean isBattleOver() {
        return !player.isAlive() || !enemy.isAlive();
    }

    /**
     * Estado del combate.
     */
    public void getBattleStatus() {

        Warrior pw = player.getActiveWarrior();
        Warrior ew = enemy.getEnemyWarrior();

        if (pw == null || ew == null) {
            view.printBox("COMBATE FINALIZADO");
            return;
        }

        String pData = String.format("%-12s | HP: %5.1f | ATK: %.2f",
                pw.getName(), pw.getLife(), pw.getAttack());

        String vs = "--- VERSUS ---";

        String eData = String.format("%-12s | HP: %5.1f | ATK: %.2f",
                ew.getName(), ew.getLife(), ew.getAttack());

        view.printBox("ESTADO DE COMBATE", pData, vs, eData);
    }

    /**
     * Resultado final.
     */
    public String getResult() {

        if (!enemy.isAlive()) {
            return "\n *** ¡Victoria! Derrotaste al enemigo. ***\n";
        }

        if (!player.isAlive()) {
            return "\n *** Derrota. Tu equipo fue eliminado. ***\n";
        }

        return "";
    }
}