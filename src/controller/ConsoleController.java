package controller;

import model.*;
import model.Cultures.AztecaCulture;
import model.Cultures.IncaCulture;
import model.Cultures.MayaCulture;
import model.Cultures.MuiscaCulture;
import view.ConsoleView;

public class ConsoleController {

    private ConsoleView view;

    public ConsoleController(){
        view = new ConsoleView();
    }

    public void start(){

        // Seleccionamos una cultura
        Culture culture = new MuiscaCulture();
        CreateTeam newTeam = new CreateTeam("Equipo Enemigo", culture); // Creamos el equipo segun la cultura.
        newTeam.setRandomWarriorType(); // Asignamos guerreros con parametros aleatorios
        view.displayMessage("Equipo creado: " + newTeam.getTeamName());
        view.showWarriors(culture); // Mostramos los guerreros del equipo.

    }
}   