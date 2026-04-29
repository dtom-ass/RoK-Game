package model.Cultures;

import java.util.List;

import model.Culture;

/**
 * Representa la cultura Azteca.
 */
public class AztecaCulture extends Culture {

    private static final List<String> WARRIOR_NAMES = List.of(
            "Cuauhtémoc",
            "Moctezuma",
            "Cuitláhuac",
            "Itzcóatl",
            "Axayácatl",
            "Xipil",
            "Ilhuicamina",
            "Tenoch",
            "Citlalli",
            "Tizoc"
    );

    /**
     * Inicializa atributos base de la cultura.
     */
    public AztecaCulture() {

        super(
            "Azteca",
            0,
            "Habilidad Azteca"
        );
    }

    /**
     * Retorna nombres disponibles para guerreros aztecas.
     */
    @Override
    public List<String> getWarriorNameList() {
        return WARRIOR_NAMES;
    }

}