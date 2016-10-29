package is.ru.tictactoe;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.Before;
import org.junit.rules.ExpectedException;
import org.junit.Rule;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class BoardTest {
	private Board board;
  private HumanPlayer player1;
  private HumanPlayer player2;

	@Before
	public void setUp() {
    player1 = new HumanPlayer('X', board);
    player2 = new HumanPlayer('O', board);
		board = new Board(player1, player2);
    player1.setLastRowMove(1);
    player1.setLastColMove(1);
	}

	@Test
	public void testRegisterMove() {
    board.registerMove(player1);
    board.setBoardColRow(1, 1, player1.playerName);
		assertEquals('X', board.getBoardColRow(1, 1));
	}
}
