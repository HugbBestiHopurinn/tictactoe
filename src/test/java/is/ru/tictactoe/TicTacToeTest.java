package is.ru.tictactoe;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.Before;
import org.junit.rules.ExpectedException;
import org.junit.Rule;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class TicTacToeTest {

    TicTacToe ticTacToe;
    int[] board = {0, 0, 0, 0, 0, 0, 0, 0, 0};

    @Before
    public void setUp() {
        ticTacToe = new TicTacToe();
    }

    @Test
    public void testBinarySumIs256() {
        board = {0, 0, 0, 0, 0, 0, 0, 0, 1};
        assertEquals(256, ticTacToe.binarySum(board));
    }

    @Test
    public void testBinarySumIs1() {
        board = {1, 0, 0, 0, 0, 0, 0, 0, 0};
        assertEquals(1, ticTacToe.binarySum(board));
    }

    @Test
    public void testCheckForVictory() {
        board = {1, 1, 1, 0, 0, 0, 0, 0, 0};
        int sum = ticTacToe.binarySum(board);
        assertEquals(true, ticTacToe.checkForVictory(sum));
    }

    @Test
    public void testMoveMade() {
        JSONObject json = new JSONObject();
        board = {0, 0, 0, 0, 0, 0, 0, 0, 1};
        json.put("CurrentPlayer", "PlayerOne");
        json.put("PlayerBoard", board.toString());
        json.put("HasWon", "false");

        assertEquals(expectedJSON, moveMade("X", 0));
    }
}
