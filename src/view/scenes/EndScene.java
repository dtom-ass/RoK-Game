package view.scenes;

import java.lang.Thread.State;

import controller.PlayerPanel;
import controller.SelectionController;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;

public class EndScene {
    public static Scene create(State stage, PlayerPanel panel, SelectionController controller) {

        VBox root = new VBox();
        Scene scene = new Scene(root, 800, 600);

        String css = EndScene.class
                .getResource("/view/scenes/styles/End.css")
                .toExternalForm();

        scene.getStylesheets().add(css);

        return scene;
    }

}
