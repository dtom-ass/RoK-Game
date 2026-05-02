package model.Warriors;

import java.util.List;
import model.Warrior;

public class Fighter extends Warrior {
    private static final List<String> WEAPONS = List.of("Macuahuitl", "Macana", "Hacha", "Garrote", "Cuchillo");

    public Fighter(String name) {
        super(name, 60, 0.9, 0.3, WEAPONS.get(0));
        setWarriorType("Peleador");
        setSpecial(2);
    }

    @Override
    public List<String> getArmsList() {
        return WEAPONS;
    }
}