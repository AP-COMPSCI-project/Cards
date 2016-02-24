import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Card implements Comparable<Card> {
    private final Suit suit;
    private final Rank rank;
    private BufferedImage image;
    private boolean faceUp;

    public Card(Suit suit, Rank rank) {
        this.suit = suit;
        this.rank = rank;
        faceUp = false;

        String filename = "src/resources/" + rank.name() + "of" + suit.name() + ".png";
        try {
            image = ImageIO.read(new File(filename));
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

    public Suit getSuit() { return suit; }
    public Rank getRank() { return rank; }
    public BufferedImage getImage() { return image; }
    public boolean isFaceUp() { return faceUp; }
    public void flip() { faceUp = !faceUp; }
    public boolean isRed() { return suit == Suit.HEARTS || suit == Suit.DIAMONDS; }
    public boolean isBalck() { return !isRed(); }
}