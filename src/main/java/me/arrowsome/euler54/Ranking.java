package me.arrowsome.euler54;

import java.util.ArrayList;
import java.util.List;

public class Ranking implements Comparable<Ranking> {
    private final Rank rank;
    private final List<Value> highValues;

    public Ranking(Rank rank, List<Value> values) {
        this.rank = rank;
        this.highValues = new ArrayList<>(values);
    }

    @Override
    public int compareTo(Ranking o) {
        int rankCompare = rank.compareTo(o.rank);

        if (rankCompare != 0) return rankCompare;

        for (int index = 0; index < highValues.size(); ++index) {
            int valueCompare = highValues.get(index).compareTo(o.highValues.get(index));
            if (valueCompare != 0) return valueCompare;
        }

        return rankCompare;
    }
}
