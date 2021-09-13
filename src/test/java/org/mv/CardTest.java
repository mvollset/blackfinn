package org.mv;

import org.junit.jupiter.api.Test;
import org.mv.deckofcards.Card;

import static org.junit.jupiter.api.Assertions.*;

class CardTest {

    @Test
    void getCardValues() {
        String[] cards = {"CA","HA","DK","HQ","SJ","C10","D9","H8","S7","C6","S5","H4","S3","C2"};
        Integer[] values= {11,11,10,10,10,10,9,8,7,6,5,4,3,2};
        for(int i =0;i<cards.length;i++) {
            var value = Card.getValue(cards[i]); //Ace of clubs
            assertEquals(values[i],value);
        }
    }

}