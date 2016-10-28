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
}
