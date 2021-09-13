package org.mv;

import org.junit.jupiter.api.Test;
import org.mv.deckofcards.Card;
import org.mv.players.Dealer;
import org.mv.players.IPlayer;
import org.mv.players.Sam;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class HandTest {
    IPlayer dealer = new Dealer();
    IPlayer sam = new Sam();
    @Test
    void getTestDealerHand1() {
        List<Card> cards = List.of(new Card("H10"),new Card("HA"));
        Hand hand = new Hand(cards, dealer);
        assertEquals(21,hand.getScore());
        assertFalse(hand.shouldIStay());
    }
    @Test
    void getTestDealerHand2() {
        List<Card> cards = List.of(new Card("H10"),new Card("H2"));
        Hand hand = new Hand(cards, dealer);
        assertEquals(12,hand.getScore());
        assertFalse(hand.shouldIStay());
        assertEquals("dealer: H10, H2",hand.printHand());
    }
    @Test
    void getTestSamHand1() {
        List<Card> cards = List.of(new Card("H10"),new Card("H2"));
        Hand hand = new Hand(cards, sam);
        assertEquals(12,hand.getScore());
        assertFalse(hand.shouldIStay());
    }
    @Test
    void getTestSamHand2() {
        List<Card> cards = List.of(new Card("H10"),new Card("H7"),new Card("C3"));
        Hand hand = new Hand(cards, sam);
        assertEquals(20,hand.getScore());
        String pr = hand.printHand();
        assertEquals("sam: H10, H7, C3",pr);

    }
    @Test
    void getTestSamHand3() {
        List<Card> cards = List.of(new Card("H10"),new Card("H7"),new Card("C3"),new Card("S10"),new Card("D7"),new Card("C3"));
        Hand hand = new Hand(cards, sam);
        assertEquals(40,hand.getScore());
    }
    @Test
    void addCard() {
        List<Card> cards = List.of(new Card("H10"),new Card("H2"));
        Hand hand = new Hand(cards, sam);
        assertEquals(12,hand.getScore());
        assertFalse(hand.shouldIStay());
        hand.addCard(new Card("C8"));
        assertEquals(20,hand.getScore());
        assertTrue(hand.shouldIStay());
    }

}
