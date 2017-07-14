import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

/**
 * Author:  Rob Douma
 * Instructor:  Rashaad Jones
 * Class:  2302
 *
 * TitleView:  Shows the title screen and various buttons and options before the game begins.
 *
 */
public class TitleView extends BorderPane {
    private AppWindow appWindow;
    private GameController gameController;
    private ComboBox<String> playerNumberComboBox;

    public TitleView(GameController gameController, AppWindow appWindow) {
        this.appWindow = appWindow;
        this.gameController = gameController;

        setStyle("-fx-background-image: url(\"image/titleBackground.png\"); -fx-background-repeat: stretch; -fx-background-size: 1100 600;");

        setPadding(new Insets(50, 50, 50, 50));

        VBox menu = new VBox();
        menu.setSpacing(20);

        Text title = new Text("High Card");
        title.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 40));

        Text author = new Text("By: Rob Douma\t 2015");
        author.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 18));

        playerNumberComboBox = new ComboBox<>();
        String [] playerNumSelections = {"3 Players", "4 Players", "5 Players", "6 Players", "7 players", "8 Players",
                "9 Players", "10 Players", "11 Players", "12 Players", "13 Players"};

        playerNumberComboBox.setVisibleRowCount(11);
        playerNumberComboBox.setStyle("-fx-color: green");
        playerNumberComboBox.setValue("3 Players");

        ObservableList<String> items = FXCollections.observableArrayList(playerNumSelections);
        playerNumberComboBox.getItems().addAll(items);

        playerNumberComboBox.setOnAction(e -> setPlayers(items.indexOf(playerNumberComboBox.getValue())));

        Button startButton = new Button("Play");
        startButton.setOnAction(e -> playGame());

        menu.getChildren().addAll(title, author, playerNumberComboBox, startButton);

        this.setCenter(menu);

    }

    public void setPlayers(int n) {
        int players = n + 3;
        gameController.setNumPlayers(players);
    }

    public void playGame() {
        appWindow.getGameView().getButtonPane().getPlayButton().setDisable(true);
        appWindow.getGameView().getButtonPane().getDealButton().setDisable(false);
        gameController.play();
        appWindow.setScene(appWindow.getGameScene());
    }

}
