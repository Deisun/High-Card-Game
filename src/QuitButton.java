import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

/**
 * Author:  Rob Douma
 * Instructor:  Rashaad Jones
 * Class:  CS2302
 *
 * QuitButton:  Contains the properties and actions of the custom "Quit" button
 */

public class QuitButton extends Button {

    private GameController gameController;
    private GameView gameView;

    public QuitButton() {
    }

    public QuitButton(String name, GameController gameController, GameView gameView) {
        super(name);
        this.gameController = gameController;
        this.gameView = gameView;
        QuitButtonHandler handler = new QuitButtonHandler();
        setOnAction(handler);
    }

    /**
     * Defines functionality of the Quit button when clicked
     */
    class QuitButtonHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent e) {
            gameController.quit();
        }
    }
}

