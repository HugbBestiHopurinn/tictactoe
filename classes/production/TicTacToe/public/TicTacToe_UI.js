// Start settings
current_player = "X";
game_mode = "single";
$('table').hide();
alert("hello");

$('document').ready(function() {
    // Select Game Mode
    // Single Player or Multiplayer
    $('button.btn').click(function (){
        if ($(this).attr("game_mode") == "multi") {
            game_mode = "single";
            $.post("init_game?" + game_mode, function( data ) { alert(data) });
            console.log("Single game");
        } else {
            game_mode = "multi";
            $.post("init_game?" + game_mode, function( data ) { alert(data) });
            console.log("Multi game");
        }
        $('ul').hide();
        $('table').show();
    });

    // Clicking square on board
    $('td').click(function(){
        var cell_number = $(this).attr("data-id");
        mark_move(cell_number);
    });
});

// Marks the move on the board, if a legal move
// and let's the server know which move was made.
function mark_move(cell_number) {
    cell = $("[data-id='" + cell_number + "']");
    if (cell.hasClass("marked")) {
        alert("You can't do that");
    } else {
        switch_player();
        cell.addClass("marked");
        if (current_player == "X") {
            cell.css("color", "rgb(250,0,0)");
        } else {
            cell.css("color", "rgb(0,0,250)");
        }
        cell.html(current_player);
        // Notify Server of Move
        var player_move = "player_move?player=" + current_player + "&cell=" + cell_number;
        console.log("Player move: " + player_move);
        $.post(player_move, function( data ) { alert(data) });
    }
}

function switch_player() {
    if (current_player == "X") {
        current_player = "O";
    } else {
        current_player = "X";
    }
}

// To be run on game over and
// for game restart
function reset_board() {
    $('td').html("").removeClass("marked");
    $('ul').show();
    game_mode = "single";
    current_player = "X";
}
