package model.Warriors;

import java.util.List;
import model.Warrior;

public class Lancer extends Warrior {
    private static final List<String> WEAPONS = List.of("Tepoztopilli", "Lanza de Chonta", "Nab'te", "Pica de Bronce");

    public Lancer(String name) {
        super(name, 55, 0.85, 0.6, WEAPONS.get(0));
        setWarriorType("Lancero");
        setSpecial(1);
    }

    @Override
    public List<String> getArmsList() {
        return WEAPONS;
    }
}