import javafx.application.Application;
import javafx.stage.Stage;
import view.scenes.WelcomeScene;

public class Main extends Application {

    @Override
    public void start(Stage stage) {

        stage.setTitle("RoK Combat Game");

        stage.setScene(
            WelcomeScene.create(stage)
        );

        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}