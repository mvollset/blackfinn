package org.mv.deckofcards;

import org.mv.deckofcards.Card;

import java.util.ArrayList;
import java.util.List;

public class CommonDeck {
    static String[] denoms = {"2","3","4","5","6","7","8","9","10","J","Q","K","A"};
    static String[] suits = {"C","D","H","S"};
    /**
     * Standard deck of cards
     */
    public static List<Card> getDeck(){
        var result = new ArrayList<Card>();
        for (var suit: suits
             ) {
            for(var den:denoms) {
                result.add(new Card(suit, den));
            }
        }
        return result;
    }

    public static boolean validCard(String c){
        String suit = c.substring(0,1);
        String denomination = c.substring(1);
        int suitIndex = -1;
        for(var i=0;i<suits.length;i++){
            if(suit.compareTo(suits[i])==0)
                suitIndex=i;
        }
        if(suitIndex==-1)
            return false;
        int denIndex = -1;
        for(var i=0;i<denoms.length;i++){
            if(denomination.compareTo(denoms[i])==0)
                denIndex=i;
        }
        return denIndex != -1;
    }
}
