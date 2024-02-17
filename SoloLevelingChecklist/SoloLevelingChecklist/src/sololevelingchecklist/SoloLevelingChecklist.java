/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package sololevelingchecklist;

/**
 *
 * @author Clinton
 */

import java.util.Scanner;

public class SoloLevelingChecklist {
    private static String playerName;
    private static String playerClass;
    private static int exp;
    private static String[] classes = {"God", "SSS", "SS", "S", "A+", "A", "B+", "B", "C", "D", "E", "Non-Awakened"};
    private static int[] expThresholds = {50000000, 45000000, 35000000, 30000000, 25000000, 20000000, 15000000, 10000000, 5000000, 2500000, 1000000, 0};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Initialize player information
        System.out.print("Enter player name: ");
        playerName = scanner.nextLine();
        playerClass = "Non-Awakened"; // Start with Non-Awakened class
        exp = 0; // Start with 0 EXP

        // Main menu
        int choice;
        do {
            System.out.println("\n===== Solo Leveling Checklist =====");
            System.out.println("1. View Player Information");
            System.out.println("2. Complete Task (Earn EXP)");
            System.out.println("3. Check Class Progression");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    viewPlayerInformation();
                    break;
                case 2:
                    completeTask();
                    break;
                case 3:
                    checkClassProgression();
                    break;
                case 4:
                    System.out.println("Exiting program...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        } while (choice != 4);

        scanner.close();
    }

    private static void viewPlayerInformation() {
        System.out.println("\n===== Player Information =====");
        System.out.println("Name: " + playerName);
        System.out.println("Class: " + playerClass);
        System.out.println("EXP: " + exp);
    }

    private static void completeTask() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter EXP earned for completing task: ");
        int expEarned = scanner.nextInt();
        exp += expEarned;
        System.out.println("Task completed! You earned " + expEarned + " EXP.");
        checkClassProgression();
    }

    private static void checkClassProgression() {
        System.out.println("\n===== Class Progression =====");
        for (int i = 0; i < classes.length; i++) {
            if (exp >= expThresholds[i]) {
                playerClass = classes[i];
                System.out.println("Current Class: " + playerClass);
                if (i > 0) {
                    System.out.println("Next Class: " + classes[i - 1]);
                    System.out.println("EXP Threshold for Next Class: " + expThresholds[i]);
                } else {
                    System.out.println("You have reached the highest class: " + playerClass);
                }
                break;
            }
        }
    }

    public static String[] getClasses() {
        return classes;
    }

    public static int[] getExpThresholds() {
        return expThresholds;
    }
}
