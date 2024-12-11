package org.example.Bots;

import org.example.Player;

public class TitForTat extends Bot {
    public static final String HINT = "...";
    public TitForTat(int rounds) {
        super(rounds);
    }

    @Override
    public Player.CHOICETYPE evaluateChoice(CHOICETYPE[] humanChoice, int round) {
        // Always cooperate in the first round
        if (round == 0) {
            return CHOICETYPE.COOPERATE;
        }

        // Mimic the opponent's last move
        if (humanChoice[round - 1] != null) {
            return humanChoice[round - 1];
        }

        // Default to cooperating if human's last choice is unavailable
        return CHOICETYPE.COOPERATE;
    }
}

