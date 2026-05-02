package model.Warriors;

import java.util.List;
import model.Warrior;

public class Tank extends Warrior {
    private static final List<String> WEAPONS = List.of("Ichcahuipilli", "Chimalli", "Escudo de Madera",
            "Cascos de Metal");

    public Tank(String name) {
        super(name, 70, 0.4, 0.8, WEAPONS.get(0));
        setWarriorType("Tanque");
        setSpecial(2);
    }

    @Override
    public List<String> getArmsList() {
        return WEAPONS;
    }
}