package com.tictactoe;

public class TicTacToeApplication {

    public static void main(String[] args) {

        BoardGameChooser boardGameChooser = new BoardGameChooser();
        BoardGame boardGame = new BoardGame();
        PlayerO playerO = new PlayerO();
        InputChecker inputChecker = new InputChecker();
        PlayerX playerX = new PlayerX();
        SymbolSet symbolSet = new SymbolSet();
        GameMechanics gameMechanics = new GameMechanics();
        TheWinnerResult theWinnerResult = new TheWinnerResult();

        boolean bgSize = false;
        while (!bgSize) {
            try {
                boardGameChooser.whichBoardGame();
                boardGameChooser.whichBoardGameChecker();
                bgSize = true;
            } catch (WrongBoardGameSizeException e) {
                System.out.println("Out of bounce! Try again!");
            }
        }

        boardGame.createBoardGame(boardGameChooser);
        boardGame.printBoardGame();
        boardGameChooser.setOWinningString(boardGame);
        boardGameChooser.setXWinningString(boardGame);

        while (!theWinnerResult.theEnd) {

            boolean whileConditionO = false;
            while (!whileConditionO) {
                try {
                    playerO.communicationWithPlayerO(boardGame);
                    inputChecker.inputCheckerO(playerO, boardGame);
                } catch (NotExistingColumnOrRowException e) {
                    System.out.println("Out of bounce! Try again!");
                    continue;
                }
                try {
                    playerO.getIndexO(boardGame);
                    symbolSet.setTheSymbolO(boardGame, playerO);
                    whileConditionO = true;
                } catch (NotEmptyFieldException e) {
                    System.out.println("Occupied! Try again!");
                }
                boardGame.printBoardGame();
                gameMechanics.verticalO(playerO, boardGame);
                gameMechanics.horizontalO(playerO, boardGame);
                gameMechanics.diagonalUpLeftToDownRightO(playerO, boardGame);
                gameMechanics.diagonalDownLeftToUpRightO(playerO, boardGame);
                gameMechanics.listPrinter();
                theWinnerResult.whoIsTheWinner(boardGame, boardGameChooser, gameMechanics);
                if(theWinnerResult.theEnd) {
                    break;
            }


            }

            boolean whileConditionX = false;
            while (!whileConditionX) {
                playerX.communicationWithPlayerX(boardGame);
                try {
                    playerX.getIndexX(boardGame);
                    symbolSet.setTheSymbolX(boardGame, playerX);
                    whileConditionX = true;
                } catch (NotEmptyFieldException e) {
                    System.out.println("Occupied! Try again!");
                }
                boardGame.printBoardGame();
                gameMechanics.verticalX(playerX, boardGame);
                gameMechanics.horizontalX(playerX, boardGame);
                gameMechanics.diagonalDownLeftToUpRightX(playerX, boardGame);
                gameMechanics.diagonalUpLeftToDownRightX(playerX, boardGame);
                theWinnerResult.whoIsTheWinner(boardGame, boardGameChooser, gameMechanics);
                if(theWinnerResult.theEnd) {
                    break;
                }
            }
        }
    }
}
