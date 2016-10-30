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

    

}
