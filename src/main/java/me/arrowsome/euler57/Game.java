package me.arrowsome.euler57;

import java.io.IOException;
import java.io.InputStream;

public class Game {
    public static void main(String[] args) throws IOException {
        InputStream inputStream = Game.class.getClassLoader().getResourceAsStream("poker_hands.txt");
        Parser parser = new TextFileParser(inputStream);

        while (parser.hasNext()) {
            Round round = parser.getNextRound();
            System.out.println(round);
            // compare and increment player1 wins in case he's the winner.
        }

        parser.close();
    }
}
