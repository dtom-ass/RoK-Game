package model.Warriors;

import java.util.List;
import model.Warrior;

/**
 * Representa un guerrero de tipo lancero.
 */
public class Lancer extends Warrior {

    private static final List<String> WEAPONS = List.of(
            "Tepoztopilli",
            "Lanza de Chonta",
            "Nab'te",
            "Pica de Bronce");

    /**
     * Inicializa atributos base del lancero.
     */
    public Lancer(String name) {

        super(name, 55, 0.85, 0.6, "");

        setWarriorType("Lancero");

        setSpecial(1);
    }

    /**
     * Retorna armas disponibles del lancero.
     */
    @Override
    public List<String> getArmsList() {
        return WEAPONS;
    }
}