package view.GUI;

import controller.PlayerPanel;
import controller.SelectionController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.Group;
import javafx.stage.Stage;
import view.console.ConsoleLog;

public class guitest extends Application {
    SelectionController SelectionController = new SelectionController(null);
    PlayerPanel panel = new PlayerPanel();
    @Override
    public void start(Stage stage){
        Button btn = new Button("TEST >> Maya");
        btn.setOnAction(e -> {
            ConsoleLog.Log("Selección cultura Maya. - TEST");
            SelectionController.selectMaya();
            
            
        });

        Button btn1 = new Button("TEST >> BASICO");

        btn1.setOnAction(e -> {
            ConsoleLog.Log("Ataque basico. - TEST");
            panel.basicAttack();
        });

        VBox root = new VBox();
        root.getChildren().addAll(btn,btn1);

        Scene scene = new Scene(root, 600, 400);

        stage.setTitle("RoK Combat Game");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        // Lanza la aplicación JavaFX
        launch(args);
    }
}
