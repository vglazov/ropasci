package com.example;

import java.util.List;

public class RockOnlyStrategy implements Strategy<BasicMoveSet> {
    @Override
    public Move nextMove(List<Round<BasicMoveSet>> history, Player<BasicMoveSet> myself) {
        return BasicMoveSet.ROCK;
    }
}
