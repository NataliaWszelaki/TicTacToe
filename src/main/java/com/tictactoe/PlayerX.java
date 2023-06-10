package com.tictactoe;

import java.util.Random;


public class PlayerX {
    Random random = new Random();
    protected int index;
    protected String columnX;
    protected String rowX;

    public String getColumnX() {
        return columnX;
    }

    public void setColumnX() {
        String[] symbolsOfColumns = {"a", "b", "c"};
        this.columnX = symbolsOfColumns[random.nextInt(symbolsOfColumns.length)];
    }

    public String getRowX() {
        return rowX;
    }

    public void setRowX() {
        String[] symbolsOfRows = {"1", "2", "3"};
        this.rowX = symbolsOfRows[random.nextInt(symbolsOfRows.length)];
    }

    public void communicationWithPlayerX() {


        System.out.println("Player X move");
        System.out.println();

        System.out.println("Insert column symbol: A, B or C");

        setColumnX();

        System.out.println("Insert row symbol: 1, 2 or 3");
        setRowX();
    }

    public int getIndexX() {

        index =  (columnX.charAt(0) - 'a' + 1) + (Integer.parseInt(getRowX()) - 1) * 3 - 1;
        return index;
    }
}
