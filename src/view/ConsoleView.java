package view;

import model.Culture;
import model.Warrior;

/*
 * Vista para interacción por consola.
 */
public class ConsoleView {

    public void showWarriors(Culture culture) {

        System.out.println(
                "Guerreros de " + culture.getName());

        for (Warrior warrior : culture.getWarriorList()) {

            System.out.println(
                    warrior.getName()
                            + " | Vida: " + warrior.getLife()
                            + " | Ataque: " + warrior.getAttack()
                            + " | Defensa: " + warrior.getDefence());
        }
    }

    public void displayMessage(String msg) {
        System.out.println(msg);
    }
}