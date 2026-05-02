package controller;

import java.util.List;
import model.Culture;
import model.Warrior;

/**
 * Controla acciones del jugador durante la batalla.
 */
public class PlayerController {

    private static final double SPECIAL_MULTIPLIER = 1.5;

    private Culture playerCulture;
    private Warrior activeWarrior;
    private int activeWarriorIndex;
    private boolean alive;

    /**
     * Inicializa el controlador del jugador.
     */
    public PlayerController(Culture culture) {

        playerCulture = culture;
        activeWarriorIndex = 0;
        alive = true;

        List<Warrior> team = culture.getWarriorList();

        // Validación de equipo vacío
        if (!team.isEmpty()) {
            activeWarrior = team.get(0);
        } else {
            activeWarrior = null;
            alive = false;
        }
    }

    /**
     * Cambia guerrero activo.
     */
    public void switchWarrior(int chosenIndex) {

        List<Warrior> team = playerCulture.getWarriorList();

        if (chosenIndex == activeWarriorIndex)
            return;
        if (chosenIndex < 0 || chosenIndex >= team.size())
            return;

        activeWarriorIndex = chosenIndex;
        activeWarrior = team.get(chosenIndex);
    }

    /**
     * Ataque básico.
     */
    public double basicAttack() {
        if (activeWarrior == null)
            return 0;
        return activeWarrior.getAttack();
    }

    /**
     * Ataque especial.
     */
    public double specialAttack() {
        if (activeWarrior == null)
            return 0;
        return activeWarrior.getAttack() * SPECIAL_MULTIPLIER;
    }

    /**
     * Aplica daño recibido.
     */
    public boolean receiveAttack(double damage) {

        if (activeWarrior == null)
            return false;

        activeWarrior.updateLife(-damage);

        if (activeWarrior.getLife() <= 0) {
            removeDeadWarrior();
            return true; // murió
        }

        return false;
    }

    /**
     * Elimina guerrero derrotado.
     */
    private void removeDeadWarrior() {

        // FIX: usar método interno de Culture
        playerCulture.removeWarrior(activeWarriorIndex);

        List<Warrior> team = playerCulture.getWarriorList();

        if (team.isEmpty()) {
            alive = false;
            activeWarrior = null;
            return;
        }

        activeWarriorIndex = 0;
        activeWarrior = team.get(0);
    }

    public Warrior getActiveWarrior() {
        return activeWarrior;
    }

    public List<Warrior> getWarriorTeam() {
        return playerCulture.getWarriorList();
    }

    public Culture getPlayerCulture() {
        return playerCulture;
    }

    public boolean isAlive() {
        return alive;
    }
}