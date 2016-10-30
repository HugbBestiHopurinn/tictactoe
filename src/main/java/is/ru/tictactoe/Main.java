package is.ru.tictactoe;

public class Main {

    public String make_move(String player, String cell) {
        return "Server has received move information.";
    }

    /* codecov skip start */
    public static void main(String[] args) {
      TicTacToe ticTacToe = new TicTacToe();
      do {
          ticTacToe.setupGame();
      } while(ticTacToe.continueGame());
    }
    /* codecov skip start */

}
