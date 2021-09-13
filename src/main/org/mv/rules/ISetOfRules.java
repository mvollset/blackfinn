package org.mv.rules;
import org.mv.deckofcards.Card;
import org.mv.Hand;
import org.mv.players.IPlayer;

import java.util.List;

public interface ISetOfRules {
    boolean gameFinished();
    IPlayer settleScore(boolean firstRound);
    List<Hand> getHands();
    IPlayer getWinner();
    Hand currentHand();
    void drawNextCard();
    void startGame(List<Card> deck);
}
