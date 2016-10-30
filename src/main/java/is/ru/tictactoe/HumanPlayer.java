package is.ru.tictactoe;

import java.util.Scanner;

public class HumanPlayer extends Player {
	public HumanPlayer	(char player, Board board) {
		super(player, board);
	}

	public void makeMove() {
		Scanner reader = new Scanner(System.in);
		System.out.println("Please enter a column (1-3) and a row (1-3) with spaces inbetween: ");
		int col = reader.nextInt();
		int row = reader.nextInt();

		while(!board.checkMove(col - 1, row - 1)) {
				System.out.println("This move is not valid, please try again!\n");
				col = reader.nextInt();
				row = reader.nextInt();
		}

		this.lastColMove = col - 1;
		this.lastRowMove = row - 1;
		this.numOfMoves++;
		board.registerMove(this);
	}
}
