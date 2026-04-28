package model.Warriors;
import java.util.ArrayList;
import java.util.List;

import model.Warrior;

/*
 * Clase que representa un guerrero tipo sanador.
 * Hereda atributos y comportamientos de Warrior.
 */
public class Healer extends Warrior {

    /*
     * Constructor que inicializa un guerrero tipo sanador
     * con sus atributos base.
     */
    public Healer(String name,
            double lifePoints,
            double attackPer,
            double defencePer,
            String specialArm) {

        super(name,
                lifePoints,
                attackPer,
                defencePer,
                specialArm);

        // Configuración inicial de atributos del sanador
        setLifePoints(80); // Rango estimado: 0 - 100
        setAttack(0.6); // Rango estimado: 0 - 1
        setDefence(0.2); // Rango estimado: 0 - 1

        /*
         * Se aplica una habilidad especial:
         * 1 = Vida
         * 2 = Ataque
         * 3 = Defensa
         */
        setSpecial(3);
    }

    public String getWarriorType() {
        return "Curador";
    }
    @Override
    public List<String> getArmsList(){
        List<String> Armors = new ArrayList<>();

        Armors.add("Cuchillos de Obsidiana");
        Armors.add("Bolsas de Hierbas");
        Armors.add("Agujas de Maguey");
        return Armors;
    }
}