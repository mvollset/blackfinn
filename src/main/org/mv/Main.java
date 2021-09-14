package org.mv;

import org.mv.deckofcards.Card;
import org.mv.deckofcards.CardReader;
import org.mv.deckofcards.CommonDeck;
import org.mv.deckofcards.Shuffler;
import org.mv.rules.FinnRuleImplementation;
import org.mv.rules.ISetOfRules;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Card> deck;
        if(args.length>0){
            deck = CardReader.readCardFile(args[0]);
        }
        else{
            Shuffler shuffler = new Shuffler();
            deck = shuffler.getShuffledDeck(CommonDeck.getDeck());
        }

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
