import javafx.scene.image.Image;

/**
 * Author:  Rob Douma
 * Instructor:  Rashaad Jones
 * Date:  03-035/2015
 *
 * Card class:  Contains the card object that will store ranks, images and text descriptions of the cards
 *
 */
public class Card {
    // one of the four suits of cards - clubs, hearts, diamonds, spades
    private Suit suit;
    // the value of this card - Ace:  1,  Jack-King:  11-13
    private int rank;
    // image of the card
    private Image image;

    // constructors
    public Card (Suit suit, int rank, int imageNum) {
        this.suit = suit;

        // check to make sure value is valid
        if (rank >= 1 && rank <= 13)
            this.rank = rank;
        else {
            throw new IllegalArgumentException();
        }

        // create imageString for filenames (1.png, 2.png, 3.png, etc..)
        String imageString = "image/" + imageNum + ".png";
        image = new Image(imageString);
    }

    // methods
    public int getRank() {
        return rank;
    }

    public Suit getSuit() {
        return suit;
    }

    public Image getImage() {
        return image;
    }

    @Override
    public String toString() {

        String numString = "";

        switch(rank) {
            case 1:
                numString = "Ace";
                break;
            case 2:
                numString = "Two";
                break;
            case 3:
                numString = "Three";
                break;
            case 4:
                numString = "Four";
                break;
            case 5:
                numString = "Five";
                break;
            case 6:
                numString = "Six";
                break;
            case 7:
                numString = "Seven";
                break;
            case 8:
                numString = "Eight";
                break;
            case 9:
                numString = "Nine";
                break;
            case 10:
                numString = "Ten";
                break;
            case 11:
                numString = "Jack";
                break;
            case 12:
                numString = "Queen";
                break;
            case 13:
                numString = "King";
                break;
            default:
                break;
        }

        return numString + " of " + suit;
    }
}
