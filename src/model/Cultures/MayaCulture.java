package model.Cultures;

import java.util.List;

import model.Culture;

/**
 * Representa la cultura Maya.
 */
public class MayaCulture extends Culture {

    private static final List<String> WARRIOR_NAMES = List.of(
            "Itzamná",
            "K’inich",
            "Ixchel",
            "Balam",
            "Yaxun",
            "Naabil",
            "Zac-Nicté",
            "Kaknab",
            "Canek",
            "Nicte-Ha"
    );

    /**
     * Inicializa atributos base de la cultura.
     */
    public MayaCulture() {

        super(
            "Maya",
            0,
            "Habilidad Maya"
        );
    }

    /**
     * Retorna nombres disponibles para guerreros mayas.
     */
    @Override
    public List<String> getWarriorNameList() {
        return WARRIOR_NAMES;
    }

}