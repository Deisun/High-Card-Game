import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Author:  Rob Douma
 * Instructor:  Rashaad Jones
 * Class:  2302
 *
 * AppWindow:  Creates the JavaFX application window and calls the root pane to start the program
 *
 */

public class AppWindow extends Application {
    private Stage stage;
    private Scene gameScene;
    private Scene titleScene;
    private GameView gameView;

    public void start(Stage primaryStage) {
        GameController gameController = new GameController(this);
        stage = primaryStage;

        TitleView titleView = new TitleView(gameController, this);
        gameView = new GameView(gameController, this);

        // create scenes
        titleScene = new Scene(titleView, 1100, 600);
        gameScene = new Scene(gameView, 1100, 600);


        primaryStage.setTitle("High Card");
        primaryStage.setScene(titleScene);
        primaryStage.show();


    }

    public static void main(String[] args) {
        launch(args);
    }

    public void setScene(Scene scene) {
        stage.setScene(scene);
    }

    public Scene getGameScene() {
        return gameScene;
    }

    public Scene getTitleScene() {
        return titleScene;
    }

    public GameView getGameView() {
        return gameView;
    }

    public Stage getStage() {
        return stage;
    }
}
