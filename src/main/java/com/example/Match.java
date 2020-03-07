package com.example;

import java.util.*;

public class Match<M extends MoveSet> {

    private List<Round<M>> rounds = new ArrayList<>();
    private Map<Player<M>, Integer> scores = new HashMap<>();
    private Player<M> player1;
    private Player<M> player2;
    private M moveSet;

    public Match(Player<M> player1, Player<M> player2, M moveSet) {
        this.player1 = player1;
        this.player2 = player2;
        this.moveSet = moveSet;
    }

    public Round<M> nextRound() {
        Map<Player<M>, Move> moves = new HashMap<>();
        Map<Player<M>, RoundResult> results = new HashMap<>();
        Player<M> winner = null;

        Move move1 = player1.getStrategy().nextMove(rounds, player1);
        Move move2 = player2.getStrategy().nextMove(rounds, player2);
        moves.put(player1, move1);
        moves.put(player2, move2);
        RoundResult result1 = moveSet.getRoundResultFor(move1, move2);
        RoundResult result2 = moveSet.getRoundResultFor(move2, move1);
        results.put(player1, result1);
        results.put(player2, result2);

        if(result1 == RoundResult.WIN) {
            winner = player1;
            scores.merge(player1, 1, Integer::sum);
        } else if(result2 == RoundResult.WIN) {
            winner = player2;
            scores.merge(player2, 1, Integer::sum);
        }

        Round<M> round = new Round<>(moves, results, winner);
        rounds.add(round);
        return round;
    }

    public String getReport() {
        StringBuilder out = new StringBuilder();
        out.append(String.format("Match: %s vs %s", player1.getName(), player2.getName())).append("\n");
        for(Round<M> round: rounds) {
            out.append(String.format("%s plays %s, %s plays %s. ",
                    player1.getName(), round.getMoves().get(player1).getDisplayName(),
                    player2.getName(), round.getMoves().get(player2).getDisplayName()));

            if(round.getWinner() != null) {
                out.append(String.format("%s wins!", round.getWinner().getName()));
            } else {
                out.append("Tie.");
            }
            out.append("\n");
        }
        out.append(String.format("Score %d-%d (%s - %s)", scores.get(player1), scores.get(player2), player1.getName(), player2.getName()));
        return out.toString();
    }
}
