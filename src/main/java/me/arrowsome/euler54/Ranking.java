package me.arrowsome.euler54;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ranking ranking = (Ranking) o;
        return rank == ranking.rank && highValues.equals(ranking.highValues);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rank, highValues);
    }
}
