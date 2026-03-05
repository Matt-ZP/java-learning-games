package com.mattzp.games.util;

import java.util.Scanner;

public class ConsoleInput {

    public static int readMenuChoice(Scanner input, int maxOption, String prompt) {


        while (true) {

            System.out.print(prompt);

            if (!input.hasNextInt()) {
                System.out.println("\nIncorrect Entry. Please enter only numbers between 0 and " + maxOption + "." +
                        "\nNo letters or symbols accepted.");
                input.next();
                continue;
            }

            int choice = input.nextInt();

            if (choice < 0 || choice > maxOption) {
                System.out.println("\nIncorrect Entry. Please enter a number between 0 and " + maxOption + ".");
                continue;
            }
            return choice;

        }

        }
    }

