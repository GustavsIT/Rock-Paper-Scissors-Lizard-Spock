package org.example;

import java.util.Random;
import java.util.Scanner;

public class GameAgainstOneComputer {
    private final String[] MOVES = {"Rock", "Paper", "Scissors", "Lizard", "Spock"};
    private int playerMove;
    private int computerMove;
    private int playerScore;
    private int computerScore;

    public void playGame(){
        System.out.println("\nHeyooo! Welcome to Rock-Paper-Scissors-Lizard-Spock game!");
        System.out.println("\nYou will play 3 rounds against computer, wish you best of luck!");
        System.out.println("Moves: 1-Rock, 2-Scissors, 3-Paper, 4-Lizard, 5-Spock");
        for (int i = 1; i <= 3; i++) {
            System.out.println("\nRound "+ i+ " has begun!");
            getPlayerMove();
            getComputeMove();
            determineWinner();
        }
        getResults();
    }
    private void getPlayerMove() {
        Scanner scanner= new Scanner(System.in);
        int input;
        do{
            System.out.println("Choose your move(enter number from 1 to 5)");
            while(!scanner.hasNextInt()){
                System.out.println("Invalid move! Please choose number between 1 and 5!");
                scanner.next();
            }
            input=scanner.nextInt();
        }while(input<1||input>5);
        playerMove=input;
        System.out.println("You chose: "+ MOVES[playerMove-1]);
    }
    private void getComputeMove() {
        Random random = new Random();
        computerMove=random.nextInt(5)+1;
        System.out.println("Computer chose: "+ MOVES[computerMove-1]);
    }
    private void determineWinner() {
        if(playerMove==computerMove){
            System.out.println("This round ended with a DRAW!");
        }else if((playerMove == 1 && (computerMove == 3 || computerMove == 4)) ||
                (playerMove == 2 && (computerMove == 1 || computerMove == 5)) ||
                (playerMove == 3 && (computerMove == 2 || computerMove == 4)) ||
                (playerMove == 4 && (computerMove == 2 || computerMove == 5)) ||
                (playerMove == 5 && (computerMove == 1 || computerMove == 3))
        ){
            playerScore++;
            System.out.println("VERY NICE! You WON this round!");
        }else {
            computerScore++;
            System.out.println("Sadly computer wins you in this round!");
        }
    }
    private void getResults() {
        System.out.println("\nFinal result:");
        System.out.println("Player score: " + playerScore);
        System.out.println("Computer score: " + computerScore);
        if (playerScore > computerScore) {
            System.out.println("Congratulations! You won the game!");
        } else if (playerScore < computerScore) {
            System.out.println("Ehh, you tried...but computer wins in this game, wish you better luck next time!");
        } else {
            System.out.println("It's a DRAW! Friendship wins xD");
        }
    }
}
