current_player = "X";

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
