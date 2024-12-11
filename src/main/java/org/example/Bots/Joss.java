package org.example.Bots;

import java.util.Random;

public class Joss extends Bot {
    public static final String HINT = "...";
    private final double defectionProbability = 0.1; // 10% chance to defect
    private final Random random = new Random(); // Initialize Random instance

    public Joss(int rounds) {
        super(rounds);
    }

    @Override
    public CHOICETYPE evaluateChoice(CHOICETYPE[] humanChoice, int round) {
        // Always cooperate in the first round
        if (round == 0) {
            return CHOICETYPE.COOPERATE;
        }

        // Introduce a small chance to defect randomly
        if (random.nextDouble() < defectionProbability) {
            return CHOICETYPE.DEFECT;
        }

        // Otherwise, mimic the opponent's last move (tit-for-tat)
        if (humanChoice[round - 1] == CHOICETYPE.COOPERATE) {
            return CHOICETYPE.COOPERATE;
        } else {
            return CHOICETYPE.DEFECT;
        }
    }
}
