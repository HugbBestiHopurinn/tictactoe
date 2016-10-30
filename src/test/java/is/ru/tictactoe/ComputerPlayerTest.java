package is.ru.tictactoe;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;
import org.junit.rules.ExpectedException;
import org.junit.Rule;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class ComputerPlayerTest {
	private Board board;
  private HumanPlayer player1;
  private ComputerPlayer player2;

	@Before
	public void setUp() {
    player1 = new HumanPlayer('X', board);
    player2 = new ComputerPlayer('O', board);
		board = new Board(player1, player2);
  }

	@Test
	public void testMakeMove() {
    assertEquals(0, player2.getNumOfMoves());
    player2.setBoard(board);
    player2.makeMove();
    assertNotEquals(0, player2.getNumOfMoves());
	}
}
