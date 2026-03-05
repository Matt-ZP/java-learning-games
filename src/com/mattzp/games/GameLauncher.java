package com.mattzp.games;

public class GameLauncher {

    public static void main(String[] args) {

        System.out.println("Welcome to Game Launcher");
        System.out.println();

        GuessingGame game = new GuessingGame();
        game.start();
    }

}