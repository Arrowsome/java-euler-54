package me.arrowsome.euler54;

public class Card implements Comparable<Card> {
    private final Value value;
    private final Suit suit;

    public Card(Value value, Suit suit) {
        this.value = value;
        this.suit = suit;
    }

    public Value getValue() {
        return value;
    }

    public Suit getSuit() {
        return suit;
    }

    @Override
    public String toString() {
        return String.format(
                "%s%s",
                value.getValueChar(),
                suit.getSuitChar()
        );
    }

    @Override
    public int compareTo(Card o) {
        return value.compareTo(o.value);
    }
}
