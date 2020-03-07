package com.example;

import java.util.Set;

public interface MoveSet {
    Set<Move> getMoves();
    RoundResult getRoundResultFor(Move one, Move other);
}
