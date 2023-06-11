package com.tictactoe;

import java.util.ArrayList;
import java.util.List;

public class BoardGame {

    private final List<String> boardGameList = new ArrayList<>();
    protected int boardGameSizeInt;

    public List<String> getBoardGame() {

        return boardGameList;
    }

    public void createBoardGame(BoardGameChooser boardGameChooser) {

        boardGameSizeInt = Integer.parseInt(boardGameChooser.boardGameSize);
        int fieldsNumber = boardGameSizeInt * boardGameSizeInt;
        for (int i = 0; i < fieldsNumber; i++) {
            boardGameList.add(" ");
        }
    }

    public void printBoardGame(BoardGameChooser boardGameChooser) {

        int rowNumber = 1;
        int n = 0;

        if(boardGameSizeInt == 3) {
            System.out.println(" A " + "B " + "C ");
        } else {
            System.out.println(" A " + "B " + "C " + "D " + "E " + "F " + "G " + "H " + "I " + "J ");
        }

        for (int k = 0; k < boardGameSizeInt; k++) {
            for (int r = 0; r < boardGameSizeInt; r++) {
                System.out.print("|" + boardGameList.get(n++));
            }
            System.out.println("|" + rowNumber++);
        }
    }
}




