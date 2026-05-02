package model.Warriors;

import java.util.List;
import model.Warrior;

/**
 * Representa un guerrero de tipo tanque.
 */
public class Tank extends Warrior {

    private static final List<String> WEAPONS = List.of(
            "Ichcahuipilli",
            "Chimalli",
            "Escudo de Madera",
            "Cascos de Metal");

    /**
     * Inicializa atributos base del tanque.
     */
    public Tank(String name) {

        super(name, 70, 0.4, 0.8, "");

        setWarriorType("Tanque");

        setSpecial(2);
    }

    /**
     * Retorna armas disponibles del tanque.
     */
    @Override
    public List<String> getArmsList() {
        return WEAPONS;
    }
}