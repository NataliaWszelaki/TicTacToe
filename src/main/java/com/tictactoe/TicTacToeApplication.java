package com.tictactoe;

public class TicTacToeApplication {


    public static void main(String[] args) {

        BoardGameChooser boardGameChooser = new BoardGameChooser();
        BoardGame boardGame = new BoardGame();
        PlayerO playerO = new PlayerO();
        PlayerX playerX = new PlayerX();
        GameMechanics gameMechanics = new GameMechanics();
        SymbolSet symbolSet = new SymbolSet();
        InputChecker inputChecker = new InputChecker();

        boolean bgSize = false;
        while (!bgSize) {
            try {
                boardGameChooser.whichBoardGame();
                boardGameChooser.whichBoardGameChecker();
                bgSize = true;
            } catch (WrongBoardSize e) {
                System.out.println("Try again!");
            }
        }

        boardGame.createBoardGame(boardGameChooser);
        boardGame.printBoardGame(boardGameChooser);


        while (!gameMechanics.theEnd) {

            boolean whileConditionO = false;
            while (!whileConditionO) {
                try {
                    playerO.communicationWithPlayerO();
                    inputChecker.inputCheckerO(playerO, boardGame);
                } catch (NotExistingColumnOrRowException e) {
                    System.out.println("Try again!");
                    continue;
                }
                try {
                    playerO.getIndexO(boardGameChooser);
                    symbolSet.setTheSymbolO(boardGame, playerO);
                    whileConditionO = true;
                } catch (NotEmptyFieldException e) {
                    System.out.println("Field is not empty! Try again!");
                }
            }

            boardGame.printBoardGame(boardGameChooser);
            gameMechanics.whoIsTheWinnerIs(boardGame);
            if(gameMechanics.theEnd) {
                break;
            }

            boolean whileConditionX = false;
            while (!whileConditionX) {
                try {
                    playerX.communicationWithPlayerX(boardGame);
                    inputChecker.inputCheckerX(playerX, boardGame);
                } catch (NotExistingColumnOrRowException e) {
                    System.out.println("Try again!");
                    continue;
                }
                try {
                    playerX.getIndexX(boardGameChooser);
                    symbolSet.setTheSymbolX(boardGame, playerX);
                    whileConditionX = true;
                } catch (NotEmptyFieldException e) {
                    System.out.println("Field is not empty! Try again!");
                }
                boardGame.printBoardGame(boardGameChooser);
                gameMechanics.whoIsTheWinnerIs(boardGame);
                if(gameMechanics.theEnd) {
                    break;
                }
            }
        }
    }
}
