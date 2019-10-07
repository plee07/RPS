package com.company;

import java.util.Scanner;

public class Human extends Player{

    public Human(String playerName){
        super(playerName);
    }

    /**
     * Ask user for move
     */
    public void getMove(){
        Scanner scanner = new Scanner(System.in);
        // each time getUserPick() gets called, clear out the previous move
        super.setPlayed("");

        // loop until a valid move is given
        while(!Validator.moveInputValidator(super.getPlayed())){
            System.out.print(super.getName() + ", pick a move (Rock, Paper, Scissor): ");
            super.setPlayed(scanner.nextLine());
        }
        System.out.println();
    }


}
