/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.filereadwriteprogram;

/*

Name Sammy Ramadan

CIT130

Date 10/11/24

Purpose of file This program outputs a read and write system from binary or text files

*/

import java.io.*;
import java.util.Scanner;

public class FileReadWriteProgram {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String continueChoice;

        do {
            System.out.print("Enter the file name: ");
            String fileName = scanner.nextLine();

            System.out.print("Choose binary or text file (b/t): ");
            char fileType = scanner.nextLine().charAt(0);

            System.out.print("Choose read or write (r/w): ");
            char mode = scanner.nextLine().charAt(0);

            if (mode == 'w') {
                if (fileType == 'b') {
                    writeToBinaryFile(fileName, scanner);
                } else {
                    writeToTextFile(fileName, scanner);
                }
            } else {
                if (fileType == 'b') {
                    readFromBinaryFile(fileName);
                } else {
                    readFromTextFile(fileName);
                }
            }

            System.out.print("Continue? (y/n): ");
            continueChoice = scanner.nextLine();
        } while (continueChoice.equalsIgnoreCase("y"));

        System.out.println("Process completed.");
    }

    private static void writeToBinaryFile(String fileName, Scanner scanner) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            String line;
            do {
                System.out.print("Enter a line of information to write to the file: ");
                line = scanner.nextLine();
                oos.writeObject(line);

                System.out.print("Would you like to enter another line? Y/N only: ");
            } while (scanner.nextLine().equalsIgnoreCase("Y"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void readFromBinaryFile(String fileName) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            System.out.println("File contains:");
            String line;
            while (true) {
                line = (String) ois.readObject();
                System.out.println(line);
            }
        } catch (EOFException e) {
            // End of file reached
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void writeToTextFile(String fileName, Scanner scanner) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {
            String line;
            do {
                System.out.print("Enter a line of information to write to the file: ");
                line = scanner.nextLine();
                writer.println(line);

                System.out.print("Would you like to enter another line? Y/N only: ");
            } while (scanner.nextLine().equalsIgnoreCase("Y"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void readFromTextFile(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            System.out.println("File contains:");
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

