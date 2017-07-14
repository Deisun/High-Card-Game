import javafx.geometry.Insets;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.util.ArrayList;

/**
 * Author:  Rob Douma
 * Instructor:  Rashaad Jones
 * Class:  CS2302
 *
 * CardPane:  This class will define the pane that shows the cards in the view
 */
public class CardPane extends FlowPane {

    public CardPane() {
        setPadding(new Insets(50, 50, 50, 50));
    }

    /**
     * Shows every players card for the current hand
     */
    public void show(ArrayList<Player> playerList) {

        // Clear the view out before showing new cards
        clearView();

        // Iterate over each player and add the image of their card to the view
        for (Player p : playerList) {
            VBox pane = new VBox();
            pane.setSpacing(3);
            pane.setPrefWidth(130);
            pane.setPadding(new Insets(0, 0, 30, 0));

            // get players card image, players name and card text
            ImageView imageView = new ImageView(p.getCard().getImage());
            Text playerName = new Text(p.getName());
            Text cardName = new Text(p.getCard().toString());

            pane.getChildren().addAll(playerName, imageView, cardName);
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
