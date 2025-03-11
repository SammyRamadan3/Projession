/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.smilingface;

/*

Name Sammy Ramadan

CIT130

Date 11/29/24

Purpose of file Create SmilingFace with two buttons frown and smile

*/
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SmilingFace extends JPanel {
    
    // Variables to track if the face is smiling or frowning
    private boolean isSmiling = true;

    // Draw the face with a smile or frown
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        // Cast Graphics to Graphics2D for better drawing control
        Graphics2D g2d = (Graphics2D) g;

        // Set up the face drawing
        g2d.setColor(Color.YELLOW);  // Face color
        g2d.fillOval(100, 100, 300, 300);  // Draw face (head)

        // Set up the eyes
        g2d.setColor(Color.BLACK);
        g2d.fillOval(170, 170, 40, 40);  // Left eye
        g2d.fillOval(270, 170, 40, 40);  // Right eye

        // Draw the smile or frown based on the state
        if (isSmiling) {
            g2d.setColor(Color.BLACK);
            g2d.drawArc(160, 230, 180, 100, 0, -180);  // Smile
        } else {
            g2d.setColor(Color.BLACK);
            g2d.drawArc(160, 250, 180, 100, 0, 180);  // Frown
        }
    }

    public static void main(String[] args) {
        // Create JFrame and set up the layout
        JFrame frame = new JFrame("Smiling or Frowning Face");
        SmilingFace panel = new SmilingFace();
        
        frame.setSize(500, 500);  // Set frame size
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Create the buttons to trigger smile and frown
        JButton smileButton = new JButton("Frown");
        JButton frownButton = new JButton("Smile");

        // Set up the smile button to change the face to a frown
        smileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Change the face to a frown
                panel.isSmiling = false;
                smileButton.setText("Smile");  // Change button text
                frownButton.setText("Smile");  // Update other button text
                panel.repaint();  // Repaint the face
            }
        });

        // Set up the frown button to change the face to a smile
        frownButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Change the face to a smile
                panel.isSmiling = true;
                smileButton.setText("Frown");  // Change button text
                frownButton.setText("Frown");  // Update other button text
                panel.repaint();  // Repaint the face
            }
        });

        // Set up the layout with buttons at the bottom
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(smileButton);
        buttonPanel.add(frownButton);

        // Add the panel and button panel to the frame
        frame.add(panel, BorderLayout.CENTER);
        frame.add(buttonPanel, BorderLayout.SOUTH);

        // Make the frame visible
        frame.setVisible(true);
    }
}

