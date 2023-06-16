package com.tictactoe;

import java.util.ArrayList;
import java.util.List;

public class BoardGame {

    private final List<String> boardGameList = new ArrayList<>();

    public List<String> getBoardGame() {

        return boardGameList;
    }

    public void createBoardGame(BoardGameChooser boardGameChooser) {

        int fieldsNumber = boardGameChooser.boardGameSize * boardGameChooser.boardGameSize;
        for (int i = 0; i < fieldsNumber; i++) {
            boardGameList.add(" ");
        }
    }

    public void printBoardGame(BoardGameChooser boardGameChooser) {

        int rowNumber = 1;
        int n = 0;
        String [] letterArray = new String[] {" A ", "B ", "C ", "D ", "E ", "F ", "G ", "H ", "I ", "J "};
        for (int i = 0; i < boardGameChooser.boardGameSize; i++) {
            System.out.print(letterArray[i]);
        }
        System.out.println();
        for (int k = 0; k < boardGameChooser.boardGameSize; k++) {
            for (int r = 0; r < boardGameChooser.boardGameSize; r++) {
                System.out.print("|" + boardGameList.get(n++));
            }
            System.out.println("|" + rowNumber++);
        }
    }
}




