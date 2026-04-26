package controller;

import model.*;
import view.ConsoleView;

public class ConsoleController {

    private ConsoleView view;

    public ConsoleController(){
        view = new ConsoleView();
    }

    public void start(){

        MayaCulture maya = new MayaCulture();

        view.showWarriors(maya);

    }
}   