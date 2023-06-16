package com.tictactoe;

import java.util.Scanner;

public class BoardGameChooser {

    protected int boardGameSize;

    public void whichBoardGame() throws OutOfBounceException {

        System.out.println("Welcome to tic-tac-toe!");
        System.out.println();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Which board game size do you choose 3x3 or 10x10?");
        System.out.println("For 3x3 size insert \"3\"");
        System.out.println("For 10x10 size insert \"10\"");
        boardGameSize = scanner.nextInt();
        NumberChecker.numberChecker(boardGameSize);
    }
}

