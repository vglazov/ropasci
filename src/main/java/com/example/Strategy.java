package com.example;

import java.util.List;

public interface Strategy<M extends MoveSet> {

    // history is not used right now, but more sophisticated strategies may rely on it
    Move nextMove(List<Round<M>> history, Player<M> myself);
}
