package org.example;


public  abstract class Player {
    public enum CHOICETYPE {
        DEFECT,
        COOPERATE
    }

    protected String name;
    protected int coins;
    protected CHOICETYPE[] choices;

    public Player(int rounds){
        choices = new CHOICETYPE[rounds];
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCoins() {
        return coins;
    }

    public void setCoins(int coins) {
        this.coins = coins;
    }

    public CHOICETYPE[] getChoices() {
        return choices;
    }

    public void setChoices(CHOICETYPE[] choices) {
        this.choices = choices;
    }
}
