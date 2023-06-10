package com.tictactoe;

public class InputChecker {

    public void inputCheckerO(PlayerO playerO, BoardGame boardGame) throws NotExistingColumnOrRowException {
        int columnOToCheck = playerO.columnO.charAt(0) - 'a' + 1;
        int rowOToCheck = Integer.parseInt(playerO.rowO);

        if (columnOToCheck > 0 && columnOToCheck <= boardGame.boardGameSizeInt && rowOToCheck > 0 && rowOToCheck <= boardGame.boardGameSizeInt) {
            System.out.println("Your choice: " + playerO.getColumnO().toUpperCase() + playerO.getRowO());
        } else {
            throw new NotExistingColumnOrRowException();
        }

    }

    public void inputCheckerX(PlayerX playerX, BoardGame boardGame) throws NotExistingColumnOrRowException {
        int columnXToCheck = playerX.columnX.charAt(0) - 'a' + 1;
        int rowXToCheck = Integer.parseInt(playerX.rowX);

        if (columnXToCheck > 0 && columnXToCheck <= boardGame.boardGameSizeInt && rowXToCheck > 0 && rowXToCheck <= boardGame.boardGameSizeInt) {
            System.out.println("Your choice: " + playerX.getColumnX().toUpperCase() + playerX.getRowX());
        } else {
            throw new NotExistingColumnOrRowException();
        }
    }
}
