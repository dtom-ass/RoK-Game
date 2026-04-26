package model;

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
            String specialArm,
            String nativeFrom) {

        super(name,
                lifePoints,
                attackPer,
                defencePer,
                specialArm,
                nativeFrom);

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

}