import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ticTacToe {
    private char[][] board;
    private char currentPlayer;

    public TicTacToeModel() {
        board = new char[3][3];
        currentPlayer = 'X';
        resetGame();
    }

    public void resetGame() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = ' ';
            }
        }
    }

    public boolean makeMove(int row, int col) {
        if (row < 0 || row >= 3 || col < 0 || col >= 3 || board[row][col] != ' ')
            return false;

        board[row][col] = currentPlayer;
        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
        return true;
    }

    public boolean checkWin() {
        // Check rows
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == board[i][1] && board[i][1] == board[i][2] && board[i][0] != ' ')
                return true;
        }

        // Check columns
        for (int i = 0; i < 3; i++) {
            if (board[0][i] == board[1][i] && board[1][i] == board[2][i] && board[0][i] != ' ')
                return true;
        }

        // Check diagonals
        if ((board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[0][0] != ' ') ||
                (board[0][2] == board[1][1] && board[1][1] == board[2][0] && board[0][2] != ' '))
            return true;

        return false;
    }

    public boolean checkTie() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ')
                    return false;
            }
        }
        return true;
    }

    public char getCurrentPlayer() {
        return currentPlayer;
    }

    public char[][] getBoard() {
        return board;
    }
}

public class TicTacToeView {
    private TicTacToeModel model;
    private JFrame frame;
    private JButton[][] buttons;
    private JLabel messageLabel;

    public TicTacToeView(TicTacToeModel model) {
        this.model = model;
        initialize();
    }

    private void initialize() {
        frame = new JFrame("Tic Tac Toe");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 300);
        frame.setLayout(new BorderLayout());

        JPanel boardPanel = new JPanel();
        boardPanel.setLayout(new GridLayout(3, 3));
        buttons = new JButton[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j] = new JButton();
                buttons[i][j].setFont(new Font(Font.SANS_SERIF, Font.BOLD, 40));
                final int row = i;
                final int col = j;
                buttons[i][j].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        buttonClicked(row, col);
                    }
                });
                boardPanel.add(buttons[i][j]);
            }
        }

        messageLabel = new JLabel("", JLabel.CENTER);
        frame.add(boardPanel, BorderLayout.CENTER);
        frame.add(messageLabel, BorderLayout.SOUTH);

        frame.setVisible(true);
    }

    private void buttonClicked(int row, int col) {
        if (model.makeMove(row, col)) {
            updateBoard();
            if (model.checkWin()) {
                showMessage("Player " + model.getCurrentPlayer() + " wins!");
                disableButtons();
            } else if (model.checkTie()) {
                showMessage("It's a tie!");
                disableButtons();
            }
        }
    }

    private void updateBoard() {
        char[][] board = model.getBoard();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j].setText(Character.toString(board[i][j]));
            }
        }
    }

    private void showMessage(String message) {
        messageLabel.setText(message);
    }

    private void disableButtons() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j].setEnabled(false);
            }
        }
    }
}

public class TicTacToeController {
    private TicTacToeModel model;
    private TicTacToeView view;

    public TicTacToeController(TicTacToeModel model, TicTacToeView view) {
        this.model = model;
        this.view = view;
        initController();
    }

    private void initController() {
        view.showMessage("Player " + model.getCurrentPlayer() + "'s turn");
    }

    public static void main(String[] args) {
        TicTacToeModel model = new TicTacToeModel();
        TicTacToeView view = new TicTacToeView(model);
        new TicTacToeController(model, view);
    }
}
