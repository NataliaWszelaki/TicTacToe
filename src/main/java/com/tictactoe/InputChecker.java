package com.tictactoe;

public class InputChecker {

    public void inputCheckerO(PlayerO playerO) throws NotExistingColumnOrRowException {
        if ((playerO.getColumnO().equals("a") || playerO.getColumnO().equals("b") || playerO.getColumnO().equals("c")) &&
                (playerO.getRowO().equals("1") || playerO.getRowO().equals("2") || playerO.getRowO().equals("3"))) {
            System.out.println("Your choice: " + playerO.getColumnO().toUpperCase() + playerO.getRowO());
        } else {
            throw new NotExistingColumnOrRowException();
        }
    }

    public void inputCheckerX(PlayerX playerX) throws NotExistingColumnOrRowException {
        if ((playerX.getColumnX().equals("a") || playerX.getColumnX().equals("b") || playerX.getColumnX().equals("c")) &&
                (playerX.getRowX().equals("1") || playerX.getRowX().equals("2") || playerX.getRowX().equals("3"))) {
            System.out.println("Your choice: " + playerX.getColumnX().toUpperCase() + playerX.getRowX());
        } else {
            throw new NotExistingColumnOrRowException();
        }
    }

}
