package com.mattzp.games.impl;

import com.mattzp.games.Game;
import com.mattzp.games.util.WordBank;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Hangman implements Game {
    private static final int MAX_GUESSES = 10;

    @Override
    public String name() {
        return "Hangman";
    }

    @Override
    public void start(Scanner input) {
        System.out.println("Welcome to Hangman!");

        String word = produceRandomWord();
        System.out.println("Guess the word: " + word); // temporary for testing

        char[] progress = new char[word.length()];

        Arrays.fill(progress, '_');

        int remainingGuesses = MAX_GUESSES;
        Set<Character> incorrectGuesses = new HashSet<>();

        while (remainingGuesses > 0 && !isWordSolved(progress)) {

            printProgress(progress);

            char guess = readGuess(input);

            if (incorrectGuesses.contains(guess) || isAlreadyRevealed(progress, guess)) {
                System.out.println("You already guessed this letter!");
                continue;
            }

            boolean found = revealMatchingLetters(word, progress, guess);

            if (!found) {
                remainingGuesses = handleWrongGuess(guess,remainingGuesses,incorrectGuesses);
            }
        }

        if(isWordSolved(progress)) {
            System.out.println("Congratulations! You guessed the word: "  + word);
        }  else {
            System.out.println("Game over! The word was: " + word);
        }
    }

    private String produceRandomWord() {
        return WordBank.getRandomWord();
    }

    private char readGuess(Scanner input) {
        System.out.print("Enter a letter: ");
        String guessInput = input.next().toLowerCase();
        return guessInput.charAt(0);
    }

    private int handleWrongGuess(char guess, int remainingGuesses, Set<Character> incorrectGuesses){
        incorrectGuesses.add(guess);
        remainingGuesses--;
        System.out.println(guess + " is not in this word!");
        System.out.println("Wrong guess. You have " + remainingGuesses + " guesses left.");
        System.out.println("Incorrect guesses: " + incorrectGuesses);
        return remainingGuesses;
    }

    private boolean isAlreadyRevealed(char[] progress, char guess){
        for (int i = 0; i < progress.length; i++) {
            if (progress[i] == guess) {
                return true;
            }
        }
        return false;
    }


    private boolean revealMatchingLetters(String word, char[] progress, char guess) {

        boolean found = false;

        for (int i = 0; i < word.length(); i++) {

            char letter = word.charAt(i);

            if (letter == guess) {
                progress[i] = guess;
                found = true;
            }
        }

        return found;
    }

    private boolean isWordSolved(char[] progress) {
        for (int i = 0; i < progress.length; i++) {
            if (progress[i] == '_') {
                return false;
            }
        }
        return true;
    }

    private void printProgress(char[] progress) {
        for (int i = 0; i < progress.length; i++) {
            System.out.print(progress[i] + " ");
        }
        System.out.println();
    }

}




