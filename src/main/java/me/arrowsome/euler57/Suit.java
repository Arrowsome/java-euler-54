package me.arrowsome.euler57;

public enum Suit {
    HEART('H'),
    CLUB('C'),
    SPADE('S'),
    DIAMOND('D');

    private final char suitChar;

    private Suit(char c) {
        this.suitChar = c;
    }

    public char getSuitChar() {
        return suitChar;
    }

    public static Suit from(char c) {
        for (Suit suit : values()) {
            if (suit.suitChar == c) {
                return suit;
            }
        }
        return null;
    }

}
