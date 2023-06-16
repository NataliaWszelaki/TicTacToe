package com.tictactoe;

import java.util.Scanner;

public class PlayerO {
    Scanner scanner = new Scanner(System.in);
    protected int index;
    protected int columnO;
    protected int rowO;
    protected String column;

    public void setColumnO() {

        this.columnO = column.charAt(0) - 'a';
    }

    public void communicationWithPlayerO(BoardGame boardGame) throws OutOfBounceException {

        System.out.println("Player O move");
        System.out.println("Insert column symbol: ");
        column = scanner.nextLine();
        System.out.println("Insert row symbol: ");
        rowO = scanner.nextInt();
        System.out.println("Your choice: " + scanner.nextLine().toUpperCase() + rowO);
        setColumnO();
    }

    public void getIndexO(BoardGameChooser boardGameChooser) {

            index = columnO + (rowO - 1) * boardGameChooser.boardGameSize;
    }
}

