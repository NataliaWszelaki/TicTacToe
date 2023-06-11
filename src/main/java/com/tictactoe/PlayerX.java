package com.tictactoe;

import java.util.Random;


public class PlayerX {
    Random random = new Random();
    protected int index;
    protected String columnX;
    protected String rowX;


    public void setColumnX(BoardGame boardGame) {
        String[] symbolsOfColumns = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j"};
        this.columnX = symbolsOfColumns[random.nextInt(boardGame.boardGameSizeInt)];
    }


    public void setRowX(BoardGame boardGame) {
        String[] symbolsOfRows = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
        this.rowX = symbolsOfRows[random.nextInt(boardGame.boardGameSizeInt)];
    }

    public void communicationWithPlayerX(BoardGame boardGame) {


        System.out.println("Player X move");
        setColumnX(boardGame);
        setRowX(boardGame);
        System.out.println("Player X choice: " + columnX.toUpperCase() + rowX);
    }

    public void getIndexX(BoardGame boardGame) {

            index =  columnX.charAt(0) - 'a' + (Integer.parseInt(rowX) - 1) * boardGame.boardGameSizeInt;
      }
}