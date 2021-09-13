package org.mv.rules;

import org.junit.jupiter.api.Test;
import org.mv.deckofcards.Card;
import org.mv.Hand;
import org.opentest4j.AssertionFailedError;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ISetOfRulesTest {
    List<Card> dealerWinner = List.of(new Card("HA"),new Card("DA"),new Card("CA"),new Card("SA"));
    List<Card> samWinner = List.of(new Card("HA"),new Card("DA"),new Card("CQ"),new Card("SQ"));
    List<Card> dealerLooses = List.of(new Card("HA"),new Card("DA"),new Card("C2"),new Card("SA"));
    List<Card> unfinished = List.of(new Card("H2"),new Card("D3"),new Card("C2"),new Card("S3"),new Card("HA"),new Card("C3"),new Card("D10"),new Card("D5"));
    List<Card> example = List.of(new Card("CA"),new Card("D5"),new Card("H9"),new Card("HQ"),new Card("S8"));
    @Test
    void startDealerWinner() {
        ISetOfRules finnGame = new FinnRuleImplementation();
        finnGame.startGame(dealerWinner);
        assertTrue(finnGame.gameFinished());
        assertEquals("dealer",finnGame.getWinner().getName());
    }
    @Test
    void startSamWinner() {
        ISetOfRules finnGame = new FinnRuleImplementation();
        finnGame.startGame(samWinner);
        assertTrue(finnGame.gameFinished());
        assertEquals("sam",finnGame.getWinner().getName());
    }
    @Test
    void dealerLooses() {
        ISetOfRules finnGame = new FinnRuleImplementation();
        finnGame.startGame(dealerLooses);
        assertTrue(finnGame.gameFinished());
        assertEquals("sam",finnGame.getWinner().getName());
    }
    @Test
    void startUnfinished() {
        ISetOfRules finnGame = new FinnRuleImplementation();
        finnGame.startGame(unfinished);
        assertFalse(finnGame.gameFinished());
        assertNull(finnGame.getWinner());
        Hand h = finnGame.currentHand();
        assertEquals("sam",h.getPlayer().getName());
        finnGame.drawNextCard();
        assertEquals(15,h.getScore());
        finnGame.drawNextCard();
        assertEquals(18,h.getScore());
        assertTrue(h.shouldIStay());
        finnGame.drawNextCard();
        assertEquals(18,h.getScore());
        assertTrue(h.shouldIStay());
        Hand h2 = finnGame.currentHand();
        assertEquals(16,h2.getScore());
        assertFalse(h2.shouldIStay());
        finnGame.drawNextCard();
        assertTrue(finnGame.gameFinished());
        assertEquals("dealer",finnGame.getWinner().getName());
    }
    @Test
    void startExample() {
        ISetOfRules finnGame = new FinnRuleImplementation();
        finnGame.startGame(example);
        finnGame.drawNextCard();
        System.out.println(finnGame.getWinner().getName());
    }
}