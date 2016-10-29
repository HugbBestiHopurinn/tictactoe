package is.ru.tictactoe;

public abstract class Player {
  protected char playerName;
  protected Board board;
  protected int lastRowMove;
  protected int lastColMove;
  protected int numOfMoves = 0;

  public Player ( char playerName, Borad board){
  	this.playerName = playerName;
  	this.board = board;
  }
}
