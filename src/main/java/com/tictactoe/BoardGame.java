package com.tictactoe;

import java.util.ArrayList;
import java.util.List;

public class BoardGame {

    private final List<String> boardGameList = new ArrayList<>();

    public List<String> getBoardGame() {
        return boardGameList;
    }

    public void createBoardGame() {

        for (int i = 0; i < 9; i++) {
            boardGameList.add(" ");
        }
    }

    public void printBoardGame() {
        System.out.println();
        System.out.println("    " + "A" + " " + "B" + " " + "C" + " ");
        System.out.println("1  " + "|" + boardGameList.get(0) + "|" + boardGameList.get(1) + "|" + boardGameList.get(2) + "|");
        System.out.println("2  " + "|" + boardGameList.get(3) + "|" + boardGameList.get(4) + "|" + boardGameList.get(5) + "|");
        System.out.println("3  " + "|" + boardGameList.get(6) + "|" + boardGameList.get(7) + "|" + boardGameList.get(8) + "|");
        System.out.println();
    }

}


