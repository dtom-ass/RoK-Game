package model;

import java.util.*;

/*
 * Clase abstracta que representa una cultura.
 */
public abstract class Culture {

    private String name;
    private double perBonus;
    private String specialSkill;
    private List<Warrior> warriorList;

    /*
     * Constructor base de cultura.
     */
    public Culture(
            String name,
            double perBonus,
            String specialSkill) {

        this.name = name;
        this.perBonus = perBonus;
        this.specialSkill = specialSkill;

        this.warriorList = new ArrayList<>();
    }

    /*
     * Agrega un guerrero a la cultura.
     */
    protected void addWarrior(Warrior warrior) {
        warriorList.add(warrior);
    }

    /*
     * Retorna la lista de guerreros.
     */
    public List<Warrior> getWarriorList() {
        return warriorList;
    }

    public String getName() {
        return name;
    }

    public double getPerBonus() {
        return perBonus;
    }

    protected void setName(String name) {
        this.name = name;
    }

    protected void setBonus(double bonus) {
        this.perBonus = bonus;
    }

    protected void setSkill(String skill) {
        this.specialSkill = skill;
    }

}