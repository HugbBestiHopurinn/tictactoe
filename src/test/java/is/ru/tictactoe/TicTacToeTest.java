package is.ru.tictactoe;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.Before;
import org.junit.rules.ExpectedException;
import org.junit.Rule;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class TicTacToeTest {
	@Before
	public void setUp() {
		ticTacToe = new TicTacToe();
	}
	
	@Test
	public void testBinarySumIs256() {
		int[] board = {0, 0, 0, 0, 0, 0, 0, 0, 1};
		assertEquals(256, ticTacToe.binarySum(board));
	}

	@Test
	public void testBinarySumIs1() {
		int[] board = {1, 0, 0, 0, 0, 0, 0, 0, 0};
		assertEquals(1, ticTacToe.binarySum(board));
	}
	
	@Test
	public void testCheckForVictory() {
		int[] board = {1, 1, 1, 0, 0, 0, 0, 0, 0};
		int sum = ticTacToe.binarySum(board);
		assertEquals(true, ticTacToe.checkForVictory(sum));
	}
}
