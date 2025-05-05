/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.sierpinskigasket;

/*

Name Sammy Ramadan

CIT130

Date 11/23/24

Purpose of file Create a recursionless SierpinskiGasket with no triangles

*/
import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class SierpinskiGasket extends JPanel {

    // The three vertices of the triangle
    private static final int[] x = {400, 50, 750}; // x-coordinates of the triangle's vertices
    private static final int[] y = {50, 600, 600}; // y-coordinates of the triangle's vertices

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        // Cast Graphics object to Graphics2D for better control
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.BLACK); // Color of the pixels

        // Initialize the random number generator
        Random rand = new Random();

        // Start with a random vertex
        int currentX = x[rand.nextInt(3)];
        int currentY = y[rand.nextInt(3)];

        // Loop 50,000 times to generate the points
        for (int i = 0; i < 50000; i++) {
            // Randomly choose one of the three vertices
            int targetIndex = rand.nextInt(3);
            int targetX = x[targetIndex];
            int targetY = y[targetIndex];

            // Find the midpoint between the current point and the target vertex
            currentX = (currentX + targetX) / 2;
            currentY = (currentY + targetY) / 2;

            // Draw a pixel at the midpoint (using drawLine to draw a single pixel)
            g2d.drawLine(currentX, currentY, currentX, currentY);
        }
    }

    public static void main(String[] args) {
        // Set up the JFrame to display the panel
        JFrame frame = new JFrame("Sierpinski Gasket");
        SierpinskiGasket panel = new SierpinskiGasket();
        frame.setSize(800, 800); // Set the size of the frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel); // Add the panel to the frame
        frame.setVisible(true); // Make the frame visible
    }
}

