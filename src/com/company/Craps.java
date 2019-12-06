package com.company;

import java.security.SecureRandom;

public class Craps {

    // create secure random number generator for use in method rollDice
    private static final SecureRandom randomNumbers = new SecureRandom();
    // enum type with constants that represent the game status
    private enum Status { CONTINUE, WON, LOST };
    // constants that represent common rolls of the dice
    private static final int SNAKE_EYES = 2;
    private static final int TREY = 3;
    private static final int SEVEN = 7;
    private static final int YO_LEVEN = 11;
    private static final int BOX_CARS = 12;

    // plays 100 games of craps
    public static void main(String[] args) {

//        int games = 1000;
        int[] wins = new int[21];
        int[] loses = new int[21];

        int winsAfter20 = 0;
        int losesAfter20 = 0;
        int totalWins = 0;
        int totalLoses = 0;
        int lenhgtOfGame = 0;
        int nrOfGames = 1_000_000;

        for (int i = 0; i < nrOfGames; i++) {

         int nrOfGame = 0;

        int myPoint = 0; // point if no win or loss on first roll
        Status gameStatus; // can contain CONTINUE, WON or LOST
        int sumOfDice = rollDice(); // first roll of the dice
// determine game status and point based on first roll
        switch (sumOfDice) {
            case SEVEN: // win with 7 on first roll
            case YO_LEVEN: // win with 11 on first roll
            {
                gameStatus = Status.WON;
                wins[0]++;
            }
            break;
            case SNAKE_EYES: // lose with 2 on first roll
            case TREY: // lose with 3 on first roll
            case BOX_CARS: // lose with 12 on first roll
            {
                gameStatus = Status.LOST;
                loses[0]++;
            }
                break;
            default: // did not win or lose, so remember point
                gameStatus = Status.CONTINUE; // game is not over
                // nrOfGame++;
                myPoint = sumOfDice; // remember the point
             //   System.out.printf("Point is %d%n", myPoint);
                break;
        }


        // while game is not complete
        while (gameStatus == Status.CONTINUE) {  // not WON or LOST
            sumOfDice = rollDice(); // roll dice again
            nrOfGame++;
            lenhgtOfGame++;

            // determine game status
            if (sumOfDice == myPoint) { // win by making point
                gameStatus = Status.WON;
                if (nrOfGame > 19) {
                    winsAfter20++;
                }
                else {
                    wins[nrOfGame]++;
                }
            }
            else if (sumOfDice == SEVEN) { // lose by rolling 7 before point
                gameStatus = Status.LOST;
                if (nrOfGame > 19) {
                    losesAfter20++;
                }
                else {
                loses[nrOfGame]++;
                }
            }
        }

        }


        for (int a = 0; a < 20; a++) {
            System.out.printf("The game Nr. %2d :: won %6d ; lost %6d%n", a + 1, wins[a], loses[a]);
            totalWins += wins[a];
            totalLoses += loses[a];
        }

        totalWins += winsAfter20;
        totalLoses += losesAfter20;

        System.out.println("************************************************");
        System.out.printf("The games after 20 :: won %6d ; lost %6d%n", winsAfter20, losesAfter20);
        System.out.println("************************************************");
        System.out.printf("%5d won games / %6d games == %.2f %s%n", totalWins, nrOfGames, (float)totalWins / nrOfGames * 100, "%");
        System.out.println("************************************************");
        System.out.printf("The agerage lenght of game :: %.2f%n", (float) lenhgtOfGame / nrOfGames);
        System.out.println("************************************************");
        System.out.printf("%d wins + %d loses = %d", totalWins, totalLoses, totalWins + totalLoses);

    }


    public static int rollDice() {

        int die1 = 1 + randomNumbers.nextInt(6);
        int die2 = 1 + randomNumbers.nextInt(6);
        int sum = die1 + die2;
        return sum;
    }
}