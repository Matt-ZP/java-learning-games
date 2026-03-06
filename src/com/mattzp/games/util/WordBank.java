package com.mattzp.games.util;

import java.util.List;
import java.util.Random;

public class WordBank {

    private static final List<String> WORDS = List.of(
            "apple",
            "banana",
            "guitar",
            "computer",
            "elephant",
            "mountain",
            "ocean",
            "library",
            "pencil",
            "notebook",
            "window",
            "camera",
            "airport",
            "garden",
            "teacher",
            "student",
            "football",
            "chocolate",
            "diamond",
            "pyramid",
            "island",
            "forest",
            "planet",
            "rocket",
            "engineer",
            "program",
            "hangman",
            "keyboard",
            "monitor",
            "internet"
    );

    public static String getRandomWord() {
        Random random = new Random();
        return WORDS.get(random.nextInt(WORDS.size()));
    }
}
