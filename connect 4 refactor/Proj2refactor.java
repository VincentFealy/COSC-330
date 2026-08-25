
/**
 * This refactored code includes improvements such as better code organization, improved input handling,
 * and enhanced readability through method extraction and modularization.
 * Original author: [Original author's name]
 * Refactored by: [Your name]
 *
 * - Extracted the playerTurn method to improve code readability and modularity.
 */
import java.io.Console;

public class Proj2refactor {

    // Method to print two blank lines
    public static void skip2() {
        System.out.println("");
        System.out.println("");
    }

    // Method to print the game board
    public static void board(char space[][]) {
        System.out.println(" " + space[0][5] + " | " + space[1][5] + " | " + space[2][5] + " | " + space[3][5] + " | "
                + space[4][5] + " | " + space[5][5] + " | " + space[6][5]);
        System.out.println(" " + space[0][4] + " | " + space[1][4] + " | " + space[2][4] + " | " + space[3][4] + " | "
                + space[4][4] + " | " + space[5][4] + " | " + space[6][4]);
        System.out.println(" " + space[0][3] + " | " + space[1][3] + " | " + space[2][3] + " | " + space[3][3] + " | "
                + space[4][3] + " | " + space[5][3] + " | " + space[6][3]);
        System.out.println(" " + space[0][2] + " | " + space[1][2] + " | " + space[2][2] + " | " + space[3][2] + " | "
                + space[4][2] + " | " + space[5][2] + " | " + space[6][2]);
        System.out.println(" " + space[0][1] + " | " + space[1][1] + " | " + space[2][1] + " | " + space[3][1] + " | "
                + space[4][1] + " | " + space[5][1] + " | " + space[6][1]);
        System.out.println(" " + space[0][0] + " | " + space[1][0] + " | " + space[2][0] + " | " + space[3][0] + " | "
                + space[4][0] + " | " + space[5][0] + " | " + space[6][0]);
        System.out.println("---------------------------");
        System.out.println(" 1 | 2 | 3 | 4 | 5 | 6 | 7");
    }

    // Method to check for a winner at a specific position
    public static boolean checkWinnerAt(char[][] b, int i, int j, char c) {
        if ((i + 3) < b.length && (j + 3) < b[i].length) {
            if ((b[i][j] == c) && (b[i + 1][j + 1] == c && b[i + 2][j + 2] == c && b[i + 3][j + 3] == c)) {
                return true;
            }
        }
        if ((i + 3) < b.length && (j + 3) < b[i].length) {
            if ((b[i][j] == c) && (b[i][j + 1] == c && b[i][j + 2] == c && b[i][j + 3] == c)) {
                return true;
            }
        }
        if ((i + 3) < b.length && (j + 3) < b[i].length) {
            if ((b[i][j] == c) && (b[i + 1][j] == c && b[i + 2][j] == c && b[i + 3][j] == c)) {
                return true;
            }
        }
        if ((i + 3) < b.length && (j - 3) >= 0) {
            if (b[i][j - 1] == c && b[i + 1][j - 2] == c && b[i + 2][j - 3] == c && b[i + 3][j - 4] == c) {
                return true;
            }
        }
        return false;
    }

    // Method to check for a winner on the entire board
    public static boolean checkWinner(char[][] b) {
        boolean r1, r2;
        for (int r = 0; r < b.length; r++) {
            for (int c = 0; c < b[0].length; c++) {
                r1 = checkWinnerAt(b, r, c, 'R');
                r2 = checkWinnerAt(b, r, c, 'Y');
                if (r1 || r2) {
                    return true;
                }
            }
        }
        return false;
    }

    // Method to get input to play again
    public static int again(Console console) {
        System.out.println("If you would like to play again, enter 1, if not, enter any other number.");
        int win = Integer.parseInt(console.readLine());
        return win == 1 ? 1 : 0;
    }

    // Method to get user input for a column
    public static int getColumnInput(Console console, int[] yval) {
        int column;
        do {
            System.out.println("Choose the column that you want:");
            column = Integer.parseInt(console.readLine());
            if (column < 1 || column > 7 || yval[column - 1] > 5) {
                System.out.println("Error: column already full or invalid. Please try again.");
            }
        } while (column < 1 || column > 7 || yval[column - 1] > 5);
        return column;
    }

    // Method to update the game board
    public static void updateBoard(char[][] space, int column, int[] yval, char playerSymbol) {
        space[column - 1][yval[column - 1]] = playerSymbol;
        yval[column - 1]++;
    }

    // Method to handle a player's turn
    public static void playerTurn(Console console, char[][] space, int[] yval, char playerSymbol) {
        int column = getColumnInput(console, yval);
        updateBoard(space, column, yval, playerSymbol);
    }

    public static void main(String[] args) {
        Console console = System.console();
        if (console == null) {
            System.out.println("Console not available. Exiting...");
            System.exit(1);
        }

        int win = 1;
        int xvalue = 0, yvalue = 0, player1Win = 0, player2Win = 0, count = 0;
        int[] yval = new int[7];
        char[][] space = new char[7][6];
        System.out.println("Welcome to Connect 4");

        for (int x = 0; x < 42; x++) {
            space[xvalue][yvalue] = ' ';
            yvalue++;
            if (yvalue > 5) {
                yvalue = 0;
                xvalue++;
            }
        }
        for (int i = 0; i < 7; i++) {
            yval[i] = 0;
        }

        do {
            for (int z = 1; z > 0; z++) {
                skip2();
                board(space);
                if (count >= 42) {
                    System.out.println("Tie game!");
                    win = again(console);
                    count = 0;
                    break;
                }
                if (checkWinner(space)) {
                    System.out.println("Player 2 wins!");
                    win = again(console);
                    xvalue = 0;
                    yvalue = 0;
                    for (int x = 0; x < 42; x++) {
                        space[xvalue][yvalue] = ' ';
                        yvalue++;
                        if (yvalue > 5) {
                            yvalue = 0;
                            xvalue++;
                        }
                    }
                    for (int i = 0; i < 7; i++) {
                        yval[i] = 0;
                    }
                    player2Win++;
                    count = 0;
                    break;
                }
                playerTurn(console, space, yval, 'R');
                skip2();
                board(space);
                if (count >= 42) {
                    System.out.println("Tie game!");
                    win = again(console);
                    count = 0;
                    break;
                }
                if (checkWinner(space)) {
                    System.out.println("Player 1 wins!");
                    win = again(console);
                    xvalue = 0;
                    yvalue = 0;
                    for (int x = 0; x < 42; x++) {
                        space[xvalue][yvalue] = ' ';
                        yvalue++;
                        if (yvalue > 5) {
                            yvalue = 0;
                            xvalue++;
                        }
                    }
                    for (int i = 0; i < 6; i++) {
                        yval[i] = 0;
                    }
                    player1Win++;
                    count = 0;
                    break;
                }
                playerTurn(console, space, yval, 'Y');
            }
        } while (win == 1);

        System.out.println("Player 1 won " + player1Win + " times!");
        System.out.println("Player 2 won " + player2Win + " times!");
    }
}
