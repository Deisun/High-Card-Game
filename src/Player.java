/**
 * Author:  Rob Douma
 * Instructor:  Rashaad Jones
 * Date:  03-035/2015
 *
 * HighCardGame Game with UI
 *
 */
public class Player {
    private String name;
    private int wins;
    private Card card;
    private static int playerNum = 1;

    // constructors
    public Player() {
        name = generatePlayerName();
        wins = 0;
    }

    public Player(String name) {
        this.name = name;
        wins = 0;
    }

    // creates a player name "Player1", "Player2", "Player3", etc...
    // for every player
    private String generatePlayerName() {
        String nameString = "Player " + playerNum;
        // static playerNum will persist
        playerNum++;

        return nameString;
    }

    public String getName() {
        return name;
    }

    public void addWin() {
        wins++;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int w) {
        wins = w;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card newCard) {
        card = newCard;
    }

    @Override
    public String toString() {
        return  "Player name:\t" + name + "\t" +
                "Round wins:\t" + wins + "\t" +
                "Card:\t" + card + "\n";
    }
}
