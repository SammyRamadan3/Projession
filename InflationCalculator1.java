/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.inflationcalculator;

import java.util.Scanner;

/**
 *9/12/24
 * @author SammyRamadan
 */
public class InflationCalculator {

    public static void main(String[] args) {
         // Create a Scanner object for user input
        Scanner scanner = new Scanner(System.in);

        // Get the current cost of the item from the user
        System.out.print("Enter the current cost of the item: ");
        double currentCost = scanner.nextDouble();

        // Get the expected inflation rate from the user
        System.out.print("Enter the expected inflation rate per year\n(Enter as a percentage and do not include the percent sign): ");
        double inflationRate = scanner.nextDouble();

        // Get the number of years to project the cost
        System.out.print("Enter the whole number of years in the future to project cost: ");
        int years = scanner.nextInt();

        // Convert inflation rate from percentage to a decimal
        inflationRate = inflationRate / 100;

        // Initialize future cost to the current cost
        double futureCost = currentCost;

        // Calculate the future cost using a for loop
        for (int i = 0; i < years; i++) {
            futureCost = futureCost * (1 + inflationRate);
        }

        // Print the result
        System.out.printf("At %.2f%% inflation per year, the cost in %d year(s) will be $%.2f.%n", 
                          inflationRate * 100, years, futureCost);
    }
}


    