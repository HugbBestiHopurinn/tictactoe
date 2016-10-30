package is.ru.tictactoe;

import spark.*;
import static spark.Spark.*;
import spark.servlet.SparkApplication;

public class TicTacToeWeb implements SparkApplication {
    public static void main(String[] args) {
        staticFileLocation("/public");
        SparkApplication tictactoeweb = new TicTacToeWeb();

        String port = System.getenv("PORT");
        if (port != null) {
            port(Integer.valueOf(port));
        }

        tictactoeweb.init();
    }

    @Override
    public void init() {
        final TicTacToe ticTacToe = new TicTacToe();
        post("/init_game", (req, res) -> ticTacToe.init(req.queryParams("game_mode")));
        post("/player_move", (req, res) -> ticTacToe.moveMade(req.queryParams("player"), req.queryParams("cell")));
    }
}
