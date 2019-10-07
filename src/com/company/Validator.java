package com.company;

public class Validator {

    /**
     * Validator to check if user input for menu option is valid
     * @param input user input
     * @return true if input is 'play', 'history', or 'quit' (case insensitive)
     */
    public static boolean menuInputValidator(String input){
        return (
                input.equalsIgnoreCase("play") ||
                        input.equalsIgnoreCase("history") ||
                        input.equalsIgnoreCase("quit")
        );
    }

    /**
     * Validator to check if user input for opponent is valid
     * @param input user input
     * @return true if user inputs 'player' or 'computer' (case insensitive)
     */
    public static boolean opponentInputValidator(String input) {
        return (input.equalsIgnoreCase("player") || input.equalsIgnoreCase("computer"));
    }

    /**
     * Validator to check if user input for move is valid
     * @param input user input
     * @return true if user inputs 'rock', 'paper', or 'scissor' (case insensitive)
     */
    public static boolean moveInputValidator(String input){
        return ( input.equalsIgnoreCase("Rock") ||
                input.equalsIgnoreCase("Paper") ||
                input.equalsIgnoreCase("Scissor")
        );
    }

}