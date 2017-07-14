import javafx.geometry.Insets;
import javafx.scene.layout.VBox;

/**
 * Author:  Rob Douma
 * Instructor:  Rashaad Jones
 * Class:  CS2302
 *
 * ButtonPane:  container object for the 3 main buttons of the game (play, deal, quit)
 */
public class ButtonPane extends VBox {
    private GameController gameController;
    private GameView gameView;
    private PlayButton playButton;
    private DealButton dealButton;
    private QuitButton quitButton;

    public ButtonPane(GameController gameController, GameView gameView) {
        this.gameController = gameController;
        this.gameView = gameView;

        createButtons();

        this.setPadding(new Insets(11, 11, 11, 11));
        this.setSpacing(50);
        this.getChildren().addAll(playButton, dealButton, quitButton);
    }

    /**
     * Create 3 buttons (Play, Deal, Quit) and pass in the gameController object
     */
    public void createButtons() {
        playButton = new PlayButton("Play", gameController, gameView);
        dealButton = new DealButton("Deal", gameController, gameView);
        quitButton = new QuitButton("Quit", gameController, gameView);
    }

    public PlayButton getPlayButton() {
        return playButton;
    }

    public DealButton getDealButton() {
        return dealButton;
    }

    public QuitButton getQuitButton() {
        return quitButton;
    }
}
