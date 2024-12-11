package org.example.Bots;

import org.example.Player;

public class Davis extends Bot {
    public static final String HINT = "...";
    public Davis(int rounds) {
        super(rounds);
    }

    @Override
    public Player.CHOICETYPE evaluateChoice(CHOICETYPE[] humanChoice, int round) {
        // Davis cooperates in the first round
        if (round == 0) {
            return CHOICETYPE.COOPERATE;
        }

        // Evaluate human's last choice from the previous round
        if (round > 0 && humanChoice[round - 1] != null) {
            return humanChoice[round - 1]; // Mirror the human's last choice
        }

        // Default to cooperate if no reliable information is available
        return CHOICETYPE.COOPERATE;
    }

}
