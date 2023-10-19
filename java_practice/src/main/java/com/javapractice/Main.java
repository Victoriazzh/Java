package com.javapractice;
import java.text.CollationElementIterator;
import java.util.*;


//interface in Java
interface Prompt{
    Object getValue();
}

class intPrompt implements Prompt{
    private Scanner sc = new Scanner(System.in);

    public Object getValue(){
        System.out.print("Enter a Integer: ");
        return sc.nextInt();
    }
}

class doublePrompt implements Prompt{
    private Scanner sc = new Scanner(System.in);
    public Object getValue(){
        System.out.print("Enter a Double: ");
        return sc.nextDouble();
    }
}

class stringPrompt implements Prompt{
    private Scanner sc = new Scanner(System.in);
    public Object getValue(){
        System.out.print("Enter a String: ");
        return sc.nextLine();
    }
}

class userPrompt {
    //declare variables
    private Scanner sc = new Scanner(System.in);
    private Scanner scString= new Scanner(System.in);
    private double cost, vat;
    private int quantity;
    private String input;

    public double getCost(){
        System.out.print("Enter a cost: ");
        this.cost = sc.nextDouble();
        return cost;
    }

    public double getVat(){
        System.out.print("Enter VAT rate (%): ");
        this.vat = sc.nextDouble();
        return vat;
    }

    public int getQuantity(){
        System.out.print("Enter the quantity: ");
        this.quantity=sc.nextInt();
        return quantity;
    }

    public String getQuitStatus(){
        System.out.print("Type QUIT to stop or press ENTER to continue: ");
        input = scString.nextLine();
        return input;
    }
}



//task 5
class PurchasedItem {
    private double costPrice,vatRate,totalCost,finalPrice;
    private int quantity;
    private ArrayList<Double> prices;

    //initializes the dynamic array
    public PurchasedItem(){
        prices= new ArrayList<>();
    }

    public void setItems(double costPrice, double vatRate, double totalCost, int quantity){
        this.quantity = quantity;
        this.vatRate=vatRate;
        this.costPrice=costPrice;
        this.totalCost=totalCost;
    }
    protected void getFinalPrice(){
        double vatValue = costPrice*((vatRate/100)+1);
        System.out.printf("Price per item %.2f %n",costPrice+vatValue);
        finalPrice=(costPrice+vatValue)*quantity;
        System.out.printf("This price for all the items are: £%.2f%n", finalPrice);
        prices.add(finalPrice);
    }

    protected double getTotalCost(){
        totalCost+=finalPrice;
        System.out.printf("the total cost is: £%.2f%n",totalCost);
        return totalCost;
    }

    public void printList(){
        System.out.println("These are the sorted prices: ");
        for (double price : prices) {
            System.out.printf("£%.2f %n", price);
        }
    }

    public void sortList(){
        Collections.sort(prices);
    }

}
public class Main {
    public static void main(String[] args) {
        //declare variables
        boolean continueCalculations = true;
        double totalCost=0;
        double cost,vat;
        int quantity;
        String input;

        //userPrompt inputs = new userPrompt();
        PurchasedItem item = new PurchasedItem();


        while (continueCalculations) {
            try {
                System.out.print("Enter the cost: ");
                cost = new doublePrompt();
                vat= inputs.getVat();
                quantity=inputs.getQuantity();

                item.setItems(cost, vat, totalCost, quantity);
                item.getFinalPrice();


                totalCost=item.getTotalCost();
                input=inputs.getQuitStatus();

                if (input.equalsIgnoreCase("QUIT")) {
                    continueCalculations = false;
                }

            } catch (InputMismatchException e) {
                System.out.println("Incorrect value. Please enter valid numbers.");
            }
        }
        //after quit print sorted array
        //use collections to sort the array prices and then output it
        item.sortList();
        item.printList();
    }
}
