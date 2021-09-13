package org.mv.players;

public class Sam implements IPlayer {
    @Override
    public Integer getLimit() {
        return 17;
    }

    @Override
    public String getName() {
        return "sam";
    }
}
