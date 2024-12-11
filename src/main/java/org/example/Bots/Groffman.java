package org.example.Bots;

import org.example.Player;

public class Groffman extends Bot {
    public static final String HINT = "...";
    public Groffman(int rounds) {
        super(rounds);
    }

    @Override
    public CHOICETYPE evaluateChoice(CHOICETYPE[] humanChoice, int round) {
        // Cooperate in the first two rounds
        if (round == 0 || round == 1) {
            return CHOICETYPE.COOPERATE;
        }

        // Defect periodically (every 3rd round)
        if (round % 3 == 0) {
            return CHOICETYPE.DEFECT;
        }

        // React to the opponent's behavior in the previous round
        if (humanChoice[round - 1] == CHOICETYPE.DEFECT) {
            return CHOICETYPE.DEFECT; // Retaliate if the human defected last round
        }

        // Default to cooperation
        return CHOICETYPE.COOPERATE;
    }


}

