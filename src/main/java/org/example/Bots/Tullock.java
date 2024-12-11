package org.example.Bots;

import org.example.Player;

import java.util.Random;

public class Tullock extends Bot {
    public static final String HINT = "...";
    public Tullock(int rounds) {
        super(rounds);
    }

    @Override
    public CHOICETYPE evaluateChoice(CHOICETYPE[] humanChoice, int round) {
        java.util.Random random = new Random();
        double defectionProbability = 0.1; // 10% chance to defect randomly

        // Always cooperate in the first round
        if (round == 0) {
            return CHOICETYPE.COOPERATE;
        }

        // Introduce a small chance to defect randomly
        if (random.nextDouble() < defectionProbability) {
            return CHOICETYPE.DEFECT;
        }

        // Otherwise, mimic the opponent's last move (tit-for-tat behavior)
        if (humanChoice[round - 1] == CHOICETYPE.COOPERATE) {
            return CHOICETYPE.COOPERATE;
        } else {
            return CHOICETYPE.DEFECT;
        }}
}
