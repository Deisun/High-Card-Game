import javafx.geometry.Insets;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.util.ArrayList;

/**
 * Author:  Rob Douma
 * Instructor:  Rashaad Jones
 * Class:  CS2302
 *
 * WinPane:  Container pane for the winners of each round
 */
public class WinPane extends VBox {
    private ArrayList<Player> winnerList;
    private GameController gameController;

    public WinPane(GameController gameController) {
        this.gameController = gameController;

        setPadding(new Insets(20, 0, 20, 300));
    }

    public void show() {
        winnerList = gameController.getWinnerList();

        // Clear the view out before showing new cards
        clearView();

        // Iterate over each player and add the image of their card to the view

        for (Player p : winnerList) {
            VBox pane = new VBox();
            pane.setSpacing(3);
            pane.setPadding(new Insets(0, 0, 10, 0));

            Text playerName = new Text("Winner:\t" + p.getName() + " had the highest card with: " + p.getCard().toString());

            pane.getChildren().addAll(playerName);
            getChildren().add(pane);
        }
    }

    /**
     * Clear the view.
     */
    private void clearView() {
        getChildren().clear();
    }
}


