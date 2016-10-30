package is.ru.tictactoe;

public class TicTacToe {

    String gameType;

    public String init(String gameType) {
        if (gameType.equals("single")) {
        } else {
        }
        return "hello";
    }

    int binarySum(int board []) {
        int sum = 0;
        for (int i = 0; i < 9; i++) {
            int shift = (i - 1 != -1) ? (i - 1) : 0;
            sum += (2 << shift) * board[i];
        }
        if (board[0] == 1) {
            sum--;
        }
        return sum;
    }

    boolean check_for_victory(int sum) {

        int victory_combo [] = {0x1C0, 0x38, 0x92, 0x54, 0x7, 0x124, 0x49};
        boolean win_status = false;
        for (int i = 0; i < 5; i++) {
            win_status = ((((victory_combo[i] & sum)
                            == victory_combo[i]) != false) || (win_status != false));
        }
        return win_status;
    }

    private interface Player {
        int [] board = {0,0,0,0,0,0,0,0,0};
        void makeMove();
    }

    private abstract class HumanPlayer implements Player {
    }

    private abstract class ComputerPlayer implements Player {
    }

    //public static void main(String args[]) {
    //    TicTacToe game = new TicTacToe("single");
    //    int [] board = {1,1,1,0,0,0,1,0,0};
    //    int sum = game.binarySum(board);
    //}

    public String moveMade(String player, String cell) {
        return "hello";
    }

}
