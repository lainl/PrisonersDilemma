package org.example.Bots;

import org.example.Player;

public class Pavlov extends Bot {
    public static final String HINT = "...";
    public Pavlov(int rounds) {
        super(rounds);
    }

    @Override
    public Player.CHOICETYPE evaluateChoice(CHOICETYPE[] humanChoice, int round) {
        // Always cooperate in the first round
        if (round == 0) {
            return CHOICETYPE.COOPERATE;
        }

        // Get the bot's last choice and the human's last choice
        CHOICETYPE lastBotChoice = choices[round - 1]; // 'choices' holds the bot's previous moves
        CHOICETYPE lastHumanChoice = humanChoice[round - 1];

        // If both made the same choice last round, repeat the bot's previous choice
        if (lastBotChoice == lastHumanChoice) {
            return lastBotChoice;
        }

        // Otherwise, switch the bot's choice
        return (lastBotChoice == CHOICETYPE.COOPERATE) ? CHOICETYPE.DEFECT : CHOICETYPE.COOPERATE;
    }
}

