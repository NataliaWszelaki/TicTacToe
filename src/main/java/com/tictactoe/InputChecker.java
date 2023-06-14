package com.tictactoe;

public class InputChecker {

    public void inputCheckerO(PlayerO playerO, BoardGame boardGame) throws NotExistingColumnOrRowException {

        if (playerO.columnO.equals("") || playerO.rowO.equals("")) {
            throw new NotExistingColumnOrRowException();
        }
        if (!(playerO.columnO.charAt(0) - 'a' >= 0 && playerO.columnO.charAt(0) - 'a' < boardGame.boardGameSizeInt &&
                Integer.parseInt(playerO.rowO) > 0 && Integer.parseInt(playerO.rowO) <= boardGame.boardGameSizeInt)) {
            throw new NotExistingColumnOrRowException();
        }
    }
}
