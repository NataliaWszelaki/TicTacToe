package com.tictactoe;

import java.util.Scanner;

public class UserO {
    Scanner scanner = new Scanner(System.in);

    private String columnO;
    private String rowO;

    public String getColumnO() {
        return columnO;
    }

    public void setColumnO() {
        this.columnO = scanner.next().toLowerCase();
    }

    public String getRowO() {
        return rowO;
    }

    public void setRowO() {
        this.rowO = scanner.next();
    }

    public void communicationWithPlayerO() {

        System.out.println("Player O move");
        System.out.println();

        System.out.println("Insert column symbol: A, B or C");
        setColumnO();

        System.out.println("Insert row symbol: 1, 2 or 3");
        setRowO();
    }
    public void inputCheckerO() throws NotExistingColumnOrRowException {
        if ((getColumnO().equals("a") || getColumnO().equals("b") || getColumnO().equals("c")) &&
        (getRowO().equals("1") || getRowO().equals("2") || getRowO().equals("3"))) {
            System.out.println("Your choice: " + getColumnO().toUpperCase() + getRowO());
        } else {
            throw new NotExistingColumnOrRowException();
        }
    }

    public int getIndexO() {

        int index = (columnO.charAt(0) - 'a' + 1) + (Integer.parseInt(getRowO()) - 1) * 3 - 1;
return index;

    }
}

