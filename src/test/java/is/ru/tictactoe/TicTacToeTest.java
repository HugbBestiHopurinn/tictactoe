package is.ru.tictactoe;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.Before;
import org.junit.rules.ExpectedException;
import org.junit.Rule;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class TicTacToeTest {
	private TicTacToe ticTacToe;

	@Before
	public void setUp() {
		ticTacToe = new TicTacToe();
	}

	@Test
	public void testSomething() {
		assertEquals("this is something", TicTacToe.something());
	}

	@Test
	public void testDeclareWinner() {
		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
		ticTacToe.declareWinner('X');
		assertEquals(outContent.toString(), "WE HAVE A WINNER: X");
	}

	@Test
	public void testDeclareDraw() {
		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
		ticTacToe.declareDraw();
		assertEquals(outContent.toString(), "WE HAVE A DRAW!");
	}
}
