package com.tictactoe;

import java.util.Scanner;

public class UserX {
    Scanner scanner = new Scanner(System.in);
    private String columnX;
    private String rowX;

    public String getColumnX() {
        return columnX;
    }

    public void setColumnX() {
        this.columnX = scanner.next().toLowerCase();
    }

    public String getRowX() {
        return rowX;
    }

    public void setRowX() {
        this.rowX = scanner.next();
    }

    public void communicationWithPlayerX() {


        System.out.println("Player X move");
        System.out.println();

        System.out.println("Insert column symbol: A, B or C");

        setColumnX();

        System.out.println("Insert row symbol: 1, 2 or 3");
        setRowX();
    }
    public void inputCheckerX() throws NotExistingColumnOrRowException {
        if ((columnX.equals("a") || columnX.equals("b") || columnX.equals("c")) &&
                (rowX.equals("1") || rowX.equals("2") || rowX.equals("3"))) {
            System.out.println("Your choice: " + getColumnX().toUpperCase() + getRowX());
        } else {
            throw new NotExistingColumnOrRowException();
        }
    }

    public int getIndexX() {

        int index = (columnX.charAt(0) - 'a' + 1) + (Integer.parseInt(getRowX()) - 1) * 3 - 1;
        return index;
    }
}
