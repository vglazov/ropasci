package com.example;

import java.util.Set;

public class BasicMoveSet extends RuleBasedMoveSet {

    public final static Move ROCK = () -> "Rock";
    public final static Move PAPER = () -> "Paper";
    public final static Move SCISSORS = () -> "Scissors";

    private final static Rule rockVsScissors = new Rule(ROCK, SCISSORS, RoundResult.WIN);
    private final static Rule scissorsVsPaper = new Rule(SCISSORS, PAPER, RoundResult.WIN);
    private final static Rule paperVsRock = new Rule(PAPER, ROCK, RoundResult.WIN);

    private final static BasicMoveSet instance = new BasicMoveSet(Set.of(ROCK, PAPER, SCISSORS), Set.of(rockVsScissors, scissorsVsPaper, paperVsRock));

    public BasicMoveSet(Set<Move> moves, Set<Rule> rules) {
        super(moves, rules);
    }

    public static BasicMoveSet get() {
        return instance;
    }
}
