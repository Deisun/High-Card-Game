import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

/**
 * Author:  Rob Douma
 * Instructor:  Rashaad Jones
 * Class:  CS2302
 *
 * DealButton:  Contains the properties and actions of the custom "Deal" button
 */

public class DealButton extends Button {

    private GameController gameController;
    private GameView gameView;

    public DealButton() {
    }

    public DealButton(String name, GameController gameController, GameView gameView) {
        super(name);
        this.gameController = gameController;
        this.gameView = gameView;
        DealButtonHandler handler = new DealButtonHandler();
        setOnAction(handler);
        setDisable(true);
    }

    /**
     * Defines functionality of the Deal button when clicked
     */
    class DealButtonHandler implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent e) {
            gameController.deal();
            gameView.getCardPane().show(gameController.getPlayerList());
            gameView.getWinPane().show();

        }
    }

}