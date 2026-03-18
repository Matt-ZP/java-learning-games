package com.mattzp.games.ui.celebration;

public class TrophyArt {

    public static void main(String[] args) {

        trophyIcon(26);
    }


    private static void trophyIcon(int height) {

        int width = height;

        // Head coordinates
        int trophyHeadHeightStart = (height * 2 / 10) + 1;
        int trophyHeadHeightEnd = (height * 4 / 10);
        int headHeight = (trophyHeadHeightEnd - trophyHeadHeightStart) + 1;

        int trophyHeadWidthStart = (width * 2 / 10) + 1;
        int trophyHeadWidthEnd = (width - trophyHeadWidthStart) + 1;
        int headWidth = (trophyHeadWidthEnd - trophyHeadWidthStart) + 1;

        // Neck coordinates
        int trophyNeckHeightStart = (trophyHeadHeightEnd) + 1;
        int trophyNeckHeightEnd = trophyNeckHeightStart + (headHeight / 2);
        int neckHeight = (trophyNeckHeightEnd - trophyNeckHeightStart) + 1;

        int neckWidth = headWidth * 6 / 10;
        int trophyNeckWidthStart = trophyHeadWidthStart + ((headWidth - neckWidth) / 2);
        int trophyNeckWidthEnd = trophyHeadWidthEnd - ((headWidth - neckWidth) / 2);

        // Column Head coordinates
        int columnHeadHeightStart = trophyNeckHeightEnd + 1;
        int columnHeadHeightEnd = columnHeadHeightStart + (neckHeight / 2);

        int columnHeadWidth = neckWidth * 6 / 10;
        int columnHeadWidthStart = trophyNeckWidthStart + ((neckWidth - columnHeadWidth) / 2);
        int columnHeadWidthEnd = trophyNeckWidthEnd - ((neckWidth - columnHeadWidth) / 2);

        // Column Cylinder coordinates
        int columnCyclinderHeightStart = columnHeadHeightEnd  + 1;
        int columnCyclinderHeightEnd = columnHeadHeightStart + (neckHeight / 2);

        int columnCylinderWidth = columnHeadWidth * 5 / 10;
        int columnCylinderWidthStart = trophyNeckWidthStart + ((neckWidth - columnHeadWidth) / 2);
        int columnCylinderWidthEnd = trophyNeckWidthEnd - ((neckWidth - columnHeadWidth) / 2);

        System.out.println("Head rows: " + trophyHeadHeightStart + " to " + trophyHeadHeightEnd);
        System.out.println("Head cols: " + trophyHeadWidthStart + " to " + trophyHeadWidthEnd);
        System.out.println("Head height: " + headHeight);
        System.out.println("Head width: " + headWidth);
        System.out.println();
        System.out.println("Neck width: " + neckWidth);
        System.out.println("Neck rows: " + trophyNeckHeightStart + " to " + trophyNeckHeightEnd);
        System.out.println("Neck cols: " + trophyNeckWidthStart + " to " + trophyNeckWidthEnd);
        System.out.println();
        System.out.println();

        for (int i = 1; i <= height; i++) {
            for (int j = 1; j <= width; j++) {

                // Print Border
                if ((i == 1 || j == 1) || (i == height || j == width)) {
                    System.out.print(" * ");

                    //  Print Trophy
                } else if (
                    // Trophy Head
                        (i >= trophyHeadHeightStart && i <= trophyHeadHeightEnd &&
                                j >= trophyHeadWidthStart && j <= trophyHeadWidthEnd) ||
                                // Print Trophy Neck
                                (i >= trophyNeckHeightStart && i <= trophyNeckHeightEnd &&
                                        j >= trophyNeckWidthStart && j <= trophyNeckWidthEnd) ||
                                // Print Column Head
                                (i >= columnHeadHeightStart && i <= columnHeadHeightEnd &&
                                        j >= columnHeadWidthStart && j <= columnHeadWidthEnd)
                ) {
                    System.out.print(" O ");

                } else {
                    System.out.print("   ");
                }

            }

            System.out.println();
        }
    }
}



