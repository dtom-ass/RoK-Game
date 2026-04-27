package controller;

import model.*;
import model.Cultures.AztecaCulture;
import model.Cultures.MayaCulture;
import view.ConsoleView;

public class ConsoleController {

    private ConsoleView view;

    public ConsoleController(){
        view = new ConsoleView();
    }

    public void start(){
        Culture culture = new MayaCulture();
        CreateTeam newTeam = new CreateTeam("Juagor 1", culture);

        view.displayMessage("-------------------");
        view.showTeam(newTeam);

    }
}   