package model.Cultures;

import java.util.List;

import model.Culture;

/**
 * Representa la cultura Inca.
 */
public class IncaCulture extends Culture {

    private static final List<String> WARRIOR_NAMES = List.of(
            "Pachacútec",
            "Huayna Cápac",
            "Atahualpa",
            "Tupac Yupanqui",
            "Manco Cápac",
            "Quispe",
            "Sayri",
            "Amaru",
            "Illapa",
            "Chasca"
    );

    /**
     * Inicializa atributos base de la cultura.
     */
    public IncaCulture() {

        super(
            "Inca",
            0,
            "Poder Inca"
        );
    }

    /**
     * Retorna nombres disponibles para guerreros incas.
     */
    @Override
    public List<String> getWarriorNameList() {
        return WARRIOR_NAMES;
    }

}