package is.ru.tictactoe;

public class TicTacToe {

    String gameType;
    Player playerOne;
    Player playerTwo;

    // Inputs: array, playerOne.board or playerTwo.board
    // Outputs: integer number which in binary looks like the player's array
    // Summary:
    // This takes each player's board (ignoring the other players placings)
    // of the form [1, 0, 0, 0, 0, 0, 0, 0, 0], where 1 represents that the player
    // has made a mark. We transform this into a sum, which is stored as the binary number 100000000 for the exampe above.
    // This will then use & to figure out of this is one of the victory conditions.
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
	
    // Inputs: integer, the results from the binarySum operation on the playerOne.board or playerTwo.board
    // Outputs: boolean, whether or not the player's board contains a victory configuration.
    // Summary:
    // We check the binary sum and see if therein lies a victory combo, by using & operations.
    boolean check_for_victory(int sum) {
        int victory_combo [] = {0x1C0, 0x38, 0x92, 0x54, 0x7, 0x124, 0x49, 0x111};
        boolean win_status = false;
        for (int i = 0; i < 8; i++) {
            win_status = ((((victory_combo[i] & sum)
                            == victory_combo[i]) != false) || (win_status != false));
        }
        return win_status;
    }
}
