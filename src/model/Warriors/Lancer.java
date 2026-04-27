package model.Warriors;

import java.util.ArrayList;
import java.util.List;

import model.Warrior;

/*
 * Clase que representa un guerrero tipo lancero.
 * Hereda atributos y comportamientos de Warrior.
 */
public class Lancer extends Warrior {

    /*
     * Constructor que inicializa un guerrero tipo lancero
     * con sus atributos base.
     */
    public Lancer(String name,
            double lifePoints,
            double attackPer,
            double defencePer,
            String specialArm) {

        super(name,
                lifePoints,
                attackPer,
                defencePer,
                specialArm);

        // Configuración inicial de atributos del lancero
        setLifePoints(70); // Rango estimado: 0 - 100
        setAttack(0.9); // Rango estimado: 0 - 1
        setDefence(1); // Rango estimado: 0 - 1

        /*
         * Se aplica una habilidad especial:
         * 1 = Vida
         * 2 = Ataque
         * 3 = Defensa
         */
        setSpecial(1);
    }

    public String getWarriorType() {
        return "Lancero";
    }

    @Override
    public void setArmsList(){
        List<String> Armors = new ArrayList<>();

        Armors.add("Tepoztopilli");
        Armors.add("Lanza de Chonta");
        Armors.add("Nab'te");
        Armors.add("Pica de Bronce");
    }

}