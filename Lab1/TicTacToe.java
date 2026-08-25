import java.util.InputMismatchException;
import java.util.Scanner;

public class TicTacToe {
    public char[][] board;
    public boolean itsX;
    public Scanner sc;

    public TicTacToe() {
        itsX = true;
        sc = new Scanner(System.in);
        board = new char[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++)
                board[i][j] = ' ';
        }
    }

    public void displayRow(int row) {
        System.out.println(" " + board[row][0] + " | " + board[row][1] + " | " + board[row][2]);
    }

    public void gameBoard() {
        displayRow(0);
        System.out.println(" ---------");
        displayRow(1);
        System.out.println(" ---------");
        displayRow(2);
        System.out.println("Enter the row and column (0-2) separated by a space:");
    }

    public boolean getMove() {
        boolean wrong = true;
        int row = 0, column = 0;
        while (wrong) {
            try {
                row = sc.nextInt();
                column = sc.nextInt();
                if (row >= 0 && row <= 2 && column >= 0 && column <= 2) {
                    if (board[row][column] != ' ') {
                        System.out.println("A move has already been made there!");
                    } else {
                        wrong = false;
                    }
                } else {
                    System.out.println("Invalid input. Enter numbers between 0 and 2.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter integers.");
                sc.next(); // consume the invalid input
            }
        }

        if (itsX)
            board[row][column] = 'X';
        else
            board[row][column] = 'O';

        return winner(row, column);
    }

    public boolean winner(int lastR, int lastC) {
        char symbol = board[lastR][lastC];

        // Check row
        if (board[lastR][0] == symbol && board[lastR][1] == symbol && board[lastR][2] == symbol)
            return true;

        // Check column
        if (board[0][lastC] == symbol && board[1][lastC] == symbol && board[2][lastC] == symbol)
            return true;

        // Check diagonals
        if (lastR == lastC && board[0][0] == symbol && board[1][1] == symbol && board[2][2] == symbol)
            return true;
        if (lastR + lastC == 2 && board[0][2] == symbol && board[1][1] == symbol && board[2][0] == symbol)
            return true;

        return false;
    }

    public boolean boardFull() {
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                if (board[r][c] == ' ')
                    return false;
            }
        }
        return true;
    }

    public void Tic() {
        while (true) {
            gameBoard();
            if (itsX)
                System.out.println("It's X's Turn!");
            else
                System.out.println("It's O's Turn!");

            if (getMove()) {
                gameBoard();
                if (itsX)
                    System.out.println("X Wins!");
                else
                    System.out.println("O Wins!");
                break;
            } else if (boardFull()) {
                gameBoard();
                System.out.println("Tie!");
                break;
            } else {
                itsX = !itsX;
            }
        }
        sc.close();
    }

    public static void main(String[] args) {
        TicTacToe game = new TicTacToe();
        game.Tic();
    }
}
