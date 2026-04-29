package model.Cultures;

import java.util.List;

import model.Culture;

/**
 * Representa la cultura Muisca.
 */
public class MuiscaCulture extends Culture {

    private static final List<String> WARRIOR_NAMES = List.of(
            "Nemequene",
            "Saguanmachica",
            "Meicuchuca",
            "Aquiminzaque",
            "Michuá",
            "Saguamanchica",
            "Hunzahúa",
            "Tundama",
            "Idacansá",
            "Sugamuxi"
    );

    /**
     * Inicializa atributos base de la cultura.
     */
    public MuiscaCulture() {

        super(
            "Muisca",
            0,
            "Poder Muisca"
        );
    }

    /**
     * Retorna nombres disponibles para guerreros muiscas.
     */
    @Override
    public List<String> getWarriorNameList() {
        return WARRIOR_NAMES;
    }

}