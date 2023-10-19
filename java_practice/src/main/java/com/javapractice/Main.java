package com.javapractice;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Scanner scString= new Scanner(System.in);
        boolean continueCalculations = true;
        double totalCost=0;

        //static array that grows
        double[] prices = new double[5];
        int entries=0;

        while (continueCalculations) {
            double cost;
            double vat;
            String input;

            try {
                System.out.print("Enter a cost: ");
                cost = sc.nextDouble();
                System.out.print("Enter VAT rate (%): ");
                vat = sc.nextDouble();

                //if the index is now the size of the array we must increment it
                if (entries== prices.length){
                    //make prices the original prices with 2 more slots
                    prices= Arrays.copyOf(prices,prices.length+2);
                }

                double finalVAT = VAT(vat, cost);
                prices[entries] = finalVAT + cost;

                totalCost+=prices[entries];


                System.out.printf("This price is: £%.2f%n", prices[entries]);
                System.out.printf("the total cost is: £%.2f%n",totalCost);

                System.out.print("Type QUIT to stop or press ENTER to continue: ");
                input = scString.nextLine();

                if (input.equalsIgnoreCase("QUIT")) {
                    continueCalculations = false;
                }

                //increment entries
                entries++;

            } catch (InputMismatchException e) {
                System.out.println("Incorrect value. Please enter valid numbers.");
                sc.nextLine(); // Consume the invalid input
            }
        }
    }

    static double VAT(double vat, double cost) {
        return cost * (vat / 100);
    }
}
