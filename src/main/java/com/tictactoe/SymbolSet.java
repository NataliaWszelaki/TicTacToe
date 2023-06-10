package com.tictactoe;

import java.util.List;

public class SymbolSet {

    public List<String> setTheSymbolO(BoardGame boardGame, PlayerO playerO) throws  NotEmptyFieldException {

        if (boardGame.getBoardGame().get(playerO.index).equals(" ")) {
            boardGame.getBoardGame().remove(playerO.index);
            boardGame.getBoardGame().add(playerO.index, "O");

        } else {
            throw new NotEmptyFieldException();

        }
        return boardGame.getBoardGame();
    }

    public  void setTheSymbolX(BoardGame boardGame, PlayerX playerX) throws  NotEmptyFieldException {
        if (boardGame.getBoardGame().get(playerX.index).equals(" ")) {
            boardGame.getBoardGame().remove(playerX.index);
            boardGame.getBoardGame().add(playerX.index, "X");
        } else {
            throw new NotEmptyFieldException();
        }
        //czy jednak rozdzielić sprawdzanie i wpisywanie?
    }
}
