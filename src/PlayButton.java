import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

/**
 *  PlayButton
 *  1.  Shuffles the cards
 *  2.  Becomes disabled once the game has started and there are cards remaining in the deck
 *  3.  Resets the number of wins per user
 */

public class PlayButton extends Button {

    private GameView gameView;
    private GameController gameController;

    public PlayButton() {
    }

    public PlayButton(String buttonText, GameController gameController, GameView gameView) {
        super(buttonText);
        this.gameController = gameController;
        this.gameView = gameView;
        PlayButtonHandler handler = new PlayButtonHandler();
        setOnAction(handler);
    }

    /**
     * Defines functionality of the Play button when clicked
     */
    class PlayButtonHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent e) {
            setDisable(true);
            gameView.getButtonPane().getDealButton().setDisable(false);
            gameController.play();

        }
    }
}
