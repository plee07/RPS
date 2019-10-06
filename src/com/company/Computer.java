package com.company;

import java.util.Random;

public class Computer extends Player{

    public Computer(){
        super("Computer");
    }

    /**
     * Randomly select a move for the computer 0 = Rock, 1 = Paper, 2 = Scissor
     * and assign it to the played attribute
     */
    public void getMove(){
        Random rand = new Random();
        int cpuMove = rand.nextInt(3);
        if(cpuMove == 0){
            super.setPlayed("Rock");
        }
        else if(cpuMove == 1){
            super.setPlayed("Paper");
        } else{
            super.setPlayed("Scissor");
        }
    }
}
