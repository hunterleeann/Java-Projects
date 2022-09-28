import java.util.Scanner;


public class Connect4Game {
    public static String[][] designBoard() {

        String[][] h = new String[7][15]; //Set up for 2D array.

        for (int i = 0; i < h.length; i++) {

            for (int j = 0; j < h[i].length; j++) {

                if (j % 2 == 0) {

                    h[i][j] = "|"; //determines where/ how frame is built.

                } else {

                    h[i][j] = " ";

                }

                if (i == 6)

                    h[i][j] = "-";

            }

        }

        return h;

    }

    public static void buildBoard(String[][] h) {

        for (int i = 0; i < h.length; i++) {

            for (int j = 0; j < h[i].length; j++) {

                System.out.print(h[i][j]);

            }

            System.out.println();

        }

    }

    public static void playRedToken(String[][] h) { //set up for

        System.out.print("Player one play a Red disk at column (0–6): ");

        Scanner redPlayerInput = new Scanner(System.in);

        int redChip = 2 * redPlayerInput.nextInt() + 1;

        for (int i = 5; i >= 0; i--) {

            if (h[i][redChip] == " ") {

                h[i][redChip] = "R";

                break;

            }

        }

    }

    public static void playYellowToken(String[][] f) {

        System.out.print("Player two play a Yellow disk at column (0–6): ");

        Scanner yellowPlayerInput = new Scanner(System.in);

        int yellowChip = 2 * yellowPlayerInput.nextInt() + 1;

        for (int i = 5; i >= 0; i--) {

            if (f[i][yellowChip] == " ") {

                f[i][yellowChip] = "Y";

                break;

            }

        }

    }

    public static String whoWon(String[][] h) {

        for (int i = 0; i < 6; i++) {

            for (int j = 0; j < 7; j += 2) {

                if ((h[i][j + 1] != " ") && (h[i][j + 3] != " ") && (h[i][j + 5] != " ") && (h[i][j + 7] != " ")

                        && ((h[i][j + 1] == h[i][j + 3]) && (h[i][j + 3] == h[i][j + 5])

                        && (h[i][j + 5] == h[i][j + 7])))

                    return h[i][j + 1];

            }

        }

        for (int i = 1; i < 15; i += 2) {

            for (int j = 0; j < 3; j++) {

                if ((h[j][i] != " ") && (h[j + 1][i] != " ") && (h[j + 2][i] != " ") && (h[j + 3][i] != " ")

                        && ((h[j][i] == h[j + 1][i]) && (h[j + 1][i] == h[j + 2][i]) && (h[j + 2][i] == h[j + 3][i])))

                    return h[j][i];

            }

        }

        for (int i = 0; i < 3; i++) {

            for (int j = 7; j < 15; j += 2) {

                if ((h[i][j] != " ") && (h[i + 1][j - 2] != " ") && (h[i + 2][j - 4] != " ") && (h[i + 3][j - 6] != " ")

                        && ((h[i][j] == h[i + 1][j - 2]) && (h[i + 1][j - 2] == h[i + 2][j - 4])

                        && (h[i + 2][j - 4] == h[i + 3][j - 6])))

                    return h[i][j];

            }

        }
        for (int i = 0; i < 3; i++) {

            for (int j = 1; j < 9; j += 2) {

                if ((h[i][j] != " ") && (h[i + 1][j + 2] != " ") && (h[i + 2][j + 4] != " ") && (h[i + 3][j + 6] != " ")

                        && ((h[i][j] == h[i + 1][j + 2]) && (h[i + 1][j + 2] == h[i + 2][j + 4])

                        && (h[i + 2][j + 4] == h[i + 3][j + 6])))

                    return h[i][j];

            }

        }
        return null;

    }

    public static void main(String[] args) {

        String[][] h = designBoard();

        boolean inPlay = true;

        int count = 0;

        buildBoard(h);

        while (inPlay) {

            if (count % 2 == 0)

                playRedToken(h);

            else

                playYellowToken(h);

            count++;

            buildBoard(h);

            if (whoWon(h) != null) {

                if (whoWon(h) == "R") {

                    System.out.println("Player one (Red) wins.");

                } else if (whoWon(h) == "Y") {

                    System.out.println("Player two (Yellow) wins.");

                }

                inPlay = false;

            }

        }

    }

}


