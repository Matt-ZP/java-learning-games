package com.mattzp.games.impl;

import com.mattzp.games.Game;

import java.util.Scanner;

public class GuessingGame implements Game {
    private static final String GUESS_PROMPT = "\nEnter your guess (1-50): ";
    private static final String INVALID_RANGE = "Invalid range. You must enter an integer between 1 and 100";
    private static final String INVALID_TYPE = "Invalid entry. Only integers between 1 and 50 are accepted";
    private static final String TOO_MANY_FALSE_ATTEMPTS = "You have entered too many false attempts";
    private static final String TOO_HIGH = "You guessed too high!";
    private static final String TOO_LOW = "You guessed too low!";
    private static final String WIN = "\nCongratulations! You guessed correctly!";
    private static final String PLAY_AGAIN = "\nPlay another round? (y/n): ";
    private static final String INVALID_INPUT = "Invalid input. Enter 'y' to play again or 'n' to exit.";
    private static final String RETURN_TO_LAUNCHER = "Thanks for playing.";
    private static final String WARNING =
            "You have entered incorrect data 5 times. 2 further incorrect types of input will cause game to exit";

    private int invalidTotal = 0;
    private int invalidStreak = 0;
    private boolean warned = false;

    @Override
    public String name() {
        return "Guessing Game";
    }

    @Override
    public void start(Scanner input) {
        System.out.println("\nWELCOME TO THE GUESSING GAME:\n5 guesses to win a prize!");

            while (true) {
                boolean aborted = playRound(input);
                if (aborted) break;

                if (!playAgain(input)) break;
            }

        System.out.println(RETURN_TO_LAUNCHER);
    }

    // returns true if the game should abort due to invalid-input policy
    private boolean playRound(Scanner input) {
        int totalGuesses = 0;
        int target = generateTargetNumber();

        while (totalGuesses < 5) {
            int guess = getValidGuess(input);

            if (guess == -1) {
                // abort triggered inside getValidGuess()
                return true;
            }

            if (guess == target) {
                System.out.println(WIN);
                return false; // round ends on win
            }

            printHint(guess, target);
            totalGuesses++;
        }

        System.out.println("\nOut of guesses! The number was: " + target);

        return false;
    }

    private int getValidGuess(Scanner input) {
        while (true) {
            System.out.print(GUESS_PROMPT);

            if (!input.hasNextInt()) {
                System.out.println(INVALID_TYPE);
                input.next(); // consume the bad token

                if (handleInvalidAttempt()) return -1;
                continue;
            }

            int guess = input.nextInt();

            if (guess < 1 || guess > 50) {
                System.out.println(INVALID_RANGE);

                if (handleInvalidAttempt()) return -1;
                continue;
            }

            // valid input resets streak
            invalidStreak = 0;
            return guess;
        }
    }

    private boolean playAgain(Scanner input) {
        while (true) {
            System.out.print(PLAY_AGAIN);
            String answer = input.next().toLowerCase().trim();

            if (answer.equals("y")) {
                invalidStreak = 0;
                return true;
            }

            if (answer.equals("n")) {
                invalidStreak = 0;
                return false;
            }

            System.out.println(INVALID_INPUT);
            if (handleInvalidAttempt()) return false;
        }
    }

    // true = abort game now, false = keep going
    private boolean handleInvalidAttempt() {
        invalidTotal++;
        invalidStreak++;

        if (invalidTotal == 5 && !warned) {
            System.out.println(WARNING);
            warned = true;
        }

        if (invalidStreak >= 5 || invalidTotal >= 7) {
            System.out.println(TOO_MANY_FALSE_ATTEMPTS);
            return true;
        }

        return false;
    }

    private void printHint(int guess, int target) {
        if (guess > target) {
            System.out.println(TOO_HIGH);
        } else {
            System.out.println(TOO_LOW);
        }
    }

    private int generateTargetNumber() {
        return (int) ((Math.random() * 50) + 1);
    }
}


