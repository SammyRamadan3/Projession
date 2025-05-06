/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.birthdayparadox;

/*

Name Sammy Ramadan

CIT130

Date 11/16/24

Purpose of file Use a HashSet to do a Monte Carlo analysis of the birthday paradox

*/
import java.util.HashSet;
import java.util.Random;

public class BirthdayParadox {

    public static void main(String[] args) {
        // Number of tests to run
        int numTests = 100000;
        
        // Loop through different group sizes
        for (int groupSize = 10; groupSize <= 100; groupSize += 10) {
            int collisionCount = 0;
            
            // Run the simulation for 'numTests' iterations
            for (int test = 0; test < numTests; test++) {
                HashSet<Integer> birthdays = new HashSet<>();
                boolean collisionOccurred = false;
                
                // Simulate the birthdays for 'groupSize' people
                for (int person = 0; person < groupSize; person++) {
                    // Generate a random birthday between 1 and 365 (inclusive)
                    int birthday = new Random().nextInt(365) + 1;
                    
                    // Check if this birthday is already in the set (collision)
                    if (birthdays.contains(birthday)) {
                        collisionCount++;
                        collisionOccurred = true;
                        break;  // Stop checking once a collision is found
                    }
                    
                    // Add the birthday to the set
                    birthdays.add(birthday);
                }
            }
            
            // Calculate the probability of a birthday collision
            double probability = (double) collisionCount / numTests;
            
            // Output the result for this group size
            System.out.printf("After %d tests there were %d occurrences of shared birthdays in a set of %d people.%n", 
                    numTests, collisionCount, groupSize);
            System.out.printf("Probability: %.5f%n", probability);
        }
        
        System.out.println("Process completed.");
    }
}
