package com.javapractice;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        double cost;
        double vat;
        Scanner sc= new Scanner(System.in) ;

        System.out.printf("Enter a cost:");
        cost=sc.nextDouble();
        System.out.println(cost);

        System.out.printf("Enter VAT:");
        vat=sc.nextDouble();
        System.out.println(vat);

        double finalVAT=VAT(vat,cost);
        double finalPrice = finalVAT+cost;

        System.out.printf("Total price:");
        System.out.println(finalPrice);
    }
    static double VAT(double vat, double cost){
       double final_vat = cost*(vat/100);

       return final_vat;
    }
}