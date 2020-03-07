package com.example;

import java.util.List;

public class RandomStrategy implements Strategy<BasicMoveSet> {
    @Override
    public Move nextMove(List<Round<BasicMoveSet>> history, Player<BasicMoveSet> myself) {
        int i = (int) (Math.random() * 3);
        switch (i) {
            case 0: return BasicMoveSet.ROCK;
            case 1: return BasicMoveSet.PAPER;
            case 2: return BasicMoveSet.SCISSORS;
        }
        throw new IllegalStateException();
    }
}
