package org.mv.deckofcards;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CardReader {
    public static List<Card> readCardFile(String path){
        try{
            final BufferedReader reader = new BufferedReader(new FileReader(path));
            List<Card> result = new ArrayList<>();
            String line = reader.readLine();
            String[] cards = line.split(",");
            for(String c: cards){
                String card = c.trim();
                if(CommonDeck.validCard(card))
                    result.add(new Card(card));
                else {
                    throw new IOException("Invalid card " + card );
                }
            }
            return result;
        }
        catch(IOException ex){
            ex.printStackTrace();
        }
        return null;
    }
}
