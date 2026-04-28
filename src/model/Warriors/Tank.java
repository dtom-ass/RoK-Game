package model.Warriors;
import java.util.ArrayList;
import java.util.List;
import model.Warrior;

/*
 * Clase que representa un guerrero tipo tanque.
 * Hereda atributos y comportamientos de Warrior.
 */
public class Tank extends Warrior {

    /*
     * Constructor que inicializa un guerrero tipo tanque
     * y asigna sus características base.
     */
    public Tank(String name,
            double lifePoints,
            double attackPer,
            double defencePer,
            String specialArm) {

        super(name,
                lifePoints,
                attackPer,
                defencePer,
                specialArm);

        // Configuración inicial de atributos del tanque
        setWarriorType("Tanque");
        

        setLifePoints(75);
        setAttack(0.4);
        setDefence(0.8);

        setSpecial(2);

        /*
         * Se aplica una habilidad especial:
         * 1 = Vida
         * 2 = Ataque
         * 3 = Defensa
         */
    }
    @Override
    public List<String> getArmsList(){
        List<String> Armors = new ArrayList<>();

        Armors.add("Ichcahuipilli");
        Armors.add("Chimalli");
        Armors.add("Escudo de Madera");
        Armors.add("Cascos de Metal");
        return Armors;
    }
}