package com.tictactoe;

import java.util.Scanner;

public class BoardGameChooser {

    protected String boardGameSize;

    public void whichBoardGame() {
        System.out.println("Welcome to tic-tac-toe!");
        System.out.println();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Which board game size do you choose 3x3 or 10x10?");
        System.out.println("For 3x3 size insert \"3\"");
        System.out.println("For 10x10 size insert \"10\"");
        boardGameSize = scanner.next();
    }

    public void whichBoardGameChecker() throws WrongBoardSize {

        if (boardGameSize.equals("3") || boardGameSize.equals("10")) {
            System.out.println("Your choice is: " + boardGameSize);
        } else {
            throw new WrongBoardSize();
        }
    }
}

