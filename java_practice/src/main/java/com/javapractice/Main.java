package com.javapractice;
import java.text.CollationElementIterator;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        //declare variables
        Scanner sc = new Scanner(System.in);
        Scanner scString= new Scanner(System.in);
        boolean continueCalculations = true;
        double totalCost=0;

        // ---------Only for task 3---------//
        //static array that grows
        //double[] prices = new double[5];
        //int entries=0;

        //task 4 defining dynamic arrays
        ArrayList<Double> prices = new ArrayList<>();

        while (continueCalculations) {
            double cost;
            double vat;
            String input;

            try {
                System.out.print("Enter a cost: ");
                cost = sc.nextDouble();
                System.out.print("Enter VAT rate (%): ");
                vat = sc.nextDouble();

                // ---------Only for task 3---------//
                //if the index is now the size of the array we must increment it
                //if (entries== prices.length){
                    //make prices the original prices with 2 more slots
                   // prices= Arrays.copyOf(prices,prices.length+2);
                //}

                double finalVAT = VAT(vat, cost);
                double finalPrice = finalVAT + cost;

                totalCost+=finalPrice;

                // add the final price to the prices array at the end
                prices.add(finalPrice);



                System.out.printf("This price is: £%.2f%n", finalPrice);
                System.out.printf("the total cost is: £%.2f%n",totalCost);

                System.out.print("Type QUIT to stop or press ENTER to continue: ");
                input = scString.nextLine();

                if (input.equalsIgnoreCase("QUIT")) {
                    continueCalculations = false;
                }

                // ---------Only for task 3---------//
                //increment entries
                //entries++;

            } catch (InputMismatchException e) {
                System.out.println("Incorrect value. Please enter valid numbers.");
                sc.nextLine(); // Consume the invalid input
            }
        }


        //after quit print sorted array

        //use collections to sort the array prices and then output it
        Collections.sort(prices);
        System.out.println("These are the sorted prices: ");
        for (double price : prices) {
            System.out.printf("£%.2f %n", price);
        }
    }

    static double VAT(double vat, double cost) {
        return cost * (vat / 100);
    }
}
