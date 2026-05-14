package view.scenes;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import view.GUI.guitest;
import view.console.ConsoleLog;

public class WelcomeScene {

    public static Scene create(Stage stage) {
        ConsoleLog.Log("INICIANDO ESCENA: WelcomeScene");
        Button startBtn = new Button("Iniciar");

        Button exitBtn = new Button("Salir");

         startBtn.setOnAction(e -> {
            // Hacemos pruebas con  guitest
            ConsoleLog.Log("CAMBIO DE ESCENA: GUI TEST");
            stage.setScene(
                guitest.create(stage)
            );
        });
        exitBtn.setOnAction(e -> {
            stage.close();
        });

        VBox root = new VBox(
                20,
                startBtn,
                exitBtn);

        return new Scene(root, 800, 600);
    }
}