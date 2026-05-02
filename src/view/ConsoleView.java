package view;

import java.util.List;

import model.Culture;
import model.Warrior;

/*
 * Vista para interacción por consola.
 */
public class ConsoleView {

    public void showWarriors(Culture culture) {

        System.out.println("\n--- Guerreros de la Cultura " + culture.getName() + " ---");
        List<Warrior> team = culture.getWarriorList();
        for (int i = 0; i < team.size(); i++) {
            Warrior w = team.get(i);
            System.out.printf("[%d] %s (%s) - Vida: %.1f | Atk: %.2f | Def: %.2f%n",
                    i, w.getName(), w.getWarriorType(), w.getLife(), w.getAttack(), w.getDefence());
        }
    }

    public void displayMessage(String msg) {
        System.out.println(msg);
    }
}