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

<<<<<<< HEAD
  @Before
  public void setUp() {
      ticTacToe = new TicTacToe();

  }
=======
	@Before
	public void setUp() {
		ticTacToe = new TicTacToe();
	}
>>>>>>> TicTacToe_simple_backend_idea

  @Test
  public void testBinarySumIs256() {
      int[] board = {0, 0, 0, 0, 0, 0, 0, 0, 1};
      assertEquals(256, ticTacToe.binarySum(board));
  }

  @Test
  public void testBinarySumIs1() {
      int[] board = {1, 0, 0, 0, 0, 0, 0, 0, 0};
      assertEquals(1, ticTacToe.binarySum(board));
<<<<<<< HEAD
  
  }


=======
  }

  @Test
  public void testCheckForVictory() {
      int[] board = {1, 1, 1, 0, 0, 0, 0, 0, 0};
      int sum = ticTacToe.binarySum(board);
      assertEquals(true, ticTacToe.checkForVictory(sum));
  }

  @Test
  public void testCheckForVictory() {
      int[] board = {1, 1, 1, 0, 0, 0, 0, 0, 0};
      int sum = ticTacToe.binarySum(board);
      assertEquals(true, ticTacToe.checkForVictory(sum));
  }

  @Test
  public void testCheckForVictory() {
      int[] board = {1, 1, 1, 0, 0, 0, 0, 0, 0};
      int sum = ticTacToe.binarySum(board);
      assertEquals(true, ticTacToe.checkForVictory(sum));
  }

    //@Test
    //public void testSomething() {
    //	assertEquals("this is something", TicTacToe.something());
    //}

  //@Test
  //public void testDeclareWinner() {
  //	ByteArrayOutputStream outContent = new ByteArrayOutputStream();
  //	System.setOut(new PrintStream(outContent));
  //	ticTacToe.declareWinner('X');
  //	assertEquals(outContent.toString(), "WE HAVE A WINNER: X");
  //}

  //@Test
  //public void testDeclareDraw() {
  //	ByteArrayOutputStream outContent = new ByteArrayOutputStream();
  //	System.setOut(new PrintStream(outContent));
  //	ticTacToe.declareDraw();
  //	assertEquals(outContent.toString(), "WE HAVE A DRAW!");
  //}
>>>>>>> TicTacToe_simple_backend_idea
}


