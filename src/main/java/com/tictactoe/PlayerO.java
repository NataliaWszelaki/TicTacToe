package com.tictactoe;

import java.util.Scanner;

public class PlayerO {
    Scanner scanner = new Scanner(System.in);
    protected int index;
    protected String columnO;
    protected String rowO;

    public void setColumnO() {

        this.columnO = scanner.nextLine().toLowerCase();
    }

    public void setRowO() {

        this.rowO = scanner.nextLine();
    }

    public void communicationWithPlayerO(BoardGame boardGame) throws NotExistingColumnOrRowException {

        System.out.println("Player O move");
        System.out.println();
        System.out.println("Insert column symbol: ");
        setColumnO();
        System.out.println("Insert row symbol: ");
        setRowO();
        System.out.println("Your choice: " + columnO.toUpperCase() + rowO);
    }

    public void getIndexO(BoardGame boardGame) {

            index = columnO.charAt(0) - 'a' + (Integer.parseInt(rowO) - 1) * boardGame.boardGameSizeInt;
    }
}

