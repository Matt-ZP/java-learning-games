package com.mattzp.games.ui.celebration;

public class TrophyArt {

    public static void main(String[] args) {
        trophyIcon();
    }

    public static void trophyIcon() {
        for (int i = 0; i < 14; i++) {
            System.out.println(buildRow(i));
        }
    }

    public static String buildRow(int i) {
        String row = "";

        for (int j = 0; j < 14; j++) {
            row += getCell(i, j);
        }

        return row;
    }

    public static String getCell(int i, int j) {
        if (isBorder(i, j)) {
            return " * ";
        } else if (isTrophy(i, j)) {
            return " 0 ";
        } else {
            return "   ";
        }
    }

    public static boolean isBorder(int i, int j) {
        return i == 0 || j == 0 || i == 13 || j == 13;
    }

    public static boolean isTrophy(int i, int j) {
        return
                (i == 2 && j >= 2 && j <= 11) ||
                        (i == 3 && j >= 2 && j <= 11) ||
                        (i == 4 && j >= 3 && j <= 10) ||
                        (i == 5 && j >= 4 && j <= 9) ||
                        (i >= 6 && i <= 9 && j >= 6 && j <= 7) ||
                        (i == 10 && j >= 5 && j <= 8) ||
                        (i == 11 && j >= 3 && j <= 10);
    }
}

