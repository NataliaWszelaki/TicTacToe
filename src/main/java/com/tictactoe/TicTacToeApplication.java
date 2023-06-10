package com.tictactoe;

public class TicTacToeApplication {


    public static void main(String[] args) {

        BoardGame boardGame = new BoardGame();
        PlayerO playerO = new PlayerO();
        PlayerX playerX = new PlayerX();
        GameMechanics gameMechanics = new GameMechanics();
        SymbolSet symbolSet = new SymbolSet();
        InputChecker inputChecker = new InputChecker();




        System.out.println("Welcome to tic-tac-toe!");

        boardGame.createBoardGame();
        boardGame.printBoardGame();

        while (!gameMechanics.theEnd) {

            boolean whileConditionO = false;
            while (!whileConditionO) {
                try {
                    playerO.communicationWithPlayerO();
                    inputChecker.inputCheckerO(playerO);
                } catch (NotExistingColumnOrRowException e) {
                    System.out.println("Try again!");
                    continue;
                }
                try {
                    playerO.getIndexO();
                    symbolSet.setTheSymbolO(boardGame, playerO);
                    whileConditionO = true;
                } catch (NotEmptyFieldException e) {
                    System.out.println("Field is not empty! Try again!");
                }
            }

            boardGame.printBoardGame();
            gameMechanics.whoIsTheWinnerIs(boardGame);
            if(gameMechanics.theEnd) {
                break;
            }

            boolean whileConditionX = false;
            while (!whileConditionX) {
                try {
                    playerX.communicationWithPlayerX();
                    inputChecker.inputCheckerX(playerX);
                } catch (NotExistingColumnOrRowException e) {
                    System.out.println("Try again!");
                    continue;
                }
                try {
                    playerX.getIndexX();
                    symbolSet.setTheSymbolX(boardGame, playerX);
                    whileConditionX = true;
                } catch (NotEmptyFieldException e) {
                    System.out.println("Field is not empty! Try again!");
                }
                boardGame.printBoardGame();
                gameMechanics.whoIsTheWinnerIs(boardGame);
                if(gameMechanics.theEnd) {
                    break;
                }
            }
        }
    }
}
