package com.tictactoe;

import java.util.ArrayList;
import java.util.List;

public class NumberChecker {

    static void numberChecker(int variable) throws OutOfBounceException {
        List<Integer> numberChecker = new ArrayList<>();
        for (int i = 3; i < 11; i++) {
            numberChecker.add(i);
        }
        if (numberChecker.contains(variable)) {
            System.out.println("Your choice is: " + variable);
        } else {
            throw new OutOfBounceException();
        }
    }
}
