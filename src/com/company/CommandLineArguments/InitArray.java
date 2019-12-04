package com.company.CommandLineArguments;

public class InitArray {

    public static void main(String[] args) {

        int[] array = new int[10];
        //int arrayLength;

        if (args.length == 2) {
            int initialValue = Integer.parseInt(args[0]);
            int increment = Integer.parseInt(args[1]);
        }

        if (args.length == 3){
            int arrayLength = Integer.parseInt(args[0]);
            array = new int[arrayLength];

            int initialValue = Integer.parseInt(args[1]);
            int increment = Integer.parseInt(args[2]);

            for (int counter = 0; counter < array.length; counter++)
                array[counter] = initialValue + increment * counter;
            System.out.printf("%s%8s%n", "Index", "Value");

            for (int counter = 0; counter < array.length; counter++)
                System.out.printf("%5d%8d%n", counter, array[counter]);
        }

        for (int counter = 0; counter < array.lenght; counter++)
            System.out.printf("%5d%8d%n", counter, array[counter]);
    }
}
