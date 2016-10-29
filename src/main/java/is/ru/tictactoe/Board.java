package is.ru.tictactoe;

public class Board {
  private static int ROWS = 3;
  private static int COLS = 3;
  private int numOfMoves = 0;
  private TicTacToe ticTacToe;
  private char[][] board = {{'1', '2', '3'},{'4', '5', '6'},{'7', '8', '9'}};
  private Player player1;
  private Player player2;
  private char winner;

  public Board (HumanPlayer player1, HumanPlayer player2){
  	this.player1 = player1;
  	this.player2 = player2;
  }

   public Board (HumanPlayer player1, ComputerPlayer player2){
  	this.player1 = player1;
  	this.player2 = player2;
  }

  public void setBoardColRow(int col, int row, char player) {
    this.board[col][row] = player;
  }

  public char getBoardColRow(int col, int row) {
    return this.board[col][row];
  }

  public void registerMove(Player player) {
    numOfMoves++;
    int col = player.lastColMove;
    int row = player.lastRowMove;
    board[col][row] = player.playerName;
    //printBoardStatus();
  }
}
