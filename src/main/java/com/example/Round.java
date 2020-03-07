package com.example;

import java.util.Map;

public class Round<M extends MoveSet> {

    private Map<Player<M>, Move> moves;
    private Map<Player<M>, RoundResult> results;
    private Player<M> winner; // can be null if tie

    public Round(Map<Player<M>, Move> moves, Map<Player<M>, RoundResult> results, Player<M> winner) {
        this.moves = moves;
        this.results = results;
        this.winner = winner;
    }

    public Map<Player<M>, Move> getMoves() {
        return moves;
    }

    public Map<Player<M>, RoundResult> getResults() {
        return results;
    }

    public Player<M> getWinner() {
        return winner;
    }

}
