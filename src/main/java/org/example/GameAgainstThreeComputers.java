package org.example;

import java.util.Random;
import java.util.Scanner;

public class GameAgainstThreeComputers {
    private final String[] MOVES = {"Rock", "Paper", "Scissors", "Lizard", "Spock"};
    private final String[] computerNames = {"Karen 3000 v6.9", "AI-ron man", "Mike Litoris"};
    private int playerMove;
    private int[] computerMoves;
    private int playerScore;
    private int[] computerScores;
    private int totalComputerPlayers = 3;


    public void playGame() {
        System.out.println("\nHeyooo! Welcome to Rock-Paper-Scissors-Lizard-Spock game!");
        System.out.println("\nYou will play 3 rounds against each computer player, wish you the best of luck!");
        System.out.println("Moves: 1-Rock, 2-Scissors, 3-Paper, 4-Lizard, 5-Spock");

        int totalPlayerScore = 0;
        boolean playerWonAllSets = true;

        for (int playerIndex = 0; playerIndex < totalComputerPlayers; playerIndex++) {
            System.out.println("\n=========================================");
            System.out.println("Playing against " + computerNames[playerIndex]);
            System.out.println("=========================================");
            playerScore = 0;
            int result = playRoundsWithComputer(playerIndex);
            if (result == 1) {
                System.out.println("\nYou won the set against " + computerNames[playerIndex] + "!");
            } else if (result == -1) {
                System.out.println("\nYou lost to " + computerNames[playerIndex] + " in this set.");
                playerWonAllSets = false;
                break;
            } else {
                System.out.println("\nIt's a draw in this set against " + computerNames[playerIndex] + ".");
                playerWonAllSets = false;
                break;
            }
            totalPlayerScore += playerScore;
        }

        if (playerWonAllSets) {
            System.out.println("\nCongratulations! You won all the sets against all computer players!");
        } else {
            System.out.println("\nYou lost to one of the computer players or it's a draw in one of the sets. Better luck next time!");
        }

        System.out.println("Total Player Score: " + totalPlayerScore);
    }


    private int playRoundsWithComputer(int playerIndex) {
        playerScore = 0;
        computerScores = new int[totalComputerPlayers];
        computerMoves = new int[totalComputerPlayers];
        for (int i = 1; i <= 3; i++) {
            System.out.println("\nRound " + i + " has begun!");
            getPlayerMove();
            getComputerMove(playerIndex);
            determineWinner(playerIndex);
        }
        int playerSetScore = playerScore;
        int computerSetScore = computerScores[playerIndex];
        if (playerSetScore > computerSetScore) {
            return 1;
        } else if (playerSetScore < computerSetScore) {
            return -1;
        } else {
            return 0;
        }
    }

    private void getPlayerMove() {
        Scanner scanner = new Scanner(System.in);
        int input;
        do {
            System.out.println("Choose your move (enter number from 1 to 5)");
            while (!scanner.hasNextInt()) {
                System.out.println("Invalid move! Please choose a number between 1 and 5!");
                scanner.next();
            }
            input = scanner.nextInt();
        } while (input < 1 || input > 5);
        playerMove = input;
        System.out.println("You chose: " + MOVES[playerMove - 1]);
    }

    private void getComputerMove(int playerIndex) {
        Random random = new Random();
        computerMoves[playerIndex] = random.nextInt(5) + 1;
        System.out.println(computerNames[playerIndex] + " chose: " + MOVES[computerMoves[playerIndex] - 1]);
    }

    private void determineWinner(int playerIndex) {
        int computerMove = computerMoves[playerIndex];
        if (playerMove == computerMove) {
            System.out.println("This round ended with a DRAW!");
        } else if ((playerMove == 1 && (computerMove == 3 || computerMove == 4)) ||
                (playerMove == 2 && (computerMove == 1 || computerMove == 5)) ||
                (playerMove == 3 && (computerMove == 2 || computerMove == 4)) ||
                (playerMove == 4 && (computerMove == 2 || computerMove == 5)) ||
                (playerMove == 5 && (computerMove == 1 || computerMove == 3))) {
            playerScore++;
            System.out.println("VERY NICE! You WON this round!");
        } else {
            computerScores[playerIndex]++;
            System.out.println(computerNames[playerIndex] + " wins this round!");
        }
    }
}
