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
        boardGame.printBoardGame(boardGameChooser);

        while (!gameMechanics.theEnd) {

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
                    playerO.getIndexO(boardGameChooser);
                    symbolSet.setTheSymbolO(boardGame, playerO);
                    whileConditionO = true;
                } catch (NotEmptyFieldException e) {
                    System.out.println("Occupied! Try again!");
                }
            }

            boardGame.printBoardGame(boardGameChooser);
            gameMechanics.whoIsTheWinnerIs(boardGame);
            if(gameMechanics.theEnd) {
                break;
            }

            boolean whileConditionX = false;
            while (!whileConditionX) {
                playerX.communicationWithPlayerX(boardGame);
                try {
                    playerX.getIndexX(boardGameChooser);
                    symbolSet.setTheSymbolX(boardGame, playerX);
                    whileConditionX = true;
                } catch (NotEmptyFieldException e) {
                    System.out.println("Occupied! Try again!");
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
