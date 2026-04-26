package model;

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
            String specialArm,
            String nativeFrom) {

        super(name,
                lifePoints,
                attackPer,
                defencePer,
                specialArm,
                nativeFrom);

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

}