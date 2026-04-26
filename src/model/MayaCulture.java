package model;

/*
 * Representa la cultura Maya
 * y sus guerreros iniciales.
 */
public class MayaCulture extends Culture {

    public MayaCulture(){

        super(
            "Maya",
            0,
            "Habilidad Maya"
        );

        /*
         * Registro inicial de guerreros.
         */
        addWarrior(new Tank(
            "Balam",0,0,0,
            "Escudo","Maya"
        ));

        addWarrior(new Lancer(
            "Itzam",0,0,0,
            "Lanza","Maya"
        ));

        addWarrior(new Archer(
            "Kukulkan",0,0,0,
            "Arco","Maya"
        )); 

        addWarrior(new Fighter(
            "Ahau",0,0,0,
            "Macana","Maya"
        ));

        addWarrior(new Healer( 
            "Ixchel",0,0,0,
            "Báculo","Maya"
        ));
    } 

}    