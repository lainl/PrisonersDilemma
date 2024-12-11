package org.example.Bots;

import org.example.Player;

public abstract class Bot extends Player {
    public static final String HINT = "...";



    public Bot(int rounds) {
        super(rounds);
    }
    public abstract CHOICETYPE evaluateChoice(CHOICETYPE[] humanChoice, int round);
    public String getHint() {
        return HINT;
    }

}
