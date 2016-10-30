// Start settings
current_player = "X";
game_mode = "single";

$('table').hide();

// Select Game Mode
// Single Player or Multiplayer
$('.btn').click(function (){
    if ($(this).attr("game_mode") == "single") {
        game_mode = "single";
        $.post("init_game?game_mode=" + game_mode, function( data ) {});
    } else {
        game_mode = "multi";
        $.post("init_game?game_mode=" + game_mode, function( data ) {});
    }
    $('ul').hide();
    $('table').show();
});

// Clicking square on board
$('td').click(function(){
    var cell_number = $(this).attr("data-id");
    mark_move(cell_number);
});

function computer_moves() {
    console.log("Computer moving");
    console.log("Current player: " + current_player);
    console.log("Game Mode: " + game_mode);

    // Actually sending data to server via post request
    randomNumber = Math.floor(Math.floor(Math.random() * 8));
    isAlreadyMarked = $($('td')[randomNumber]).hasClass("marked");

    while (isAlreadyMarked) {
        randomNumber = Math.floor(Math.floor(Math.random() * 8));
        isAlreadyMarked = $($('td')[randomNumber]).hasClass("marked") && $('.marked').length != 9;
    }


    var computer_move = "player_move?player=" + current_player + "&cell=" + randomNumber;
    $($('td')[randomNumber]).addClass("marked").html("0").css('color', 'rgb(0,0,250)');
    console.log("marking");
    $.post(computer_move, function( data ) {
        if (response["HasWon"] == "true") {
            alert(response["CurrentPlayer"] + " wins!");
            window.location.reload();
        } else if ($('.marked').length == 9){
            alert("It's a draw!");
            window.location.reload();
        }
    });
    console.log("current player is: " + current_player);
}

// Marks the move on the board, if a legal move
// and let's the server know which move was made.
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

        // Actually sending data to server via post request
        $.post(player_move, function( data ) {
            response = JSON.parse(data);
            if (response["HasWon"] == "true") {
                alert(response["CurrentPlayer"] + " wins!");
                window.location.reload().reload();
            } else if ($('.marked').length == 9){
                alert("It's a draw!");
                window.location.reload();
            }
        });
        if (game_mode != "single") {
            computer_moves();
        } else {
            switch_player();
        }
    }
}

function switch_player() {
    if (current_player == "0") {
        current_player = "X";
    } else {
        current_player = "0";
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
