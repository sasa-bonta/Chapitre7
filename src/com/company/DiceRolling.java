package com.company;

import java.util.Scanner;
import java.security.SecureRandom;

public class DiceRolling {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int d1;
        int d2;
        int[] summ = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

        for (int i = 0; i < 36000000; i++){
            d1 = diceRolling();
            d2 = diceRolling();
            summ[d1 + d2]++;
        }

        for (int i = 0; i < 11; i++) {
            System.out.printf("{%d} = %d%n", i+2, summ[i]);
        }


    }

    public static int diceRolling () {
        SecureRandom randomNumbers = new SecureRandom();
        int dice = randomNumbers.nextInt(6);
        return dice;
    }
}
