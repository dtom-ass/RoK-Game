package model.Warriors;

import java.util.ArrayList;
import java.util.List;

import model.Warrior;

/*
 * Clase que representa un guerrero tipo combatiente.
 * Hereda atributos y comportamientos de Warrior.
 */
public class Fighter extends Warrior {

    /*
     * Constructor que inicializa un guerrero tipo combatiente
     * con sus atributos base.
     */
    public Fighter(String name,
            double lifePoints,
            double attackPer,
            double defencePer,
            String specialArm) {

        super(name,
                lifePoints,
                attackPer,
                defencePer,
                specialArm);

        // Configuración inicial de atributos del combatiente
        setLifePoints(85); // Rango estimado: 0 - 100
        setAttack(0.9); // Rango estimado: 0 - 1
        setDefence(0.2); // Rango estimado: 0 - 1

        /*
         * Se aplica una habilidad especial:
         * 1 = Vida
         * 2 = Ataque
         * 3 = Defensa
         */
        setSpecial(2);
    }

    public String getWarriorType() {
        return "Peleador";
    }
    @Override
    public void setArmsList(){
        List<String> Armors = new ArrayList<>();

        Armors.add("Macuahuitl ");
        Armors.add("Macana");
        Armors.add("Hacha");
        Armors.add("Garrote");
        Armors.add("Cuchillo");
    }
}