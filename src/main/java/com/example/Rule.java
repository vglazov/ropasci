package com.example;

public class Rule {
    private Move one;
    private Move other;
    private RoundResult result;

    public Rule(Move one, Move other, RoundResult result) {
        this.one = one;
        this.other = other;
        this.result = result;
    }

    public Move getOne() {
        return one;
    }

    public Move getOther() {
        return other;
    }

    public RoundResult getResult() {
        return result;
    }
}
