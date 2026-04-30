package controller;

import model.Warrior;
import view.BattleInConsole;
import view.MainMenuView;

/**
 * Controla el flujo de la batalla.
 * Procesa turnos, calcula daño y verifica el estado del combate.
 */
public class BattleController {

    private static final int SPECIAL_ATTACK = 2;

    private final PlayerController player;
    private final EnemyBot enemy;
    private MainMenuView view = new MainMenuView();

    /**
     * Inicializa la batalla con ambos equipos.
     */
    public BattleController(
            PlayerController player,
            EnemyBot enemy) {

        this.player = player;
        this.enemy = enemy;
    }

    /**
     * Ejecuta el turno del jugador.
     *
     * @return registro textual del turno
     */
    public String playerTurn(
            int selectedWarriorIndex,
            int attackType) {

        StringBuilder log = new StringBuilder();
        Warrior attacker = player.getActiveWarrior();
        Warrior target = enemy.getEnemyWarrior();

        if (selectedWarriorIndex >= 0) {

            player.switchWarrior(selectedWarriorIndex);

            BattleInConsole.showWarriorChange(target);
        }

        

        double rawDamage =
                attackType == SPECIAL_ATTACK
                ? player.specialAttack()
                : player.basicAttack();

        double finalDamage =
                calculateDamage(
                        rawDamage,
                        target.getDefence()
                );

        BattleInConsole.showAttack(attacker, target, finalDamage);

        enemy.receiveAttack(finalDamage);

        if (!enemy.isAlive()) {

            view.showMessage("ENEMIGO DERROTADO");

        } else {

            log.append(
                String.format(
                    " Vida restante de %s: %.1f%n",
                    target.getName(),
                    target.getLife()
                )
            );
        }

        return log.toString();
    }

    /**
     * Ejecuta el turno del enemigo.
     *
     * @return registro textual del turno
     */
    public String enemyTurn() {

        StringBuilder log = new StringBuilder();

        Warrior attacker = enemy.getEnemyWarrior();
        Warrior target = player.getActiveWarrior();

        double rawDamage = enemy.playTurn();

        double finalDamage =
                calculateDamage(
                        rawDamage,
                        target.getDefence()
                );

        BattleInConsole.showAttack(attacker, target, finalDamage);

        player.receiveAttack(finalDamage);

        if (!player.isAlive()) {

            view.showMessage("TU  EQUIPO PIERDE");

        } else {

            log.append(
                String.format(
                    " Vida restante de %s: %.1f%n",
                    target.getName(),
                    target.getLife()
                )
            );
        }

        return log.toString();
    }

    /**
     * Calcula daño considerando defensa.
     */
    private double calculateDamage(
            double attack,
            double defence) {

        return Math.max(
            (attack * 30) * (1 - defence),
            1.0
        );
    }

    /**
     * Indica si el jugador sigue con vida.
     */
    public boolean isPlayerAlive() {
        return player.isAlive();
    }

    /**
     * Indica si el enemigo sigue con vida.
     */
    public boolean isEnemyAlive() {
        return enemy.isAlive();
    }

    /**
     * Indica si la batalla terminó.
     */
    public boolean isBattleOver() {
        return !player.isAlive()
                || !enemy.isAlive();
    }

    /**
     * Retorna resumen actual del combate.
     */
    public String getBattleStatus() {

        Warrior pw = player.getActiveWarrior();
        Warrior ew = enemy.getEnemyWarrior();

        return String.format(
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

    /**
     * Retorna resultado final de la partida.
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