package model;

import java.util.List;

/**
 * Clase abstracta base para los tipos de guerrero.
 * Define atributos y comportamiento común de combate.
 */
public abstract class Warrior {

    private String name;

    private double lifePoints;
    private double attack;
    private double defence;

    private String weapon;
    private String origin;
    private String warriorType;

    /**
     * Inicializa atributos base del guerrero.
     */
    public Warrior(
            String name,
            double lifePoints,
            double attack,
            double defence,
            String weapon) {

        this.name = name;
        this.lifePoints = lifePoints;
        this.attack = attack;
        this.defence = defence;
        this.weapon = weapon;
    }

    /**
     * Modifica puntos de vida.
     * Valores negativos representan daño.
     */
    public void updateLife(double amount) {
        lifePoints += amount;
    }

    /**
     * Modifica ataque.
     */
    protected void updateAttack(double amount) {
        attack += amount;
    }

    /**
     * Modifica defensa.
     */
    protected void updateDefence(double amount) {
        defence += amount;
    }

    /**
     * Define cultura u origen del guerrero.
     */
    protected void setOrigin(String origin) {
        this.origin = origin;
    }

    /**
     * Define tipo de guerrero.
     */
    protected void setWarriorType(String type) {
        warriorType = type;
    }

    /**
     * Aplica bonificación especial.
     */
    protected void setSpecial(int special) {

        switch (special) {

            case 1 -> updateLife(10);

            case 2 -> updateAttack(0.10);

            case 3 -> updateDefence(
                    Math.min(0.95, getDefence() + 0.10));
        }
    }

    public double getLife() {
        return lifePoints;
    }

    public double getAttack() {
        return attack;
    }

    public double getDefence() {
        return defence;
    }

    public String getName() {
        return name;
    }

    public String getWarriorType() {
        return warriorType;
    }

    public void setWeapon(String armor) {
        this.weapon = armor;
    }

    public String getWeapon() {
        return weapon;
    }

    /**
     * Retorna lista de armas disponibles
     * para el tipo de guerrero.
     */
    public abstract List<String> getArmsList();
}