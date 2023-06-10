package com.tictactoe;

import java.util.ArrayList;
import java.util.List;

public class BoardGame {

    private final List<String> boardGameList = new ArrayList<>();
    int boardGameSizeInt;
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

       if(boardGameSizeInt == 3) {
           System.out.println("A " + "B " + "C ");
       } else {
           System.out.println("A " + "B " + "C " + "D " + "E " + "F " + "G " + "H " + "I " + "J ");
       }

       int rowNumber = 1;
      int n = 0;


        for (int kolumna = 0; kolumna < boardGameSizeInt; kolumna++) {

            for (int wiersz = 0; wiersz < boardGameSizeInt; wiersz++) {
                System.out.print(boardGameList.get(n++)+"|");
            }
            System.out.println(rowNumber++);
        }



    }



    }




