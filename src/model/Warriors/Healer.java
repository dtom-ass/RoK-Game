package model.Warriors;

import java.util.List;
import model.Warrior;

public class Healer extends Warrior {
    private static final List<String> WEAPONS = List.of("Cuchillos de Obsidiana", "Bolsas de Hierbas",
            "Agujas de Maguey");

    public Healer(String name) {
        super(name, 60, 0.6, 0.4, WEAPONS.get(0));
        setWarriorType("Curador");
        setSpecial(3);
    }

    @Override
    public List<String> getArmsList() {
        return WEAPONS;
    }
}