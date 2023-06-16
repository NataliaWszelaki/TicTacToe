package com.tictactoe;

public class TicTacToeApplication {

    public static void main(String[] args) {

        BoardGameChooser boardGameChooser = new BoardGameChooser();
        BoardGame boardGame = new BoardGame();
        WinningString winningString = new WinningString();
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
                bgSize = true;
            } catch (OutOfBounceException e) {
                System.out.println("Out of bounce! Try again!");
            }
        }

        boolean winStr = false;
        while (!winStr) {
            try {
                winningString.chooseLengthOfWinningString();
                winStr = true;
            } catch (OutOfBounceException e) {
                System.out.println("Out of bounce! Try again!");
            }
        }

        boardGame.createBoardGame(boardGameChooser);
        boardGame.printBoardGame(boardGameChooser);
        winningString.setOWinningString();
        winningString.setXWinningString();

        while (!theWinnerResult.theEnd) {

            boolean whileConditionO = false;
            while (!whileConditionO) {
                try {
                    playerO.communicationWithPlayerO(boardGame);
                    inputChecker.inputCheckerO(playerO, boardGameChooser);
                } catch (OutOfBounceException e) {
                    System.out.println("Out of bounce! Try again!");
                    continue;
                }
                try {
                    playerO.getIndexO(boardGameChooser);
                    symbolSet.setTheSymbolO(boardGame, playerO);
                    whileConditionO = true;
                } catch (NotEmptyFieldException e) {
                    System.out.println("Occupied! Try again!");
                }
                boardGame.printBoardGame(boardGameChooser);
                gameMechanics.verticalO(playerO, boardGame, boardGameChooser);
                gameMechanics.horizontalO(playerO, boardGame, boardGameChooser);
                gameMechanics.diagonalUpLeftToDownRightO(playerO, boardGame, boardGameChooser);
                gameMechanics.diagonalDownLeftToUpRightO(playerO, boardGame, boardGameChooser);
                theWinnerResult.whoIsTheWinner(boardGame, gameMechanics, winningString);
                if(theWinnerResult.theEnd) {
                    break;
                }
            }

            boolean whileConditionX = false;
            while (!whileConditionX) {
                playerX.communicationWithPlayerX(boardGameChooser);
                try {
                    playerX.getIndexX(boardGameChooser);
                    symbolSet.setTheSymbolX(boardGame, playerX);
                    whileConditionX = true;
                } catch (NotEmptyFieldException e) {
                    System.out.println("Occupied! Try again!");
                }
                boardGame.printBoardGame(boardGameChooser);
                gameMechanics.verticalX(playerX, boardGame, boardGameChooser);
                gameMechanics.horizontalX(playerX, boardGame, boardGameChooser);
                gameMechanics.diagonalDownLeftToUpRightX(playerX, boardGame, boardGameChooser);
                gameMechanics.diagonalUpLeftToDownRightX(playerX, boardGame, boardGameChooser);
                theWinnerResult.whoIsTheWinner(boardGame, gameMechanics, winningString);
                if(theWinnerResult.theEnd) {
                    break;
                }
            }
        }
    }
}
