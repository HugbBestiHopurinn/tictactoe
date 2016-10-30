package is.ru.tictactoe;

import java.util.Scanner;

public class TicTacToe {
  private Board board;
  private Scanner scanner = new Scanner(System.in);

    public String make_move(String player, String cell) {
        return "Server has received move information.";
	}

    public static String something() {
        return "this is something";
    }

    //public static void main(String[] args) {
    //    System.out.println("Hello World");
    //}

    public void declareWinner (char winner) {
        System.out.print("WE HAVE A WINNER: " + winner);
    }

    public void declareDraw() {
        System.out.print("WE HAVE A DRAW!");
    }
    /* codecov skip start */
    public boolean continueGame() {
      System.out.println("Do you wish to play again? Y/N\n");
      String ans = scanner.next();

      return ans.equals("Y") || ans.equals("y");
    }

    public void setupGame() {
      System.out.println("WELCOME TO TIC TAC TOE\n");
      System.out.println("Press 1 to play Player Vs. Player\n");
      System.out.println("Press 2 to play Player Vs. Computer\n");
      int ans = scanner.nextInt();

      if(ans == 1) {
          board = new Board(new HumanPlayer('X', board), new HumanPlayer('O', board));
          board.setTicTacToe(this);
          board.startGame();
      } else if(ans == 2) {
          board = new Board(new HumanPlayer('X', board), new ComputerPlayer('O', board));
          board.setTicTacToe(this);
          board.startGame();
      } else {
          //TODO: ERROR
      }

      board.setTicTacToe(this);
    }
    /* codecov skip start */
}
