package main;

public class TurnCounter {
    int turnCount;

    public TurnCounter(int turnCount) {
        this.turnCount = turnCount;
    }

    public int getTurnCount() {
        return turnCount;
    }

    public int setTurnCount(int turnCount) {
        this.turnCount = turnCount;
        return turnCount;
    }
}
