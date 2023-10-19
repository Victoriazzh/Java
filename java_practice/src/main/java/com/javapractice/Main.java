package com.javapractice;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Scanner scString= new Scanner(System.in);
        boolean continueCalculations = true;
        double totalCost=0;

        while (continueCalculations) {
            double cost;
            double vat;
            String input;

            try {
                System.out.print("Enter a cost: ");
                cost = sc.nextDouble();
                System.out.print("Enter VAT rate (%): ");
                vat = sc.nextDouble();

                double finalVAT = VAT(vat, cost);
                double finalPrice = finalVAT + cost;

                totalCost+=finalPrice;

                System.out.printf("This price is: £%.2f%n", finalPrice);
                System.out.printf("the total cost is: £%.2f%n",totalCost);

                System.out.print("Type QUIT to stop or press ENTER to continue: ");
                input = scString.nextLine();

                if (input.equalsIgnoreCase("QUIT")) {
                    continueCalculations = false;
                }
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
