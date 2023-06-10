package com.tictactoe;

import java.util.Scanner;

public class PlayerO {
    Scanner scanner = new Scanner(System.in);
    protected int index;
    protected String columnO;
    protected String rowO;

    public String getColumnO() {
        return columnO;
    }

    public void setColumnO() {
        this.columnO = scanner.nextLine().toLowerCase();
    }

    public String getRowO() {
        return rowO;
    }

    public void setRowO() {
        this.rowO = scanner.nextLine();
    }

    public void communicationWithPlayerO() {

        System.out.println("Player O move");
        System.out.println();

        System.out.println("Insert column symbol: ");
        setColumnO();

        System.out.println("Insert row symbol: ");
        setRowO();
    }

    public void getIndexO(BoardGameChooser boardGameChooser) {

        if(boardGameChooser.boardGameSize.equals("3")) {
            index = (columnO.charAt(0) - 'a' + 1) + (Integer.parseInt(getRowO()) - 1) * 3 - 1;
        } else {
            index = (columnO.charAt(0) - 'a' + 1) + (Integer.parseInt(getRowO()) - 1) * 10 - 1;
        }
    }
}

