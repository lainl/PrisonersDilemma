package org.example.Bots;

import org.example.Player;

public class Friedman extends Bot {
    public static final String HINT = "...";
    public Friedman(int rounds) {
        super(rounds);
    }

    @Override
    public Player.CHOICETYPE evaluateChoice(CHOICETYPE[] humanChoice, int round) {
        // In the first round, always cooperate
        if (round == 0) {
            return CHOICETYPE.COOPERATE;
        }

        // Check if the human has ever defected in previous rounds
        for (int i = 0; i < round; i++) {
            if (humanChoice[i] == CHOICETYPE.DEFECT) {
                return CHOICETYPE.DEFECT; // Defect forever if the human ever defected
            }
        }

        // Otherwise, continue cooperating
        return CHOICETYPE.COOPERATE;
    }
}


