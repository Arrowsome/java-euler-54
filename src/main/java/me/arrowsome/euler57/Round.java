package me.arrowsome.euler57;

import java.util.List;

public class Round {
    private final List<Card> player1Cards;
    private final List<Card> player2Cards;

    public Round(List<Card> cards) {
        player1Cards = cards.subList(0, 5);
        player2Cards = cards.subList(5, 10);
        // break down cards between players
    }

    @Override
    public String toString() {
        return String.format(
                "Player 1: %s\nPlayer 2: %s",
                player1Cards,
                player2Cards
        );
    }
}
