package com.tictactoe;

import java.util.Random;


public class PlayerX {
    Random random = new Random();
    protected int index;
    String column;
    protected int columnX;
    protected int rowX;

    public void setColumnX(BoardGameChooser boardGameChooser) {

        String[] symbolsOfColumns = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j"};
        column = symbolsOfColumns[random.nextInt(boardGameChooser.boardGameSize)];
        this.columnX = column.charAt(0) - 'a';
    }

    public void setRowX(BoardGameChooser boardGameChooser) {

        int[] symbolsOfRows = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        this.rowX = symbolsOfRows[random.nextInt(boardGameChooser.boardGameSize)];
    }

    public void communicationWithPlayerX(BoardGameChooser boardGameChooser) {

        System.out.println("Player X move");
        setColumnX(boardGameChooser);
        setRowX(boardGameChooser);
        System.out.println("Player X choice: " + column.toUpperCase() + rowX);
    }

    public void getIndexX(BoardGameChooser boardGameChooser) {

            index =  columnX + (rowX - 1) * boardGameChooser.boardGameSize;
      }
}