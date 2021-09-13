package org.mv.deckofcards;

import org.mv.deckofcards.Card;

import java.util.ArrayList;
import java.util.List;

public class CommonDeck {
    /**
     * Standard deck of cards
     */
    public static List<Card> getDeck(){
        String[] denoms = {"2","3","4","5","6","7","8","9","10","J","Q","K","A"};
        String[] suits = {"C","D","H","S"};
        var result = new ArrayList<Card>();
        for (var suit: suits
             ) {
            for(var den:denoms) {
                result.add(new Card(suit, den));
            }
        }
        return result;
    }
}
