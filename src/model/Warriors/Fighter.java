package model.Warriors;

import java.util.List;

import model.Warrior;

/**
 * Representa un guerrero de tipo peleador.
 */
public class Fighter extends Warrior {

    private static final List<String> WEAPONS = List.of(
            "Macuahuitl",
            "Macana",
            "Hacha",
            "Garrote",
            "Cuchillo"
    );

    /**
     * Inicializa atributos base del peleador.
     */
    public Fighter(String name) {

        super(name,0,0,0,"");

        updateLife(60);
        updateAttack(0.9);
        updateDefence(0.3);

        setWarriorType("Peleador");

        setSpecial(2);
    }

    /**
     * Retorna armas disponibles del peleador.
     */
    @Override
    public List<String> getArmsList() {
        return WEAPONS;
    }
}