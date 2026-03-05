package com.mattzp.games.launcher;

import com.mattzp.games.Game;
import com.mattzp.games.impl.GuessingGame;
import com.mattzp.games.impl.Hangman;
import com.mattzp.games.impl.RockPaperScissors;
import com.mattzp.games.impl.TicTacToe;
import com.mattzp.games.util.ConsoleInput;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GameLauncher {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        List<Game> games = new ArrayList<>();
        games.add(new GuessingGame());
        games.add(new TicTacToe());
        games.add(new Hangman());
        games.add(new RockPaperScissors());

        System.out.println("\nWELCOME TO THE GAME LAUNCHER!\nWhich game would you like to play?");

        while (true) {

            System.out.println("\n0) Exit");
            for (int i = 0; i < games.size(); i++) {
                System.out.println((i + 1) + ") " + games.get(i).name());
            }

            int choice = ConsoleInput.readMenuChoice
                    (input, games.size(),"\nEnter choice (0 - " + games.size() + "): ");

            if (choice == 0) {
                break;
            }

            Game selectedGame = games.get(choice - 1);
            selectedGame.start(input);
            System.out.println("\nPress enter to return to Game Launcher.");
            input.nextLine();
            input.nextLine();

        }
        System.out.println("\nBYE BYE - Thanks for playing. See you again soon!");
        input.close();
    }
}