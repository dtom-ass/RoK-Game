package view.GUI;

import controller.PlayerPanel;
import controller.SelectionController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import view.console.ConsoleLog;

public class guitest{
    public static Scene create(Stage stage){
        PlayerPanel panel = new PlayerPanel();
        SelectionController SelectionController = new SelectionController(panel);
    
        Button btn = new Button("TEST >> Azteca");
        btn.setOnAction(e -> {
            ConsoleLog.Log("Selección cultura Azteca. - TEST");
            SelectionController.selectAzteca();
            
        });
        Button btna = new Button("TEST >> Maya");
        btna.setOnAction(e -> {
            ConsoleLog.Log("Selección cultura Maya. - TEST");
            SelectionController.selectMaya();
            
        });
        Button btnb = new Button("TEST >> Inca");
        btnb.setOnAction(e -> {
            ConsoleLog.Log("Selección cultura Inca. - TEST");
            SelectionController.selectInca();
            
        });
        Button btnc = new Button("TEST >> Muisca");
        btnc.setOnAction(e -> {
            ConsoleLog.Log("Selección cultura Muisca. - TEST");
            SelectionController.selectMuisca();
            
        });

        Button btn1 = new Button("TEST >> BASICO");
        Button btn2 = new Button("TEST >> ESPECIAL");

        btn1.setOnAction(e -> {
            ConsoleLog.Log("Ataque basico. - TEST");
            panel.basicAttack();
        });

        btn2.setOnAction(e -> {
            ConsoleLog.Log("Ataque basico. - TEST");
            panel.specialAttack();
        });

        Button btnX = new Button("CHANGE WARRIOR");
        btnX.setOnAction( e -> {
            panel.ChangeWarrior();
        });

        Button ENEMYATTACK = new Button("<< TEST >> ATAQUE ENEMIGO");
        ENEMYATTACK.setOnAction(e -> {
            panel.getBattle().enemyTurn();
        });

        VBox root = new VBox();
        root.getChildren().addAll(btn,btna,btnb,btnc,btn1,btn2,btnX,ENEMYATTACK);
        
        return new Scene(root, 800, 600);

    }

}
