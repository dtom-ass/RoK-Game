package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * Clase abstracta que representa una cultura.
 * Agrupa guerreros y define atributos comunes.
 */
public abstract class Culture {

    private String name;
    private double perBonus; // Se valida rango básico
    private String specialSkill; // String limita comportamiento futuro
    private List<Warrior> warriorList;

    /*
     * Constructor base.
     * Inicializa atributos y la lista.
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
     * Agrega un guerrero.
     * Evita null y duplicados.
     */
    public void addWarrior(Warrior warrior) {
        if (warrior != null && !warriorList.contains(warrior)) {
            warriorList.add(warrior);
        }
    }

    /*
     * Retorna lista inmodificable.
     * Evita cambios externos.
     */
    public List<Warrior> getWarriorList() {
        return Collections.unmodifiableList(warriorList);
    }

    public String getName() {
        return name;
    }

    public double getPerBonus() {
        return perBonus;
    }

    public String getSkill() {
        return specialSkill;
    }

    /*
     * Setters protegidos con validación básica.
     */
    protected void setName(String name) {
        if (name != null && !name.isEmpty()) {
            this.name = name;
        }
    }

    protected void setBonus(double bonus) {
        if (bonus >= 0) {
            this.perBonus = bonus;
        }
    }

    protected void setSkill(String skill) {
        if (skill != null && !skill.isEmpty()) {
            this.specialSkill = skill;
        }
    }

    /*
     * Obliga a definir nombres de guerreros.
     */
    public abstract List<String> getWarriorNameList();

    public void removeWarrior(int index) {
        if (index >= 0 && index < warriorList.size()) {
            warriorList.remove(index);
        }
    }
}