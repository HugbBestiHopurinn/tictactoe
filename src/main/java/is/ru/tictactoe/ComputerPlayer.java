package is.ru.tictactoe;

import java.util.Random;

public class ComputerPlayer extends Player {
	public ComputerPlayer	(char player, Board board) {
		super(player, board);
	}

	public void makeMove() {
		Random rand = new Random();
		int col = rand.nextInt(3);
		int row = rand.nextInt(3);

		while(!board.checkMove(col, row)) {
				col = rand.nextInt(3);
				row = rand.nextInt(3);
		}

		this.lastColMove = col;
		this.lastRowMove = row;
		this.numOfMoves++;
		board.registerMove(this);
	}
}
