package org.mv.rules;

import org.junit.jupiter.api.Test;
import org.mv.deckofcards.Card;

import java.util.List;

class FinnGameTest {
    List<Card> dealerWinner = List.of(new Card("HA"),new Card("DA"),new Card("CA"),new Card("SA"));
    List<Card> samWinner = List.of(new Card("HA"),new Card("DA"),new Card("CQ"),new Card("SQ"));

    @Test
    void edgeTestDealerWinner() {
        FinnRuleImplementation n = new FinnRuleImplementation();
        n.startGame(dealerWinner);

    }
    @Test
    void edgeTestSamWinner() {
        FinnRuleImplementation n = new FinnRuleImplementation();
        n.startGame(samWinner);

    }
}