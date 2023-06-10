package com.tictactoe;

import java.util.Scanner;

public class PlayerX {
    Scanner scanner = new Scanner(System.in);
    protected int index;
    protected String columnX;
    protected String rowX;

    public String getColumnX() {
        return columnX;
    }

    public void setColumnX() {
        this.columnX = scanner.nextLine().toLowerCase();
    }

    public String getRowX() {
        return rowX;
    }

    public void setRowX() {
        this.rowX = scanner.nextLine();
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
