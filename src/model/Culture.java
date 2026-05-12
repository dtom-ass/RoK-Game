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
    private List<Warrior> warriorList;

    /*
     * Constructor base.
     * Inicializa atributos y la lista.
     */
    public Culture(
            String name){

        this.name = name;
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

    /*
     * Setters protegidos con validación básica.
     */
    protected void setName(String name) {
        if (name != null && !name.isEmpty()) {
            this.name = name;
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