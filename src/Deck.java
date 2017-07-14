import java.util.ArrayList;
import java.util.Collections;

/**
 * Author:  Rob Douma
 * Instructor:  Rashaad Jones
 * Date:  03-035/2015
 *
 * Deck class with a shuffle method
 */

public class Deck extends ArrayList<Card> {
    // constructors
    public Deck() {
        // initialize deck to have 52 cards
        // image number corresponds to file names (1.png, 2.png, 3.png, etc..)
        int imageNum = 1;

        // for each suit (0 - spades, 1 - hearts, 2 - diamonds, 3 - clubs)
        for (int suit = 0; suit <= 3; suit++) {
            // for each number 1-13
            for (int cardNum = 1; cardNum <= 13; cardNum++) {
                // Suit.values() returns an array of the enum values
                // generate a card
                Card card = new Card(Suit.values()[suit], cardNum, imageNum);
                // add card to the deck
                this.add(card);

                // increment image number
                imageNum++;
            }
        }

        shuffle();
    }

    // shuffle the stack of cards
    public void shuffle() {
        Collections.shuffle(this);
    }

    @Override
    public String toString() {
        String result = "";


        for (Card c : this) {
            result += "[" + c + "] ";

        }

        return result;
    }
}
