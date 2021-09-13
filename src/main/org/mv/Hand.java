package org.mv;

import org.mv.deckofcards.Card;
import org.mv.players.IPlayer;

import java.util.ArrayList;
import java.util.List;

public class Hand {
    public List<Card> cards;
    final IPlayer player;
    public Hand(List<Card> cards, IPlayer player) {
        this.cards = new ArrayList<>(cards);
        this.player = player;
    }
    public void addCard(Card card){
        cards.add(card);
    }
    public IPlayer getPlayer(){
        return player;
    }
    public int getScore(){
        var score = 0;
        for (Card c: cards
             ) {
            score +=c.getValue();
        }
        return score;
    }
    public String printHand(){
        StringBuilder sb = new StringBuilder(player.getName() + ": ");
        String[] strCards = new String[cards.size()];

        for (int i = 0; i < cards.size(); i++) {
            strCards[i]=cards.get(i).getName();
        }
        sb.append(String.join(", ",strCards));
        return sb.toString();
    }
    public boolean shouldIStay(){
        int score = this.getScore();
        if(score>21)
            return true;
         int playerLimit = player.getLimit();
         if(playerLimit==0)
             return false;
         return (score>=player.getLimit());

    }

}
