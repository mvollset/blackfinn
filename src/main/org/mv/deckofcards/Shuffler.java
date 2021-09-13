package org.mv.deckofcards;
import org.mv.deckofcards.Card;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
public class Shuffler {
    Integer[] createArrayOfNSize(int n){
        var myArray = new Integer[n];
        for(var i = 0;i<myArray.length;i++){
            myArray[i]=i;
        }
        return myArray;
    }
    public List<Card> getShuffledDeck(List<Card> deck){
       var positions = createArrayOfNSize(deck.size());
       var shuffled = shuffle(positions);
       var result = new ArrayList<Card>();
        for (int i = 0; i < positions.length; i++) {
            result.add(deck.get(shuffled[i]));
        }
        return result;
    }
    public Integer[] shuffle(Integer[] sequence) {
        return shuffle(sequence, sequence.length);
    }

    public Integer[] shuffle(Integer[]sequence, int nToReturn){
        Random rand = new Random();
        int length = sequence.length;
        Integer[] result = new Integer[nToReturn];
        for (int i = 0; i<nToReturn; i++)
        {
            int r = rand.nextInt(length - i);
            //Moving last element to the "used" position
            result[i] = sequence[r];
            sequence[r] = sequence[length-(i+1)];
        }
        return result;
    }
}
