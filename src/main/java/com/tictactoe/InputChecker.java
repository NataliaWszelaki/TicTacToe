package com.tictactoe;

public class InputChecker {

    public void inputCheckerO(PlayerO playerO, BoardGameChooser boardGameChooser) throws OutOfBounceException {

        if (String.valueOf(playerO.columnO).equals("") || String.valueOf(playerO.rowO).equals("")) {
            throw new OutOfBounceException();
        }
        if (!(playerO.columnO >= 0 && playerO.columnO < boardGameChooser.boardGameSize &&
                playerO.rowO > 0 && playerO.rowO <= boardGameChooser.boardGameSize)) {
            throw new OutOfBounceException();
        }
    }
}
