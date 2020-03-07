package com.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Match tests")
public class MatchTest {

    @Test
    @DisplayName("Smoke test")
    public void testSmoke() {
        Match<BasicMoveSet> match = new Match<>(new Player<>("Mr. Tight", new RockOnlyStrategy()),
                new Player<>("Dr. Chaos", new RandomStrategy()), BasicMoveSet.get());

        for(int i = 0; i < 100; i++) {
            match.nextRound();
        }

        System.out.println(match.getReport());
    }

}
