import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;

import java.util.ArrayList;
import java.util.Optional;
/**
 * Author:  Rob Douma
 * Instructor:  Rashaad Jones
 * Class:  CS2302
 *
 * GameController:  controls all elements of the game
 */
public class GameController {

    private AppWindow appWindow;
    private Deck deck;
    private ArrayList<Player> playerList;
    private ArrayList<Player> winnerList;

    // default value of 3 for players ** do not change **
    private int numPlayers = 3;
    private int round = 0;
    private final int TOTAL_ROUNDS = 13;

    public GameController(AppWindow appWindow) {
        this.appWindow = appWindow;
    }

    public void createDeck() {
        deck = new Deck();
    }

    // Create the players
    public void createPlayers() {
        playerList = new ArrayList<Player>();
        for (int playerIndex = 0; playerIndex < numPlayers; playerIndex++) {
            playerList.add(new Player());
        }
    }

    public int getNumPlayers() {
        return numPlayers;
    }

    public void setNumPlayers(int newNumPlayers) {
        numPlayers = newNumPlayers;
    }

    public void play() {
        createDeck();
        createPlayers();
        // reset wins for all players
        for (Player p : playerList) {
            p.setWins(0);
        }
        deal();
    }

    public void deal() {
        if (deck.size() > 0 && round <= 13) {
            // each player removes a card from the deck
            for (Player p : playerList) {
                Card card;
                if (deck.size() > 0) {
                    card = deck.remove(0);
                    p.setCard(card);
                }
            }
            checkRoundWinner();
            updateView();
            round++;
        } else {
            // game is over
            checkGameWinner();
            round = 0;
        }
    }

    public void checkGameWinner() {
        ArrayList<Player> gameWinners = new ArrayList<>();
        int highestWins = 0;
        Player winner = null;
        for (Player p : playerList) {
            if (p.getWins() > highestWins) {
                highestWins = p.getWins();
            }
        }

        for (Player p : playerList) {
            if (p.getWins() == highestWins) {
                gameWinners.add(p);
            }
        }
        showGameWinner(gameWinners);
    }

    public void showGameWinner(ArrayList<Player> gameWinners) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Winner");
        alert.setHeaderText("And the winner is:");

        String winnersString = "";
        for (Player p : gameWinners) {
            winnersString += p.getName() + " with " + p.getWins() + " wins!\n";
        }

        Label label = new Label("Winners: ");
        TextArea textArea = new TextArea(winnersString);
        textArea.setEditable(false);
        textArea.setWrapText(true);
        textArea.setMaxWidth(Double.MAX_VALUE);
        textArea.setMaxHeight(Double.MAX_VALUE);
        GridPane.setVgrow(textArea, Priority.ALWAYS);
        GridPane.setHgrow(textArea, Priority.ALWAYS);
        GridPane expContent = new GridPane();
        expContent.setMaxWidth(Double.MAX_VALUE);
        expContent.add(label, 0, 0);
        expContent.add(textArea, 0, 1);
        alert.getDialogPane().setContent(expContent);
        alert.showAndWait();
    }

    public void checkRoundWinner() {
        winnerList = new ArrayList<>();
        // cycle through the players cards to find which card has the highest value
        int highestCardRank = 0;
        for (Player p : playerList) {
            if (p.getCard().getRank() > highestCardRank) {
                highestCardRank = p.getCard().getRank();
            }
        }
        // find all players with a card with this highest value and add to winners array list
        for (Player p : playerList) {
            if (p.getCard().getRank() == highestCardRank) {
                winnerList.add(p);
                p.addWin();
            }
        }
    }

    public ArrayList<Player> getWinnerList() {
        return winnerList;
    }

    public ArrayList<Player> getPlayerList() {
        return playerList;
    }

    public void quit() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Quit");
        alert.setHeaderText("Quit High Card game.");
        alert.setContentText("Are you sure you want to quit?");

        ButtonType buttonTypeQuit = new ButtonType("Quit");
        ButtonType buttonTypePlayAgain = new ButtonType("Play again");

        alert.getButtonTypes().setAll(buttonTypeQuit, buttonTypePlayAgain);

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == buttonTypeQuit) {
            appWindow.getStage().close();
        } else {
            appWindow.setScene(appWindow.getTitleScene());
        }
    }

    public void updateView() {
        GameView gameView = appWindow.getGameView();
        gameView.getCardPane().show(getPlayerList());
        gameView.getWinPane().show();
    }
}