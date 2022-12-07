package me.arrowsome.euler57;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class TextFileParser extends Parser {
    private final BufferedReader bufferedReader;

    public TextFileParser(InputStream inputStream) {
        bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
    }

    public Round getNextRound() throws IOException {
        String line = bufferedReader.readLine();
        String[] tokens = line.split(" ");

        List<Card> cards = new ArrayList<>();
        for (String token : tokens) {
            cards.add(
                    new Card(
                            Value.from(token.charAt(0)),
                            Suit.from(token.charAt(1))
                    )
            );
        }

        return new Round(cards);
    }

    @Override
    public boolean hasNext() throws IOException {
        return bufferedReader.ready();
    }

    @Override
    public void close() throws IOException {
        bufferedReader.close();
    }
}
