import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
Represents a single playing card. Has a suit, rank, image and status (face up or face down).
*/

public class Card implements Comparable<Card> {
    private final Suit suit;
    private final Rank rank;
    private BufferedImage face;
    private static BufferedImage back;
    private boolean faceUp;

    // Initializes BufferedImage back
    static {
        try {
            back = ImageIO.read(new File("src/resources/cardback.jpeg"));
        } catch (IOException e) {
            System.out.println("cardback.jpeg could not be loaded");
        }
    }

    /**
    Only constructor for the Card class. Sets up the card as face down, and attempts to load
     an image based on the card's suit and rank values. If it cannot load the image, it will
     print a message with the path and name of the image that it tried to load (but couldn't find).
    */
    public Card(Suit suit, Rank rank) {
        this.suit = suit;
        this.rank = rank;
        faceUp = false;

        String filename = "src/resources/" + rank.name() + "of" + suit.name() + ".jpeg";
        try {
            face = ImageIO.read(new File(filename));
        } catch (IOException e) {
            System.out.println("Error: Could not load image resource \"" + filename + "\"");
        }
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Card)) return false;
        return compareTo((Card)obj) == 0;
    }

    @Override
    public int compareTo(Card card) { return rank.compareTo(card.rank); }

    @Override
    public String toString() { return rank + " of " + suit; }

    /**
     Gets the face (the side with the suit and rank) of this card.
     */
    public BufferedImage getFace() { return face; }

    /**
     Gets the back of this card.
     */
    public BufferedImage getBac() { return back; }

    public Suit getSuit() { return suit; }
    public Rank getRank() { return rank; }
    public boolean isFaceUp() { return faceUp; }
    public void flip() { faceUp = !faceUp; }
    public boolean isRed() { return suit == Suit.HEARTS || suit == Suit.DIAMONDS; }
    public boolean isBalck() { return !isRed(); }
}
