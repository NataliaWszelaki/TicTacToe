package com.tictactoe;

public class TicTacToeApplication {


    public static void main(String[] args) {

        BoardGame boardGame = new BoardGame();
        UserO userO = new UserO();
        UserX userX = new UserX();


        System.out.println("Welcome to tic-tac-toe!");

        boardGame.createBoardGame();
        boardGame.printBoardGame();

        while (!boardGame.theEnd) {

            boolean whileCondition1 = false;
            while (!whileCondition1) {
                try {
                    userO.communicationWithPlayerO();
                    userO.inputCheckerO();
                } catch (NotExistingColumnOrRowException e) {
                    System.out.println("Try again!");
                    continue;
                }
                try {
                    boardGame.setTheSymbolO(userO);
                    whileCondition1 = true;
                } catch (NotEmptyFieldException e) {
                    System.out.println("Field is not empty! Try again!");
                }
            }

            boardGame.printBoardGame();
            boardGame.theWinnerIs();
            if(boardGame.theEnd) {
                break;
            }

            boolean whileCondition2 = false;
            while (!whileCondition2) {
                try {
                    userX.communicationWithPlayerX();
                    userX.inputCheckerX();
                } catch (NotExistingColumnOrRowException e) {
                    System.out.println("Try again!");
                    continue;
                }
                try {
                    boardGame.setTheSymbolX(userX);
                    whileCondition2 = true;
                } catch (NotEmptyFieldException e) {
                    System.out.println("Field is not empty! Try again!");
                }
                boardGame.printBoardGame();
                boardGame.theWinnerIs();
                if(boardGame.theEnd) {
                    break;
                }
            }
        }
    }
}
