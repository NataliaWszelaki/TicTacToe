package com.tictactoe;

public class InputChecker {

    public void inputCheckerO(PlayerO playerO, BoardGame boardGame) throws NotExistingColumnOrRowException {

        if (!(playerO.columnO.charAt(0) - 'a' >= 0 && playerO.columnO.charAt(0) - 'a' < boardGame.boardGameSizeInt &&
                Integer.parseInt(playerO.rowO) > 0 && Integer.parseInt(playerO.rowO) <= boardGame.boardGameSizeInt)) {
            throw new NotExistingColumnOrRowException();
        }
    }

//    public void inputCheckerX(PlayerX playerX, BoardGame boardGame) throws NotExistingColumnOrRowException {
//
//        if (playerX.columnX.charAt(0) - 'a' >= 0 && playerX.columnX.charAt(0) - 'a' < boardGame.boardGameSizeInt &&
//                Integer.parseInt(playerX.rowX) > 0 && Integer.parseInt(playerX.rowX) <= boardGame.boardGameSizeInt) {
//            System.out.println("Your choice: " + playerX.getColumnX().toUpperCase() + playerX.getRowX());
//        } else {
//            throw new NotExistingColumnOrRowException();
//        }
//    }
}
