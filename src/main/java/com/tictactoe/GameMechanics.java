package com.tictactoe;

public class GameMechanics {
    boolean theEnd = false;



    public String whoIsTheWinnerIs(BoardGame boardGame) {
        String theWinner = " ";
        String row1 = boardGame.getBoardGame().get(0) + boardGame.getBoardGame().get(1) + boardGame.getBoardGame().get(2);
        String row2 = boardGame.getBoardGame().get(3) + boardGame.getBoardGame().get(4) + boardGame.getBoardGame().get(5);
        String row3 = boardGame.getBoardGame().get(6) + boardGame.getBoardGame().get(7) + boardGame.getBoardGame().get(8);
        String columnA = boardGame.getBoardGame().get(0) + boardGame.getBoardGame().get(3) + boardGame.getBoardGame().get(6);
        String columnB = boardGame.getBoardGame().get(1) + boardGame.getBoardGame().get(4) + boardGame.getBoardGame().get(7);
        String columnC = boardGame.getBoardGame().get(2) + boardGame.getBoardGame().get(5) + boardGame.getBoardGame().get(8);
        String crosslineI = boardGame.getBoardGame().get(0) + boardGame.getBoardGame().get(4) + boardGame.getBoardGame().get(8);
        String crosslineII = boardGame.getBoardGame().get(2) + boardGame.getBoardGame().get(4) + boardGame.getBoardGame().get(6);

        if(row1.contentEquals("OOO") || row2.contentEquals("OOO") ||row3.contentEquals("OOO") ||
                columnA.contentEquals("OOO") || columnB.contentEquals("OOO") || columnC.contentEquals("OOO") ||
                crosslineI.contentEquals("OOO") || crosslineII.contentEquals("OOO")) {
            theWinner = "The Winner is Player O!";
            theEnd = true;


        } else if (row1.contentEquals("XXX") || row2.contentEquals("XXX") ||row3.contentEquals("XXX") ||
                columnA.contentEquals("XXX") || columnB.contentEquals("XXX") || columnC.contentEquals("XXX") ||
                crosslineI.contentEquals("XXX") || crosslineII.contentEquals("XXX")) {
            theWinner = "The Winner is Player X!";
            theEnd = true;


        } else if (!boardGame.getBoardGame().contains(" ")) {
            theWinner = "It's a tie!";
            theEnd = true;

        }
        System.out.println(theWinner);
        return theWinner;
    }

}
