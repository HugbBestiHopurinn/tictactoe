package is.ru.tictactoe;

public class Player {
    public int [] board = {0,0,0,0,0,0,0,0,0};
    private int binarySumOfPlayersBoard = 0;
    public boolean hasWon = false;
    public void makeMove(String moveIndex) {
        int move = Integer.parseInt(moveIndex);
        this.board[move] = 1;
    }
}
