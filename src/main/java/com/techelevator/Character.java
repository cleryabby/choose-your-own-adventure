package com.techelevator;

public class Character {

    private String name;
    private boolean isHelpful;

    public Character(String name, boolean isHelpful) {
    //    System.out.println("You've encountered someone new.");
        this.name = name;
        this.isHelpful = isHelpful;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isHelpful() {
        return isHelpful;
    }

    public void setHelpful(boolean helpful) {
        isHelpful = helpful;
    }
}
