package org.mv.deckofcards;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CardReaderTest {

    @Test
    void readValidCardFile() {
        var result = CardReader.readCardFile("src/test/resources/validcards.txt");
        assertNotNull(result);
        assertEquals(4,result.size());
    }
    @Test
    void readInValidCardFile() {
        List<Card> result  =CardReader.readCardFile("src/test/resources/invalidcards.txt");
        assertNull(result);

    }
}