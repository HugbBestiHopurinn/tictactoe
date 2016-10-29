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
        System.out.println("WE HAVE A WINNER: " + winner);
    }
}
