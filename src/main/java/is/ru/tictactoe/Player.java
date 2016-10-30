package is.ru.tictactoe;

public abstract class Player {
  protected char playerName;
  protected Board board;
  protected int lastRowMove;
  protected int lastColMove;
  protected int numOfMoves = 0;

  public Player(char playerName, Board board) {
  	this.playerName = playerName;
  	this.board = board;
  }

  protected void setBoard(Board board) {
  	this.board = board;
  }

  public void setLastRowMove(int lastRowMove) {
    this.lastRowMove = lastRowMove;
  }
  public void setLastColMove(int lastColMove) {
    this.lastColMove = lastColMove;
  }

  public int getLastRowMove() {
    return this.lastRowMove;
  }

  public int getLastColMove() {
    return this.lastRowMove;
  }

  public int getNumOfMoves() {
    return this.numOfMoves;
  }
}
