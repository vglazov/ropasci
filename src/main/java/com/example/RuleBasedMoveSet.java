package com.example;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class RuleBasedMoveSet implements MoveSet {

    public RuleBasedMoveSet(Set<Move> moves, Set<Rule> rules) {
        moveIndexes = new HashMap<>();
        int index = 0;
        results = new RoundResult[moves.size()][moves.size()];
        for(Move move: moves) {
            moveIndexes.put(move, index);
            results[index][index] = RoundResult.TIE;
            index++;
        }
        for(Rule rule: rules) {
            int i1 = moveIndexes.get(rule.getOne());
            int i2 = moveIndexes.get(rule.getOther());
            results[i1][i2] = rule.getResult();
            results[i2][i1] = rule.getResult().inverse();
        }
    }

    private Map<Move, Integer> moveIndexes;
    private RoundResult[][] results;

    @Override
    public Set<Move> getMoves() {
        return moveIndexes.keySet();
    }

    public RoundResult getRoundResultFor(Move one, Move other) {
        if(!moveIndexes.containsKey(one) || !moveIndexes.containsKey(other))
            throw new IllegalArgumentException();
        return results[moveIndexes.get(one)][moveIndexes.get(other)];
    }
}
