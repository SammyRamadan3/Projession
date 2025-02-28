/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.compoundinterestcalculator;

/**
 * 2/11/24
 * @author sammy
 */
import java.util.Scanner;

public class CompoundInterestCalculator {
  public static void main(String[] args) {
    // Created Scanner object for user input
    Scanner input = new Scanner(System.in);

    // line for principal amount
    System.out.println("Enter the principal amount:");
    double principal = input.nextDouble();

    // line for interest rate
    System.out.println("Enter the interest rate:");
    double interestRate = input.nextDouble() / 100;

    // line for number of times compounded
    System.out.println("Enter the number of times compounded:");
    int timesCompounded = input.nextInt();

    // line for number of years
    System.out.println("Enter the number of years:");
    int years = input.nextInt();

    // Calculated final amount using compound interest formula
    double finalAmount = principal * Math.pow(1 + interestRate / timesCompounded, timesCompounded * years);

    // Round the final amount to 2 decimal places
    finalAmount = Math.round(finalAmount * 100.0) / 100.0;

    // Final amount display
    System.out.println("The final amount after " + years + " years is: $" + finalAmount);

    // End
    input.close();
  }
}