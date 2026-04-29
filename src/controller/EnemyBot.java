package controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import model.Culture;
import model.Warrior;
import model.Cultures.AztecaCulture;
import model.Cultures.IncaCulture;
import model.Cultures.MayaCulture;
import model.Cultures.MuiscaCulture;
import model.Warriors.Archer;
import model.Warriors.Fighter;
import model.Warriors.Healer;
import model.Warriors.Lancer;
import model.Warriors.Tank;

/**
 * Controla el comportamiento del bot enemigo.
 * Genera cultura, equipo y decisiones de combate.
 */
public class EnemyBot {

    private static final double SPECIAL_MULTIPLIER = 1.5;

    private Culture enemyCulture;
    private Warrior enemyWarrior;
    private int activeWarriorIndex;
    private boolean alive;

    private final Random random = new Random();

    /**
     * Inicializa el bot enemigo.
     */
    public EnemyBot() {

        alive = true;
        activeWarriorIndex = 0;

        generateEnemyTeam();

        enemyWarrior =
                enemyCulture.getWarriorList().get(0);
    }

    /**
     * Genera cultura aleatoria y equipo enemigo.
     */
    private void generateEnemyTeam() {

        setRandomCulture();

        List<String> names =
                enemyCulture.getWarriorNameList();

        List<Integer> indices = new ArrayList<>();

        for (int i = 0; i < names.size(); i++) {
            indices.add(i);
        }

        Collections.shuffle(indices);

        for (int i = 0; i < 3; i++) {

            String name = names.get(indices.get(i));

            Warrior warrior =
                    createRandomWarrior(name);

            warrior.setArmor(
                warrior.getArmsList().get(
                    random.nextInt(
                        warrior.getArmsList().size()
                    )
                )
            );

            enemyCulture.addWarrior(warrior);
        }
    }

    /**
     * Asigna cultura aleatoria.
     */
    private void setRandomCulture() {

        switch (random.nextInt(4)) {

            case 0 -> enemyCulture = new AztecaCulture();
            case 1 -> enemyCulture = new IncaCulture();
            case 2 -> enemyCulture = new MayaCulture();
            default -> enemyCulture = new MuiscaCulture();
        }
    }

    /**
     * Crea un guerrero aleatorio.
     */
    private Warrior createRandomWarrior(String name) {

        return switch (random.nextInt(5)) {

            case 0 -> new Archer(name);
            case 1 -> new Fighter(name);
            case 2 -> new Healer(name);
            case 3 -> new Lancer(name);

            default -> new Tank(name);
        };
    }

    /**
     * Ejecuta turno del bot.
     */
    public double playTurn() {

        if (random.nextBoolean()) {
            switchWarrior();
        }

        return random.nextBoolean()
                ? basicAttack()
                : specialAttack();
    }

    /**
     * Cambia guerrero activo aleatoriamente.
     */
    private void switchWarrior() {

        List<Warrior> team =
                enemyCulture.getWarriorList();

        if (team.size() <= 1) {
            return;
        }

        int next;

        do {
            next = random.nextInt(team.size());
        }
        while (next == activeWarriorIndex);

        activeWarriorIndex = next;
        enemyWarrior = team.get(next);
    }

    /**
     * Ataque básico.
     */
    private double basicAttack() {
        return enemyWarrior.getAttack();
    }

    /**
     * Ataque especial.
     */
    private double specialAttack() {
        return enemyWarrior.getAttack()
                * SPECIAL_MULTIPLIER;
    }

    /**
     * Aplica daño recibido.
     */
    public void receiveAttack(double damage) {

        enemyWarrior.updateLife(-damage);

        if (enemyWarrior.getLife() <= 0) {
            removeDeadWarrior();
        }
    }

    /**
     * Elimina guerrero derrotado.
     */
    private void removeDeadWarrior() {

        System.out.printf(
            " %s ha sido eliminado.%n",
            enemyWarrior.getName()
        );

        enemyCulture
            .getWarriorList()
            .remove(activeWarriorIndex);

        if (enemyCulture.getWarriorList().isEmpty()) {

            alive = false;

        } else {

            activeWarriorIndex = 0;

            enemyWarrior =
                enemyCulture
                    .getWarriorList()
                    .get(0);

            System.out.printf(
                " Nuevo guerrero enemigo: %s%n",
                enemyWarrior.getName()
            );
        }
    }

    public Culture getEnemyCulture() {
        return enemyCulture;
    }

    public Warrior getEnemyWarrior() {
        return enemyWarrior;
    }

    public boolean isAlive() {
        return alive;
    }

    public List<String> getWarriorNameList() {
        return enemyCulture.getWarriorNameList();
    }

}