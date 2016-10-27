current_player = "X";
game_mode = "single_player";

$('td').click(function(){
    var cell_number = $(this).attr("data-id");
    mark_move(cell_number);
});

function mark_move(cell_number) {
    cell = $("[data-id='" + cell_number + "']");
    if (cell.hasClass("marked")) {
        alert("You can't do that");
    } else {
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
        $.post(player_move, function( data ) {
            switch_player();
        });
    }
}

function switch_player() {
    if (current_player == "X") {
        current_player = "O";
    } else {
        current_player = "X";
    }
}

function reset_board() {
    $('td').html("").removeClass("marked");
}
