package model;

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
            String specialArm,
            String nativeFrom) {

        super(name,
                lifePoints,
                attackPer,
                defencePer,
                specialArm,
                nativeFrom);

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

}