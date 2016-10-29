package is.ru.tictactoe;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.Rule;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class TicTacToeTest {
	@Test
	public void testSomething() {
		assertEquals("this is something", TicTacToe.something());
	}

	@Test
	public void testDeclareWinner() {
		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
		TicTacToe ticTacToe = new TicTacToe();
		ticTacToe.declareWinner();
		assertEquals(outContent.ToString(), "WE HAVE A WINNER: X");
	}
}
