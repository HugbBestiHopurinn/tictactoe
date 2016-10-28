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
        final Main ticTacToe = new Main();
        //post("/random", (req, res) -> chuck.random());
        post("/player_move", (req, res) -> ticTacToe.make_move(req.queryParams("player"), req.queryParams("cell")));
        //post("/id", (req, res) -> chuck.getById(req.queryParams("id")));
        //post("/setName", (req, res) -> {
        //        chuck.alterName(
        //                        req.queryParams("firstName"),
        //                        req.queryParams("lastName")
        //                        );
        //        res.status(200);
        //        return res;
        //    });
    }

}
