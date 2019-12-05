package com.company;

public class SumDouble {

    public static void main(String[] args) {

        double[] values = new double[args.length];
        int i = 0;

        while (i < args.length) {
            values [i] = Double.parseDouble(args[i]);
            i++;
        }


        System.out.printf("%.2f", summ(values));
    }

    public static double summ( double... numbers ) {
        double total = 0.0;

        for (double d : numbers)
            total += d;
        return total;
    }

}
