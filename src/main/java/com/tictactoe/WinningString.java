package com.tictactoe;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WinningString {
    String xWinningString;
    String oWinningString;
    int lengthOfWinningString;
    public void chooseLengthOfWinningString() throws OutOfBounceException {

        Scanner scanner = new Scanner(System.in);
        System.out.println("How long you want the winning string to be?");
        System.out.println("You can chose the number between 3 and 10.");
        lengthOfWinningString = scanner.nextInt();
        NumberChecker.numberChecker(lengthOfWinningString);
    }

    public void setOWinningString() {

        oWinningString = "O".repeat(Math.max(0, lengthOfWinningString));
    }

    public void setXWinningString() {

        xWinningString = "X".repeat(Math.max(0, lengthOfWinningString));
    }
}
