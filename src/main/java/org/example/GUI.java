package org.example;

import java.util.Scanner;

public class GUI {
    public String getName(String prompt) {
        String name;
        while (true) {
            name = getString(prompt);
            if (isValidName(name)) {
                break;
            } else {
                //printing out in red text
                System.out.println("\u001B[31mIncorrect format. The name must be at least 3 characters long and contain only alphabetic characters.\u001B[0m");
            }
        }
        return name;
    }
    private boolean isValidName(String name) {
        //at least 3 alphebetical letters
        return name.matches("[a-zA-Z]{3,}");
    }
    public String getString(String prompt) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(prompt);
        return scanner.nextLine();
    }
    public void print(String message) {
        System.out.println(message);
    }
    public Player.CHOICETYPE getGameChoice(String hint) {
        Scanner scanner = new Scanner(System.in);
        Player.CHOICETYPE choice = null;

        while (choice == null) {
            System.out.println("Choose an option:");
            System.out.println("1. COOPERATE");
            System.out.println("2. DEFECT");
            System.out.println("3. HINT");

            String input = scanner.nextLine();

            switch (input) {
                case "1":
                    choice = Player.CHOICETYPE.COOPERATE;
                    break;

                case "2":
                    choice = Player.CHOICETYPE.DEFECT;
                    break;

                case "3":
                    System.out.println("\u001B[33mHint: " + hint + "\u001B[0m");
                    break;

                default:
                    System.out.println("\u001B[31mInvalid choice. Please choose 1, 2, or 3.\u001B[0m");
            }
        }

        return choice;
    }

}
