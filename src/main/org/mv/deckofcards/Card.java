package org.mv.deckofcards;

import java.util.AbstractMap;
import java.util.Map;

public class Card {
    private String suit;
    private String denomination;
    private int value;
    static Map<String, Integer> valueMap = Map.ofEntries(
            new AbstractMap.SimpleEntry<>("A",11),
            new AbstractMap.SimpleEntry<>("2", 2),
            new AbstractMap.SimpleEntry<>("3",3),
            new AbstractMap.SimpleEntry<>("4",4),
            new AbstractMap.SimpleEntry<>("5",5),
            new AbstractMap.SimpleEntry<>("6",6),
            new AbstractMap.SimpleEntry<>("7",7),
            new AbstractMap.SimpleEntry<>("8",8),
            new AbstractMap.SimpleEntry<>("9",9),
            new AbstractMap.SimpleEntry<>("10",10),
            new AbstractMap.SimpleEntry<>("J",10),
            new AbstractMap.SimpleEntry<>("Q",10),
            new AbstractMap.SimpleEntry<>("K",10)

    );
    public Card(String suit, String denomination) {
        this.suit = suit;
        this.denomination = denomination;
    }
    public Card(String name) {
        this.suit = name.substring(0,1);
        this.denomination = name.substring(1);
    }

    public int getValue() {
       return valueMap.get(this.denomination);
    }
    public String getName(){
        return this.suit + this.denomination;
    }
    public static int getValue(String card) {
        var c = new Card(card);
        return valueMap.get(c.denomination);
    }
}
