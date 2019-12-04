package com.company.VariableLenght;

import java.util.Scanner;

public class Product {

    public static void main(String[] args) {

        System.out.printf("7 * 8 * 78 = %d%n", product(7,8,78));
        System.out.printf("10 * 9 * 8 * 7 * 6 * 5 = %d%n", product(10, 9, 8, 7, 6 ,5));
    }

    public static int product(int ... a) {
        int product = 1;
        for (int i: a) {
            product *= i;
        }
        return product;
    }
}
