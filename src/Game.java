import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.*;

public class Game extends JPanel {
    private Deck stock;
    private Deque<Card> waste;
    private Deque<Card> hearts;
    private Deque<Card> diamonds;
    private Deque<Card> clubs;
    private Deque<Card> spades;
    private Deque[] tableau;
    private boolean winning = false;

    // Set up and display the window
    public static void main(String[] args) {
        JFrame frame = new JFrame("Solitaire");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setResizable(false);
        Game game = new Game();
        frame.setContentPane(game);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    /**
    Initialization stuff.
    */
    public Game() {
        // The physical panel
        super();
        setBackground(Color.green);
        setPreferredSize(new Dimension(1100, 600));
        setDoubleBuffered(true);

        // The components of the panel
        stock = new Deck();
        waste = new ArrayDeque<>();
        hearts = new ArrayDeque<>();
        diamonds = new ArrayDeque<>();
        clubs = new ArrayDeque<>();
        spades = new ArrayDeque<>();
        tableau = new ArrayDeque[7];

        for(int i = 0; i < tableau.length; i++)
            tableau[i] = new ArrayDeque<>();

        for(int i = 0; i < tableau.length; i++)
            tableau[i].addAll(stock.deal(i + 1));
    }

    /**
    Draws the GUI components to the screen.
    */
    @Override
    public void paintComponents(Graphics g) {
        // Paints the stock
        if(stock.isEmpty())
            g.drawRoundRect(10, 10, 150, 200, 20, 20);
//        else
//            g.drawImage()
    }
}




















