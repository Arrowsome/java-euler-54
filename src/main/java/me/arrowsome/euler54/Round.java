package me.arrowsome.euler54;

import java.util.List;

public class Round {
    private final Hand player1;
    private final Hand player2;

    public Round(List<Card> cards) {
        player1 = new Hand(cards.subList(0, 5));
        player2 = new Hand(cards.subList(5, 10));
    }

    public int checkWinner() {
        return player1.compareTo(player2);
    }

    @Override
    public String toString() {
        return String.format(
                "Player 1: %s\nPlayer 2: %s",
                player1,
                player2
        );
    }
}
