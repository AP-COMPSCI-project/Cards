import java.util.*;

public class Deck {
    private Deque<Card> deck;

    public Deck() {
        reset();
        shuffle();
    }

    public void reset() {
        deck = new ArrayDeque<>();
        addSuit(Suit.CLUBS);
        addSuit(Suit.DIAMONDS);
        addSuit(Suit.HEARTS);
        addSuit(Suit.SPADES);
    }

    private void addSuit(Suit suit) {
        for (Rank rank : Rank.values())
            deck.push(new Card(suit, rank));
    }

    public void shuffle() {
        List<Card> list = new ArrayList<>(deck);
        Collections.shuffle(list);
        deck.clear();
        for(Card card : list)
            deck.push(card);
    }

    public Card deal() {
        if(isEmpty()) return null;
        return deck.pop();
    }

    public ArrayList<Card> deal(int count) {
        ArrayList<Card> output = new ArrayList<>();
        if(count > size()) count = size();
        for(int i = 0; i < count; i++)
            output.add(deck.pop());
        return output;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(Card card : deck)
            sb.append(card + "\n");
        return sb.toString();
    }

    public boolean isEmpty() { return deck.isEmpty(); }
    public int size() { return deck.size(); }
}
