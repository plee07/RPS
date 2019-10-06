package com.company;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class GameManager {
    private Player player1;
    private Player player2;
    private ArrayList<Result> history;
    int roundsPlayed;
    Scanner scanner;


    public GameManager(){
        this.player1 = new Human("Player One");
        this.player2 = null;
        this.roundsPlayed = 0;
        this.scanner = new Scanner(System.in);
        this.history = new ArrayList<Result>();
    }

    /**
     * Life cycle of the game, will run until the user selects the quit option
     */
    public void game(){
        String menuInput;
        System.out.println("Welcome to Rock, Paper, Scissors!\n");

        while(true){
            menuInput = mainMenu();

            if(menuInput.equalsIgnoreCase("quit")){
                break;
            }
            else if(menuInput.equalsIgnoreCase("play")){
                assignPlayers();
                playRound();
            }
            else{
                viewHistory();
            }
        }
    }

    /**
     * Load the main menu where user will select which option to pick
     * Continuously reload until a valid input is received
     * @return the user input
     */
    private String mainMenu(){
        String userInput = "";
        while(!isValidInput("MENU", userInput)){
            System.out.println("MAIN MENU\n========");
            System.out.println("1. Type 'play' to play.");
            System.out.println("2. Type 'history' to view your game history.");
            System.out.println("3. Type 'quit' to stop playing.\n");
            System.out.print("Enter here: ");
            userInput = scanner.nextLine();
            System.out.println();
        }
        return userInput;
    }

    /**
     * Helper method to check the validity of various user inputs
     * @param type - the type of user input we can to check, validity check will differ by types ("MENU", "OPPONENT", "MOVE")
     * @param input - user input from menu option
     * @return true if valid option, false otherwise
     */
     //TODO make the valid type an ENUM
    public static boolean isValidInput(String type,String input){
        if(type.equals("MENU")){
            return (
                    input.equalsIgnoreCase("play") ||
                    input.equalsIgnoreCase("history") ||
                    input.equalsIgnoreCase("quit")
                    );
        }
        else if(type.equals("OPPONENT")){
            return (input.equalsIgnoreCase("player") || input.equalsIgnoreCase("computer"));
        }
        else if(type.equals("MOVE")){
            return ( input.equalsIgnoreCase("Rock") ||
                            input.equalsIgnoreCase("Paper") ||
                            input.equalsIgnoreCase("Scissor")
                    );
        }
        else{
            System.out.println("Incorrect Type Entered");
            return false;
        }
    }

    /**
     * Ask the user to choose computer or player as an opponent
     * Continuously reload until a valid input is given
     */
    // TODO: currently assigning a generic name for players - update to ask for player name
    private void assignPlayers(){
        String userInput = "";
        while(!isValidInput("OPPONENT", userInput)){
            System.out.println("1. Type 'player' to vs another player");
            System.out.println("2. Type 'Computer' to vs a Computer\n");
            System.out.print("Enter here: ");
            userInput = scanner.nextLine();
            System.out.println();
        }

        // Only assign if current player2 is not an instance of the selected opponent
        if(userInput.equalsIgnoreCase("player") && !(player2 instanceof Human)){
            this.player2 = new Human("Player Two");
        }
        if(userInput.equalsIgnoreCase("computer") && !(player2 instanceof Computer)){
            this.player2 = new Computer();
        }
    }

    /**
     * Play a single round of rock, paper, scissors
     * Continuously reload until a correct input is given
     */
    private void playRound(){
        player1.getMove();
        player2.getMove();
        int getResult = player1.compareTo(player2);
        printResultSaveScore(getResult);

    }

    /**
     * Print out history of games played during session
     * Made use of stream and lambda expression
     */
    private void viewHistory(){
        System.out.println("HISTORY\n========");
        List<String> printResult = history.stream()
                .map(res -> {
                    if(res.isTie()){
                        return String.format("TIE. %s played %s and %s played %s",
                                res.getWinner(), res.getWinnerMove(), res.getLoser(), res.getLoserMove());
                    }
                    else{
                        return String.format("%s WINS. %s played %s and %s played %s",
                                res.getWinner(), res.getWinner(), res.getWinnerMove(), res.getLoser(), res.getLoserMove());
                    }
                })
                .collect(Collectors.toList());

        printResult.forEach(result-> System.out.println(result));
        System.out.println();
    }

    /**
     * Gets round result and update players win/loss score accordingly
     * print out game result
     * @param result result from compareTo, -1: player2 wins, 0: tie, 1: player 1 wins
     */
    private void printResultSaveScore(int result){
        this.roundsPlayed++;
        String res = "";
        Date date = new Date();
        //player 1 wins
        if(result > 0){
            res = player1.getName() + " wins!";
            history.add(new Result(player1.getName(),player1.getPlayed(), player2.getName(),player2.getPlayed(),date, false));

        }
        //player 2 wins
        else if(result < 0){
            res = player2.getName() + " wins!";
            history.add(new Result(player2.getName(),player2.getPlayed(), player1.getName(),player1.getPlayed(),date, false));
        }
        //tie
        else{
            res = "TIE!";
            history.add(new Result(player1.getName(),player1.getPlayed(), player2.getName(),player2.getPlayed(),date, true));
        }

        // print out result
        System.out.printf("ROUND %d\n========\n %s picks %s and %s picks %s\n %s\n\n",
                this.roundsPlayed, player1.getName(), player1.getPlayed(), player2.getName(), player2.getPlayed(), res);
    }

}
