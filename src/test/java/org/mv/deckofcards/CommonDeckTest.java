package org.mv.deckofcards;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CommonDeckTest {

    @Test
    void isValidCard() {
        assertTrue(CommonDeck.validCard("HA"));
    }
    @Test
    void isNotValidCard() {
        assertFalse(CommonDeck.validCard("HW"));
    }
    @Test
    void getDeck() {
        var deck = CommonDeck.getDeck();
        for (Card c: deck
             ) {
            assertTrue(CommonDeck.validCard(c.getName()));
        }
    }


}