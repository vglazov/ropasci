package com.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static com.example.RoundResult.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Move set tests")
public class MoveSetTest {

    @Test()
    @DisplayName("Basic move set")
    public void testBasic() {
        MoveSet moveSet = BasicMoveSet.get();

        assertEquals(LOSE, moveSet.getRoundResultFor(BasicMoveSet.PAPER, BasicMoveSet.SCISSORS));
        assertEquals(WIN, moveSet.getRoundResultFor(BasicMoveSet.ROCK, BasicMoveSet.SCISSORS));
        assertEquals(TIE, moveSet.getRoundResultFor(BasicMoveSet.PAPER, BasicMoveSet.PAPER));
    }

    @Test()
    @DisplayName("Basic move set consistency")
    public void testBasicConsistency() {
        checkConsistency(BasicMoveSet.get());
    }

    private void checkConsistency(MoveSet moveSet) {
        List<Move> movesList = new ArrayList<>(moveSet.getMoves());
        for(Move move: movesList) {
            assertEquals(TIE, moveSet.getRoundResultFor(move, move));
        }

        for(int i = 0; i < movesList.size() - 1; i++) {
            for(int j = i + 1; j < movesList.size(); j++) {
                Move m1 = movesList.get(i);
                Move m2 = movesList.get(j);
                RoundResult r1 = moveSet.getRoundResultFor(m1, m2);
                RoundResult r2 = moveSet.getRoundResultFor(m2, m1);

                assertEquals(r2.inverse(), r1);
            }
        }
    }

}
