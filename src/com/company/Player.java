package com.company;

public abstract class Player implements Comparable<Player> {

    private String name;
    private String played;


    public Player(String name){
        super();
        this.name = name;
    }

    public Player(){
        this.played = "";
        this.name = "";
    }

    /**
     * compares current player's (this) move to the opponent player's (p2) move
     * @param p2 opponent player
     * @return -1 if this player loses, 0 if tie, 1 if this wins
     */
    @Override
    public int compareTo(Player p2) {
        // if tie
        if(this.getPlayed().equalsIgnoreCase(p2.getPlayed())) return 0;

        // if this player won
        else if(this.getPlayed().equalsIgnoreCase("rock") && p2.getPlayed().equalsIgnoreCase("scissor")) return 1;
        else if(this.getPlayed().equalsIgnoreCase("paper") && p2.getPlayed().equalsIgnoreCase("rock")) return 1;
        else if(this.getPlayed().equalsIgnoreCase("scissor") && p2.getPlayed().equalsIgnoreCase("paper")) return 1;

        // if none of the cases above are triggered, this player lost
        else return -1;
    }

    /**
     * Abstract method, to get the player's move
     * child classes to implement
     */
    public abstract void getMove();

    // Getters and Setters
    public String getPlayed() {
        return played;
    }

    public void setPlayed(String played) {
        this.played = played;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
