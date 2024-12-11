package org.example;

import org.example.Bots.*;

import java.util.Random;

public class GameController {
    private enum GAMESTATE {
        START,
        RUNNING,
        END
    }

    private static int ROUNDS = 10;
    private Player[] players = new Player[ROUNDS];
    private Player human = new Human(ROUNDS);
    private Player bot;
    private GUI gui = new GUI();
    private int round = 0;
    private GAMESTATE state;




    public void startGame() {
        state = GAMESTATE.START;

        while (state != GAMESTATE.END) {
            switch (state) {
                case START:
                    start();
                    state = GAMESTATE.RUNNING;
                    break;

                case RUNNING:
                  getChoices();
                    break;

                default:
                    gui.print("Invalid game state.");
                    break;
            }
        }

        gui.print("Game has ended.");
    }

    private void start(){
        bot = getRandomBot();

        bot.setName("Bot");
        human.setName(gui.getName("Enter your name: "));
       players[0] = human;
       players[1] = bot;

       state = GAMESTATE.RUNNING;

    }
    private Bot getRandomBot(){
        Bot[] bots = {
                new Davis(ROUNDS),
                new Friedman(ROUNDS),
                new Groffman(ROUNDS),
                new Joss(ROUNDS),
                new Pavlov(ROUNDS),
                new org.example.Bots.Random(ROUNDS),
                new TitForTat(ROUNDS),
                new Tullock(ROUNDS)
        };


        Random random = new Random();
        int randomIndex = random.nextInt(bots.length);

        Bot b = bots[randomIndex];
        System.out.println("Bot: " + b.getClass().getSimpleName());
        return b;
    }
    private void whoWon() {
        if (human == null || bot == null) {
            gui.print("Players are not properly initialized!");
            return;
        }

        if (human.coins > bot.coins) {
            gui.print(human.name + " wins with " + human.coins + " coins!");
        } else if (bot.coins > human.coins) {
            gui.print(bot.name + " wins with " + bot.coins + " coins!");
        } else {
            gui.print("It's a tie! Both " + human.name + " and " + bot.name + " have " + human.coins + " coins.");
        }
    }



    private boolean gameIsOver(){
        if(round >= ROUNDS){
            whoWon();
            state = GAMESTATE.END;
            return true;
        }
        return false;
    }
    private void getChoices(){
        if (gameIsOver()){
            //gui.print("Extra measure debugging message.");
            return;
        }
        Player.CHOICETYPE humanChoice = gui.getGameChoice(((Bot) bot).getHint());
        Player.CHOICETYPE[] humanChoices = human.getChoices();
        humanChoices[round] = humanChoice;
        human.setChoices(humanChoices);
        // Update human choices
        Player.CHOICETYPE botChoice = ((Bot) bot).evaluateChoice(humanChoices, round);
        Player.CHOICETYPE[] botChoices = bot.getChoices();
        botChoices[round] = botChoice;
        bot.setChoices(botChoices);

        prisonersDilemmaLogic(botChoice, humanChoice);

        round++;


    }
    private void prisonersDilemmaLogic(Player.CHOICETYPE botChoice, Player.CHOICETYPE humanChoice) {
        if (botChoice == null || humanChoice == null) {
            System.out.println("Invalid choice(s). Both players must make a choice.");
            return;
        }

        // Both cooperate
        if (botChoice == Player.CHOICETYPE.COOPERATE && humanChoice == Player.CHOICETYPE.COOPERATE) {
            bot.coins += 3;
            human.coins += 3;
        }
        // Bot cooperates, human defects
        else if (botChoice == Player.CHOICETYPE.COOPERATE && humanChoice == Player.CHOICETYPE.DEFECT) {
            bot.coins += 0;
            human.coins += 5;
        }
        // Bot defects, human cooperates
        else if (botChoice == Player.CHOICETYPE.DEFECT && humanChoice == Player.CHOICETYPE.COOPERATE) {
            bot.coins += 5;
            human.coins += 0;
        }
        // Both defect
        else if (botChoice == Player.CHOICETYPE.DEFECT && humanChoice == Player.CHOICETYPE.DEFECT) {
            bot.coins += 1;
            human.coins += 1;
        }

        // Debugging
        System.out.println("Bot choice: " + botChoice);
        System.out.println("Human choice: " + humanChoice);
        System.out.println("Bot coins: " + bot.coins);
        System.out.println("Human coins: " + human.coins);
    }


}
