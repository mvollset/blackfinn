package org.mv;

import org.junit.jupiter.api.Test;
import org.mv.deckofcards.Shuffler;

import static org.junit.jupiter.api.Assertions.*;

class ShufflerTest {
    Integer[] createArrayOfNSize(int n){
        var myArray = new Integer[n];
        for(var i = 0;i<myArray.length;i++){
            myArray[i]=i;
        }
        return myArray;
    }
    @Test
    void testShuffle() {
        var shuffler = new Shuffler();
        var myArray = createArrayOfNSize(52);
        var result = shuffler.shuffle(myArray);
        assertEquals(result.length,myArray.length);

    }

    @Test
    void testShuffleWithLimitedLength() {
        var shuffler = new Shuffler();
        var myArray = createArrayOfNSize(52);
        var myLength = 5;
        var result = shuffler.shuffle(myArray,myLength);
        assertEquals(result.length,myLength);
    }
}