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

  public boolean checkMove(int col, int row) {
      return !Character.isAlphabetic(board[col][row]);
  }

  public void registerMove(Player player) {
    numOfMoves++;
    int col = player.lastColMove;
    int row = player.lastRowMove;
    board[col][row] = player.playerName;
    //printBoardStatus();
  }

  public void setBoard(int col, int row, char value) {
    this.board[col][row] = value;
  }

  private void winnerChar(char winner) {this.winner = winner; }

  public boolean crossCheck() {
    if(board[0][0] == board[1][1] && board[1][1] == board[2][2]){
        winnerChar(board[0][0]);
       return true;
   } else if(board[0][2] == board[1][1] && board[1][1] == board[2][0]) {
        winnerChar(board[0][2]);
       return true;
   } else {
        return false;
   }
}

public boolean verticalCheck() {
   if(board[0][0] == board[1][0] && board[1][0] == board[2][0]) {
       winnerChar(board[0][0]);
       return true;
   } else if(board[0][1] == board[1][1] && board[1][1] == board[2][1]) {
       winnerChar(board[0][1]);
       return true;
   } else if(board[0][2] == board[1][2] && board[1][2] == board[2][2]) {
       winnerChar(board[0][2]);
       return true;
   } else {
       return false;
   }
}

public boolean horizontalCheck() {
   if(board[0][0] == board[0][1] && board[0][1] == board[0][2]){
       winnerChar(board[0][0]);
       return true;
   } else if(board[1][0] == board[1][1] && board[1][1] == board[1][2]) {
       winnerChar(board[1][0]);
       return true;
   } else if(board[2][0] == board[2][1] && board[2][1] == board[2][2]) {
       winnerChar(board[2][0]);
       return true;
   } else {
       return false;
   }
 }
 
/* codecov skip start */
 public void startGame() {
     player1.setBoard(this);
     player2.setBoard(this);

     while(true) {
         if(crossCheck() || horizontalCheck() || verticalCheck()) {
             ticTacToe.declareWinner(winner);
             break;
         }

         player1.makeMove();

         if(checkForDraw()) {
             ticTacToe.declareDraw();
             break;
         }

         if(crossCheck() || horizontalCheck() || verticalCheck()) {
             ticTacToe.declareWinner(winner);
             break;
         }

         player2.makeMove();
     }
   }
   /* codecov skip start */

}
