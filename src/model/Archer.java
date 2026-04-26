package model;

/*
 * Clase que representa un guerrero tipo arquero.
 * Hereda atributos y comportamientos de Warrior.
 */
public class Archer extends Warrior {

    /*
     * Constructor que inicializa un guerrero tipo arquero
     * con sus atributos base.
     */
    public Archer(String name,
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

        // Configuración inicial de atributos del arquero
        setLifePoints(75); // Rango estimado: 0 - 100
        setAttack(0.7); // Rango estimado: 0 - 1
        setDefence(0.6); // Rango estimado: 0 - 1

        /*
         * Se aplica una habilidad especial:
         * 1 = Vida
         * 2 = Ataque
         * 3 = Defensa
         */
        setSpecial(1);
    }

    public String getWarriorType() {
        return "Arquero";
    }

}