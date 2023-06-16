package com.tictactoe;

public class TheWinnerResult {

    boolean theEnd = false;
    String theWinner = "";

    public void setTheWinner(String theWinner) {
        this.theWinner = theWinner;
    }

    public String whoIsTheWinner(BoardGame boardGame, GameMechanics gameMechanics, WinningString winningString) {

        for (String check : gameMechanics.lastMoveList) {
            if (check.contains(winningString.oWinningString)) {
                theWinner = "The Winner is Player O!";
                theEnd = true;
            } else if (check.contains(winningString.xWinningString)) {
                theWinner = "The Winner is Player X!";
                theEnd = true;
            } else if (!boardGame.getBoardGame().contains(" ")) {
                theWinner = "It's a tie!";
                theEnd = true;
                setTheWinner(theWinner);
            }
        }

        System.out.println(theWinner);
        return theWinner;

    }

}
