package me.arrowsome.euler57;

public class Card {
    private final Value value;
    private final Suit suit;

    public Card(Value value, Suit suit) {
        this.value = value;
        this.suit = suit;
    }

    @Override
    public String toString() {
        return String.format(
                "%s%s",
                value.getValueChar(),
                suit.getSuitChar()
        );
    }
}
