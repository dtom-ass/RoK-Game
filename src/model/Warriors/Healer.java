package model.Warriors;

import java.util.List;
import model.Warrior;

/**
 * Representa un guerrero de tipo sanador.
 */
public class Healer extends Warrior {

    private static final List<String> WEAPONS = List.of(
            "Cuchillos de Obsidiana",
            "Bolsas de Hierbas",
            "Agujas de Maguey");

    /**
     * Inicializa atributos base del sanador.
     */
    public Healer(String name) {

        super(name, 60, 0.6, 0.4, "");

        setWarriorType("Curador");

        setSpecial(3);
    }

    /**
     * Retorna armas disponibles del sanador.
     */
    @Override
    public List<String> getArmsList() {
        return WEAPONS;
    }
}