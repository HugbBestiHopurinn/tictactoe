package is.ru.tictactoe;

import static org.junit.Assert.*;
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
	}

	@Test
	public void testRegisterMove() {
    player1.setLastRowMove(1);
    player1.setLastColMove(1);
    board.registerMove(player1);
    board.setBoardColRow(1, 1, player1.playerName);
		assertEquals('X', board.getBoardColRow(1, 1));
	}

  @Test
  public void testCheckMove() {
    player1.setLastRowMove(1);
    player1.setLastColMove(0);
    board.registerMove(player1);
    assertFalse(board.checkMove(0, 1));
  }

	@Test
	public void testVerticalCheck1() {
		board.setBoard(0, 0, 'x');
		board.setBoard(1, 0, 'x');
		board.setBoard(2, 0, 'x');
		assertTrue(board.verticalCheck());
		assertFalse(board.horizontalCheck());
		assertFalse(board.crossCheck());
	}

	@Test
	public void testVerticalCheck2() {
		board.setBoard(0, 1, 'x');
		board.setBoard(1, 1, 'x');
		board.setBoard(2, 1, 'x');
		assertTrue(board.verticalCheck());
		assertFalse(board.horizontalCheck());
		assertFalse(board.crossCheck());
	}

	@Test
	public void testVerticalCheck3() {
		board.setBoard(0, 2, 'x');
		board.setBoard(1, 2, 'x');
		board.setBoard(2, 2, 'x');
		assertTrue(board.verticalCheck());
		assertFalse(board.horizontalCheck());
		assertFalse(board.crossCheck());
	}

	@Test
	public void testHorizontallCheck1() {
		board.setBoard(1, 1, 'x');
		board.setBoard(1, 0, 'x');
		board.setBoard(1, 2, 'x');
		assertFalse(board.verticalCheck());
		assertTrue(board.horizontalCheck());
		assertFalse(board.crossCheck());
	}

	@Test
	public void testHorizontallCheck2() {
		board.setBoard(1, 0, 'x');
		board.setBoard(1, 1, 'x');
		board.setBoard(1, 2, 'x');
		assertFalse(board.verticalCheck());
		assertTrue(board.horizontalCheck());
		assertFalse(board.crossCheck());
	}

	@Test
	public void testHorizontallCheck3() {
		board.setBoard(2, 0, 'x');
		board.setBoard(2, 1, 'x');
		board.setBoard(2, 2, 'x');
		assertFalse(board.verticalCheck());
		assertTrue(board.horizontalCheck());
		assertFalse(board.crossCheck());
	}

	@Test
	public void testCrossCheck1() {
		board.setBoard(0, 0, 'x');
		board.setBoard(1, 1, 'x');
		board.setBoard(2, 2, 'x');
		assertFalse(board.verticalCheck());
		assertFalse(board.horizontalCheck());
		assertTrue(board.crossCheck());
	}

	@Test
	public void testCrossCheck2() {
		board.setBoard(0, 2, 'x');
		board.setBoard(1, 1, 'x');
		board.setBoard(2, 0, 'x');
		assertFalse(board.verticalCheck());
		assertFalse(board.horizontalCheck());
		assertTrue(board.crossCheck());
	}
}
