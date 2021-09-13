package org.mv.players;

public class Dealer implements IPlayer {

    @Override
    public Integer getLimit() {
        return 0;
    }

    @Override
    public String getName() {
        return "dealer";
    }
}
