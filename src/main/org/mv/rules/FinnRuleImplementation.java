package org.mv.rules;

import org.mv.deckofcards.Card;
import org.mv.Hand;
import org.mv.players.Dealer;
import org.mv.players.IPlayer;
import org.mv.players.Sam;

import java.util.ArrayList;
import java.util.List;

public class FinnRuleImplementation implements ISetOfRules {
    List<Hand> hands= new ArrayList<>();
    int deckposition = 0;
    int handposition=0;
    IPlayer winner;
    boolean finished=false;
    List<Card> deck;
    @Override
    public boolean gameFinished() {
        return finished;
    }
    public IPlayer settleScore(boolean firstRound){
        var samsHand=hands.get(0);
        var dealersHand= hands.get(1);
        var samsScore= samsHand.getScore();
        var dealersScore = dealersHand.getScore();
        if(firstRound){
            if(samsScore==21){
                return  samsHand.getPlayer();
            }
            if(dealersScore==21||(dealersScore==22&& samsScore==22)){
                return dealersHand.getPlayer();

            }
            if(samsScore<22&&dealersScore>21){
                return samsHand.getPlayer();

            }

        }

        if(samsHand.shouldIStay()){
            handposition=1;
        }
        if(handposition==1){
            if(dealersHand.shouldIStay()) {
                return samsHand.getPlayer();
            }
            if(dealersScore>samsScore){
                return dealersHand.getPlayer();

            }

        }

        return null;
    }



    @Override
    public List<Hand> getHands() {
        return hands;
    }

    @Override
    public IPlayer getWinner() {
        return winner;
    }

    @Override
    public Hand currentHand() {
        return hands.get(handposition);
    }

    @Override
    public void drawNextCard() {
        currentHand().addCard(deck.get(deckposition++));
        winner=settleScore(false);
        if (winner!=null)
            finished = true;
    }



    @Override
    public void startGame(List<Card> deck) {
        Hand sams = new Hand(List.of(
                deck.get(0),deck.get(2)
        ), new Sam());
        Hand dealer = new Hand(List.of(
                deck.get(1),deck.get(3)
        ), new Dealer());
        deckposition=4;
        this.deck=deck;
        hands.add(sams);
        hands.add(dealer);
        winner = settleScore(true);
        if(winner!=null)
            finished=true;


    }
}
