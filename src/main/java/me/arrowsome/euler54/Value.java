package me.arrowsome.euler54;

public enum Value {
    TWO('2'),
    THREE('3'),
    FOUR('4'),
    FIVE('5'),
    SIX('6'),
    SEVEN('7'),
    EIGHT('8'),
    NINE('9'),
    TEN('T'),
    JACK('J'),
    QUEEN('Q'),
    KING('K'),
    ACE('A');

    private final char valueChar;

    Value(char c) {
        this.valueChar = c;
    }

    public char getValueChar() {
        return valueChar;
    }

    public static Value from(char c) {
        for (Value value : values()) {
            if (value.valueChar == c) {
                return value;
            }
        }
        return null;
    }
}
