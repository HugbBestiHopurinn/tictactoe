package is.ru.tictactoe;

import org.json.JSONArray;
import org.json.JSONObject;

public class TicTacToe {

    String gameType;
    Player playerOne;
    Player playerTwo;

    // Inputs: array, playerOne.board or playerTwo.board
    // Outputs: integer number which in binary looks like the player's array
    // Summary:
    // This takes each player's board (ignoring the other players placings)
    // of the form [1, 0, 0, 0, 0, 0, 0, 0, 0], where 1 represents that the player
    // has made a mark. We transform this into a sum, which is stored as the binary number 000000001 for the exampe above (it is the reverse representation as binary).
    // This will then use & to figure out of this is one of the victory conditions.
    public int binarySum(int board []) {
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

    // Inputs: integer, the results from the binarySum operation on the playerOne.board or playerTwo.board
    // Outputs: boolean, whether or not the player's board contains a victory configuration.
    // Summary:
    // We check the binary sum and see if therein lies a victory combo, by using & operations.
    boolean checkForVictory(int sum) {
        int victory_combo [] = {0x1C0, 0x38, 0x92, 0x54, 0x7, 0x124, 0x49, 0x111};
        boolean win_status = false;
        for (int i = 0; i < 8; i++) {
            win_status = ((((victory_combo[i] & sum)
                            == victory_combo[i]) != false) || (win_status != false));
        }
        return win_status;
    }

    // Called by TicTacToeWeb once at start of game
    // and is client's interface with server here.
    public String init(String gameType) {
        if (gameType.equals("single")) {
            playerOne = new Player();
            playerTwo = new Player();
        } else {
            playerOne = new Player();
            playerTwo = new Player();
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
            boolean winningStatus = checkForVictory(binarySumOfPlayersBoard);

            json.put("CurrentPlayer", "PlayerOne");
            json.put("PlayerBoard", playerBoard.toString());
            json.put("HasWon", String.valueOf(winningStatus));
            return json; // This will be our response to the client
        } else {
            playerTwo.makeMove(cell);
            JSONArray playerBoard = new JSONArray(playerTwo.board);
            JSONObject json = new JSONObject();

            int binarySumOfPlayersBoard = binarySum(playerTwo.board);
            boolean winningStatus = checkForVictory(binarySumOfPlayersBoard);

            json.put(playerBoard.toString(), String.valueOf(winningStatus));
            json.put("CurrentPlayer", "PlayerTwo");
            json.put("PlayerBoard", playerBoard.toString());
            json.put("HasWon", String.valueOf(winningStatus));
            return json; // This is our response to the client

        }
    }

}
