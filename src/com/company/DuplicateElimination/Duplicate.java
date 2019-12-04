package com.company.DuplicateElimination;

import java.util.Scanner;

public class Duplicate {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int array[] = {0, 0, 0, 0, 0};
        int num;
        byte founded;

        for (int i = 0; i < 5; i++) {
            num = enterNumber();

            if (checkArray(array, num) == 0) {
                array[i] = num;

                for (int j : array) {
                    if (j != 0) {
                        System.out.println(j);
                    }
                }
            }
        }
    }

    public static byte checkArray(int array[], int num) {
        byte founded = 0;  //0 not founded   1 founded
        for (int numCurent : array) {
            if (numCurent == num) {
                founded = 1;
            }
        }
        return founded;
    }

    public static int enterNumber() {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a number between 10 and 100 : ");
        int number = input.nextInt();

        while (number < 10 || number > 100) {
            System.out.print("Enter a number between 10 and 100 : ");
            number = input.nextInt();
        }
        return number;
    }
}
