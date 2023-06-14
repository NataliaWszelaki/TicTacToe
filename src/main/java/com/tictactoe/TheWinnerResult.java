package com.tictactoe;

public class TheWinnerResult {

    boolean theEnd = false;
    String theWinner = "";

    public String whoIsTheWinner(BoardGame boardGame, BoardGameChooser boardGameChooser, GameMechanics gameMechanics) {

        for (String check : gameMechanics.lastMoveList) {
            if (check.contains(boardGameChooser.oWinningString)) {
                theWinner = "The Winner is Player O!";
                theEnd = true;
            } else if (check.contains(boardGameChooser.xWinningString)) {
                theWinner = "The Winner is Player X!";
                theEnd = true;
            } else if (!boardGame.getBoardGame().contains(" ")) {
                theWinner = "It's a tie!";
                theEnd = true;
            }
        }
        System.out.println(theWinner);
        return theWinner;
    }

}
