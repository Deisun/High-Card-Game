
import javafx.geometry.Insets;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

/**
 * Author:  Rob Douma
 * Instructor:  Rashaad Jones
 * Class:  CS2302
 *
 * GameView:  This class will define the root pane that will contain all other UI panes and nodes
 */

public class GameView extends BorderPane {

    // data members
    private AppWindow appWindow;
    private GameController gameController;
    private ButtonPane buttonPane;
    private CardPane cardPane;
    private WinPane winPane;

    // constructors
    public GameView(GameController gameController, AppWindow appWindow) {
        this.appWindow = appWindow;
        this.gameController = gameController;
        setLeftPane();
        setCenterPane();
        setBottomPane();
    }

    public GameController getGameController() {
        return gameController;
    }

    public CardPane getCardPane() {
        return cardPane;
    }

    public WinPane getWinPane() {
        return winPane;
    }

    public ButtonPane getButtonPane() {
        return buttonPane;
    }

    public void setLeftPane() {
        buttonPane = new ButtonPane(gameController, this);
        this.setLeft(buttonPane);
    }

    public void setCenterPane() {
        cardPane = new CardPane();
        this.setCenter(cardPane);
    }

    public void setBottomPane() {
        winPane = new WinPane(gameController);
        this.setBottom(winPane);
    }


}
