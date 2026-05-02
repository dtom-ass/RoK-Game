package controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import model.Culture;
import model.Cultures.AztecaCulture;
import model.Cultures.IncaCulture;
import model.Cultures.MayaCulture;
import model.Cultures.MuiscaCulture;
import model.Warrior;
import model.Warriors.Archer;
import model.Warriors.Fighter;
import model.Warriors.Healer;
import model.Warriors.Lancer;
import model.Warriors.Tank;
import view.MainMenuView;

/**
 * Controla selección de cultura
 * y generación del equipo inicial.
 */
public class SelectionController {

    private final Scanner scanner;
    private final Random random;

    private final List<Culture> availableCultures = List.of(
            new AztecaCulture(),
            new IncaCulture(),
            new MayaCulture(),
            new MuiscaCulture());

    public SelectionController(Scanner scanner) {

        this.scanner = scanner;
        this.random = new Random();
    }

    public List<Culture> getAvailableCultures() {
        return availableCultures;
    }

    /**
     * Ejecuta proceso de selección.
     */
    public Culture selectCulture() {

        MainMenuView.showAvailableCultures(
                availableCultures);

        Culture selectedCulture = readCultureChoice();

        generateRandomTeam(selectedCulture);

        return selectedCulture;
    }

    /**
     * Lee opción del usuario.
     */
    private Culture readCultureChoice() {

        int choice = -1;

        while (choice < 1 ||
                choice > availableCultures.size()) {

            if (scanner.hasNextInt()) {

                choice = scanner.nextInt();

                if (choice < 1 ||
                        choice > availableCultures.size()) {

                    MainMenuView.showInvalidOption();
                }

            } else {

                scanner.next();

                MainMenuView.showInvalidOption();
            }
        }

        return availableCultures.get(choice - 1);
    }

    /**
     * Genera equipo aleatorio sin repetir nombres.
     */
    private void generateRandomTeam(Culture culture) {

        List<String> names = culture.getWarriorNameList();

        List<Integer> indices = new ArrayList<>();

        for (int i = 0; i < names.size(); i++) {
            indices.add(i);
        }

        Collections.shuffle(indices);

        for (int i = 0; i < 3; i++) {

            String name = names.get(indices.get(i));

            Warrior warrior = createRandomWarrior(name);

            warrior.setWeapon(
                    warrior.getArmsList().get(
                            random.nextInt(
                                    warrior.getArmsList().size())));

            culture.addWarrior(warrior);
        }
    }

    /**
     * Crea guerrero aleatorio.
     */
    private Warrior createRandomWarrior(String name) {

        return switch (random.nextInt(5)) {

            case 0 -> new Archer(name);
            case 1 -> new Fighter(name);
            case 2 -> new Healer(name);
            case 3 -> new Lancer(name);

            default -> new Tank(name);
        };
    }

}