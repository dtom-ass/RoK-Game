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

        activeWarrior = culture.getWarriorList().get(0);

        alive = true;
    }

    /**
     * Cambia guerrero activo.
     */
    public void switchWarrior(int chosenIndex) {

        List<Warrior> team = playerCulture.getWarriorList();

        if (chosenIndex == activeWarriorIndex) {
            return;
        }

        if (chosenIndex < 0 || chosenIndex >= team.size()) {
            return;
        }

        activeWarriorIndex = chosenIndex;
        activeWarrior = team.get(chosenIndex);
    }

    /**
     * Ejecuta ataque básico.
     */
    public double basicAttack() {
        return activeWarrior.getAttack();
    }

    /**
     * Ejecuta ataque especial.
     */
    public double specialAttack() {

        return activeWarrior.getAttack() * SPECIAL_MULTIPLIER;
    }

    /**
     * Aplica daño recibido.
     */
    public void receiveAttack(double damage) {

        activeWarrior.updateLife(-damage);

        if (activeWarrior.getLife() <= 0) {
            removeDeadWarrior();
        }
    }

    /**
     * Elimina guerrero derrotado.
     */
    private void removeDeadWarrior() {

        playerCulture.getWarriorList().remove(activeWarriorIndex);

        if (playerCulture.getWarriorList().isEmpty()) {

            alive = false;

        } else {

            activeWarriorIndex = 0;

            activeWarrior = playerCulture.getWarriorList().get(0);
        }
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