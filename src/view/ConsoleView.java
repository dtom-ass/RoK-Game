package view;

import controller.CreateTeam;
import model.Culture;
import model.Warrior;

/*
 * Vista para interacción por consola.
 */
public class ConsoleView {

    public void showWarriors(Culture culture) {

        System.out.println(
                "Guerreros de la Cultura " + culture.getName());

        for (Warrior warrior : culture.getWarriorList()) {

            System.out.println(
                    warrior.getName()
                            + " | Vida: " + warrior.getLife()
                            + " | Ataque: " + warrior.getAttack()
                            + " | Defensa: " + warrior.getDefence()
                        + " | Tipo: " + warrior.getWarriorType());
        }
    }

    public void showTeam(CreateTeam team){
        System.out.println(team.testTeam());
        System.out.println(team.testCult());
        for (Warrior warrior : team.testTeamSt()) {

            System.out.println(
                    warrior.getName()
                            + " | Vida: " + warrior.getLife()
                            + " | Ataque: " + warrior.getAttack()
                            + " | Defensa: " + warrior.getDefence()
                        + " | Tipo: " + warrior.getWarriorType());
        }
    }

    public void displayMessage(String msg) {
        System.out.println(msg);
    }
}