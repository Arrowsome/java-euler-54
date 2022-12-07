package me.arrowsome.euler54;

import java.io.IOException;
import java.io.InputStream;

public class Game {
    public static void main(String[] args) throws IOException {
        InputStream inputStream = Game.class.getClassLoader().getResourceAsStream("poker_hands.txt");
        Parser parser = new TextFileParser(inputStream);

        int numOfP1Wins = 0;
        int numOfRounds = 0;
        while (parser.hasNext()) {
            Round round = parser.getNextRound();
            int result = round.checkWinner();
            if (result > 0) numOfP1Wins++;
            numOfRounds++;
        }
        parser.close();
        System.out.println();
        System.out.println("+++-----------------------------------------------+++");
        System.out.println(">>> Player 1 has won " + numOfP1Wins + " times out of " + numOfRounds + " rounds <<<");
        System.out.println("+++-----------------------------------------------+++");
    }
}
