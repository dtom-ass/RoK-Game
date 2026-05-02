package model.Warriors;

import java.util.List;
import model.Warrior;

/**
 * Representa un guerrero de tipo arquero.
 */
public class Archer extends Warrior {

    private static final List<String> WEAPONS = List.of(
            "Estólica",
            "Waraka",
            "Cerbatana",
            "Arco y Flecha");

    /**
     * Inicializa atributos base del arquero.
     */
    public Archer(String name) {

        super(name, 55, 0.7, 0.5, "");

        setWarriorType("Arquero");

        setSpecial(1);
    }

    /**
     * Retorna armas disponibles del arquero.
     */
    @Override
    public List<String> getArmsList() {
        return WEAPONS;
    }

}