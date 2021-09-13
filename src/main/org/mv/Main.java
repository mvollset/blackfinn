package org.mv;

import org.mv.deckofcards.Card;
import org.mv.deckofcards.CommonDeck;
import org.mv.deckofcards.Shuffler;
import org.mv.rules.FinnRuleImplementation;
import org.mv.rules.ISetOfRules;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        Shuffler shuffler = new Shuffler();
        List<Card> deck = shuffler.getShuffledDeck(CommonDeck.getDeck());
        ISetOfRules implementation = new FinnRuleImplementation();
        implementation.startGame(deck);
        while(!implementation.gameFinished()){
            implementation.drawNextCard();
        }
        System.out.println(implementation.getWinner().getName());
        for(Hand h : implementation.getHands()){
            System.out.println(h.printHand());
        }
    }
}
