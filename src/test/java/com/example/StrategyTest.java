package com.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("Strategy tests")
public class StrategyTest {

    @Test
    @DisplayName("Random strategy")
    public void testRandom() {
        Strategy<BasicMoveSet> r1 = new RandomStrategy();
        Strategy<BasicMoveSet> r2 = new RandomStrategy();
        Strategy<BasicMoveSet> r3 = new RandomStrategy();
        Player<BasicMoveSet> myself = new Player<>("Random", r1);
        int tieCount = 0;
        int rockCount = 0;
        int paperCount = 0;
        int scissorsCount = 0;
        for(int i = 0; i < 10000; i++) {
            if(r1.nextMove(Collections.emptyList(), myself) == r2.nextMove(Collections.emptyList(), myself)) {
                tieCount++;
            }
            Move move = r3.nextMove(Collections.emptyList(), myself);
            if(move == BasicMoveSet.PAPER) {
                paperCount++;
            } else if(move == BasicMoveSet.ROCK) {
                rockCount++;
            } else if(move == BasicMoveSet.SCISSORS) {
                scissorsCount++;
            }
        }

        // Will fail once in 100 years
        assertTrue(tieCount < 5000);
        assertTrue(rockCount > 3000);
        assertTrue(paperCount > 3000);
        assertTrue(scissorsCount > 3000);
    }

    @Test
    @DisplayName("Rock only strategy")
    public void testRockOnly() {
        Strategy<BasicMoveSet> s = new RockOnlyStrategy();
        Player<BasicMoveSet> myself = new Player<>("Rock", s);
        for(int i = 0; i < 10000; i++) {
            assertEquals(BasicMoveSet.ROCK, s.nextMove(Collections.emptyList(), myself));
        }
    }
}
