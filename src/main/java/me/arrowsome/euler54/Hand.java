package me.arrowsome.euler54;

import java.util.*;

public class Hand implements Comparable<Hand> {
    private final List<Card> cards;
    private final Ranking ranking;

    public Hand(List<Card> cards) {
        ArrayList<Card> temp = new ArrayList<>(cards);
        Collections.sort(temp);
        this.cards = Collections.unmodifiableList(temp);
        this.ranking = calcRanking();
    }

    protected Ranking calcRanking() {
        boolean isStraight = isStraight();
        boolean isFlush = isFlush();
        boolean isStraightFlush = isStraight && isFlush;
        boolean isRoyalFlush = isStraightFlush && getMaxValue() == Value.ACE;

        if (isRoyalFlush) {
            return new Ranking(
                    Rank.ROYAL_FLUSH,
                    Collections.emptyList()
            );
        }

        if (isStraightFlush) {
            return new Ranking(
                    Rank.STRAIGHT_FLUSH,
                    getDescValues()
            );
        }

        Map<Value, Integer> freq = calcFrequency();
        Value fourOfAKind = null;
        Value threeOfAKind = null;
        Value firstPair = null;
        Value secondPair = null;

        for (Map.Entry<Value, Integer> entry : freq.entrySet()) {
            if (entry.getValue() == 4) {
                fourOfAKind = entry.getKey();
            }
            if (entry.getValue() == 3) {
                threeOfAKind = entry.getKey();
            }
            if (entry.getValue() == 2) {
                if (firstPair == null) {
                    firstPair = entry.getKey();
                } else if (secondPair == null) {
                    secondPair = entry.getKey();
                }
            }
        }

        if (fourOfAKind != null) {
            return new Ranking(
                    Rank.FOUR_OF_A_KIND,
                    getDescValuesWithPriority(fourOfAKind)
            );
        }

        if (threeOfAKind != null && firstPair != null) {
            return new Ranking(
                    Rank.FULL_HOUSE,
                    getDescValuesWithPriority(threeOfAKind, firstPair)
            );
        }

        if (isFlush) {
            return new Ranking(
                    Rank.FLUSH,
                    getDescValues()
            );
        }

        if (isStraight) {
            return new Ranking(
                    Rank.STRAIGHT,
                    getDescValues()
            );
        }

        if (threeOfAKind != null) {
            return new Ranking(
                    Rank.THREE_OF_A_KIND,
                    getDescValuesWithPriority(threeOfAKind)
            );
        }

        if (firstPair != null && secondPair != null) {
            return new Ranking(
                    Rank.TWO_PAIRS,
                    getDescValuesWithPriority(
                            firstPair.ordinal() > secondPair.ordinal() ? firstPair : secondPair,
                            firstPair.ordinal() > secondPair.ordinal() ? secondPair : firstPair
                    )
            );
        }

        if (firstPair != null) {
            return new Ranking(
                    Rank.PAIR,
                    getDescValuesWithPriority(firstPair)
            );
        }

        return new Ranking(
                Rank.HIGH_CARD,
                getDescValues()
        );
    }

    protected boolean isFlush() {
        Suit suit = cards.get(0).getSuit();
        for (int i = 1; i < cards.size(); ++i) {
            if (cards.get(i).getSuit() != suit) {
                return false;
            }
        }
        return true;
    }

    protected boolean isStraight() {
        int min = cards.get(0).getValue().ordinal();
        int max = cards.get(cards.size() - 1).getValue().ordinal();

        return (max - min) == 4;
    }

    protected Value getMaxValue() {
        return cards.get(cards.size() - 1).getValue();
    }

    protected Map<Value, Integer> calcFrequency() {
        Map<Value, Integer> freq = new HashMap<>();
        for (Card card : cards) {
            Value value = card.getValue();
            freq.put(
                    value,
                    freq.getOrDefault(value, 0) + 1
            );
        }
        return freq;
    }

    protected List<Value> getDescValues() {
        List<Value> values = new ArrayList<>();
        for (Card card : cards) {
            values.add(card.getValue());
        }
        Collections.reverse(values);
        return values;
    }

    protected List<Value> getDescValuesWithPriority(Value... values) {
        List<Value> descValuesWithPriority = getDescValues();
        for (Value value : values) {
            while (descValuesWithPriority.contains(value)) {
                descValuesWithPriority.remove(value);
            }
        }
        for (int index = values.length - 1; index >= 0; --index) {
            descValuesWithPriority.add(0, values[index]);
        }
        return descValuesWithPriority;
    }

    @Override
    public int compareTo(Hand o) {
        return ranking.compareTo(o.ranking);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hand hand = (Hand) o;
        return cards.equals(hand.cards) && ranking.equals(hand.ranking);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cards, ranking);
    }
}
