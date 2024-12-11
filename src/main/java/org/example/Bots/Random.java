package org.example.Bots;

import org.example.Player;

public class Random extends Bot {
    public static final String HINT = "...";
    public Random(int rounds) {
        super(rounds);
    }

    private final java.util.Random random = new java.util.Random();

    @Override
    public CHOICETYPE evaluateChoice(CHOICETYPE[] humanChoice, int round) {
        return random.nextBoolean() ? CHOICETYPE.COOPERATE : CHOICETYPE.DEFECT;
    }


}

