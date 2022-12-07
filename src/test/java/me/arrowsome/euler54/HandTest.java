package me.arrowsome.euler54;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class HandTest {
    private Hand hand;

    private void initSet01() {
        List<Card> cards = new ArrayList<>();
        cards.add(new Card(Value.TEN, Suit.SPADE));
        cards.add(new Card(Value.JACK, Suit.SPADE));
        cards.add(new Card(Value.QUEEN, Suit.SPADE));
        cards.add(new Card(Value.KING, Suit.SPADE));
        cards.add(new Card(Value.ACE, Suit.SPADE));
        hand = new Hand(cards);
    }

    private void initSet02() {
        List<Card> cards = new ArrayList<>();
        cards.add(new Card(Value.TWO, Suit.DIAMOND));
        cards.add(new Card(Value.JACK, Suit.SPADE));
        cards.add(new Card(Value.TWO, Suit.CLUB));
        cards.add(new Card(Value.JACK, Suit.SPADE));
        cards.add(new Card(Value.JACK, Suit.HEART));
        hand = new Hand(cards);
    }

    @Test
    void isFlush_returnsTrue() {
        initSet01();
        boolean isFlush = hand.isFlush();
        assertTrue(isFlush);
    }

    @Test
    void isFlush_returnsFalse() {
        initSet02();
        boolean isFlush = hand.isFlush();
        assertFalse(isFlush);
    }

    @Test
    void isStraight_returnsTrue() {
        initSet01();
        boolean isStraight = hand.isStraight();
        assertTrue(isStraight);
    }

    @Test
    void isStraight_returnsFalse() {
        initSet02();
        boolean isStraight = hand.isStraight();
        assertFalse(isStraight);
    }

    @Test
    void calcFrequency_returnsOnePairOneThreeKind() {
        initSet02();
        Map<Value, Integer> freq = hand.calcFrequency();
        Map<Value, Integer> expected = new HashMap<>();
        expected.put(Value.TWO, 2);
        expected.put(Value.JACK, 3);
        assertEquals(freq, expected);
    }

    @Test
    void calcRanking_returnsRoyalFlush() {
        initSet01();
        Ranking ranking = hand.calcRanking();
        Ranking expected = new Ranking(Rank.ROYAL_FLUSH, Collections.emptyList());
        assertEquals(expected, ranking);
    }

    @Test
    void calcRanking_returnsFullHouse() {
        initSet02();
        Ranking ranking = hand.calcRanking();
        List<Value> expectedValues = new ArrayList<>();
        expectedValues.add(Value.JACK);
        expectedValues.add(Value.TWO);
        Ranking expected = new Ranking(Rank.FULL_HOUSE, expectedValues);
        assertEquals(expected, ranking);
    }
}