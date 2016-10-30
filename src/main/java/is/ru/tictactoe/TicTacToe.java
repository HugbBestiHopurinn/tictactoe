package is.ru.tictactoe;

import org.json.JSONArray;
import org.json.JSONObject;

public class TicTacToe {

    String gameType;
    Player playerOne;
    Player playerTwo;

    int binarySum(int board []) {
        int sum = 0;
        for (int i = 0; i < 9; i++) {
            int shift = (i - 1 != -1) ? (i - 1) : 0;
            sum += (2 << shift) * board[i];
        }
        if (board[0] == 1) {
            sum--;
        }
        return sum;
    }

    boolean check_for_victory(int sum) {

        int victory_combo [] = {0x1C0, 0x38, 0x92, 0x54, 0x7, 0x124, 0x49};
        boolean win_status = false;
        for (int i = 0; i < 5; i++) {
            win_status = ((((victory_combo[i] & sum)
                            == victory_combo[i]) != false) || (win_status != false));
        }
        return win_status;
    }

    private class Player {
        public int [] board = {0,0,0,0,0,0,0,0,0};
        private int binarySumOfPlayersBoard = 0;
        public boolean hasWon = false;
        public void makeMove(String moveIndex) {
            int move = Integer.parseInt(moveIndex);
            this.board[move] = 1;
            binarySumOfPlayersBoard = binarySum(this.board);
            hasWon = check_for_victory(binarySumOfPlayersBoard);
        }
    }

    private class HumanPlayer extends Player {}

    private class ComputerPlayer extends Player {}

    // Called by TicTacToeWeb once at start of game
    // and is client's interface with server here.
    public String init(String gameType) {
        if (gameType.equals("single")) {
            playerOne = new HumanPlayer();
            playerTwo = new ComputerPlayer();
        } else {
            playerOne = new HumanPlayer();
            playerTwo = new HumanPlayer();
        }
        return "Game Started";
    }

    // Called by TicTacToeWeb and is client's interface
    // with our server here.
    public JSONObject moveMade(String player, String cell) {
        if (player.equals("X")) {
            playerOne.makeMove(cell);
            JSONArray playerBoard = new JSONArray(playerOne.board);
            JSONObject json = new JSONObject();

            int binarySumOfPlayersBoard = binarySum(playerOne.board);

            boolean winningStatus = check_for_victory(binarySumOfPlayersBoard);
            json.put(playerBoard.toString(), String.valueOf(winningStatus));
            return json;
        } else {
            playerTwo.makeMove(cell);
            JSONArray playerBoard = new JSONArray(playerTwo.board);
            JSONObject json = new JSONObject();

            int binarySumOfPlayersBoard = binarySum(playerOne.board);

            boolean winningStatus = playerOne.hasWon;
            json.put(playerBoard.toString(), String.valueOf(winningStatus));
            return json;
        }
    }

}
