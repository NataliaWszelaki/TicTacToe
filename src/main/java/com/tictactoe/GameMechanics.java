package com.tictactoe;

import java.util.ArrayList;
import java.util.List;

public class GameMechanics {

    int rowValue;
    int columnValue;
    int indexMin = 0;
    int indexMax = 0;
    List<String> lastMoveList = new ArrayList<>();

    public List<String> getLastMoveList() {
        return lastMoveList;
    }

    public void horizontalO(PlayerO playerO, BoardGame boardGame, BoardGameChooser boardGameChooser) {

        StringBuilder stringBuilder = new StringBuilder();
        int h = (playerO.rowO - 1) * boardGameChooser.boardGameSize;
        for (int i = 0; i < boardGameChooser.boardGameSize; i++) {
            stringBuilder.append(boardGame.getBoardGame().get(h++));
        }
        String sH = stringBuilder.toString();
        System.out.println(sH);
        lastMoveList.add(sH);
    }

    public void verticalO(PlayerO playerO, BoardGame boardGame, BoardGameChooser boardGameChooser) {

        StringBuilder stringBuilder = new StringBuilder();
        int v = playerO.columnO;
        for (int i = 0; i < boardGameChooser.boardGameSize; i++) {
            stringBuilder.append(boardGame.getBoardGame().get(v));
            v = v + boardGameChooser.boardGameSize;
        }
        String sV = stringBuilder.toString();
        lastMoveList.add(sV);
    }

    public void diagonalUpLeftToDownRightO(PlayerO playerO, BoardGame boardGame, BoardGameChooser boardGameChooser) {

        StringBuilder stringBuilder = new StringBuilder();
        for (rowValue = playerO.rowO, columnValue = playerO.columnO;
             rowValue > 0 && columnValue >= 0; rowValue--, columnValue--) {
            indexMin = (rowValue - 1) * boardGameChooser.boardGameSize + columnValue;
        }
         for (rowValue = playerO.rowO, columnValue = playerO.columnO;
              rowValue <= boardGameChooser.boardGameSize && columnValue < boardGameChooser.boardGameSize; rowValue++, columnValue++) {
            indexMax = (rowValue - 1) * boardGameChooser.boardGameSize + columnValue;
        }
        diagonalUpLeftToDownRight(boardGame, boardGameChooser, stringBuilder);
    }

    private void diagonalUpLeftToDownRight(BoardGame boardGame, BoardGameChooser boardGameChooser, StringBuilder stringBuilder) {
        for(int i = indexMin; i <= indexMax; i = i + boardGameChooser.boardGameSize + 1){
            stringBuilder.append(boardGame.getBoardGame().get(indexMin));
            indexMin = indexMin + boardGameChooser.boardGameSize + 1;
        }
        String sd = stringBuilder.toString();
        lastMoveList.add(sd);
    }

    public void diagonalDownLeftToUpRightO(PlayerO playerO, BoardGame boardGame, BoardGameChooser boardGameChooser) {

        StringBuilder stringBuilder = new StringBuilder();
        for (rowValue = playerO.rowO, columnValue = playerO.columnO;
             rowValue <= boardGameChooser.boardGameSize && columnValue >= 0; rowValue++, columnValue--) {
            indexMax = (rowValue - 1) * boardGameChooser.boardGameSize + columnValue;
        }
        for (rowValue = playerO.rowO, columnValue = playerO.columnO;
             rowValue > 0 && columnValue < boardGameChooser.boardGameSize; rowValue--, columnValue++) {
            indexMin = (rowValue - 1) * boardGameChooser.boardGameSize + columnValue;
        }
        diagonalDownLeftToUpRight(boardGame, boardGameChooser, stringBuilder);
    }

    private void diagonalDownLeftToUpRight(BoardGame boardGame, BoardGameChooser boardGameChooser, StringBuilder stringBuilder) {
        for(int i = indexMax; i >= indexMin; i = i - boardGameChooser.boardGameSize + 1){
            stringBuilder.append(boardGame.getBoardGame().get(indexMax));
            indexMax = indexMax - boardGameChooser.boardGameSize + 1;
        }
        String sd2 = stringBuilder.toString();
        lastMoveList.add(sd2);
    }

    public void horizontalX(PlayerX playerX, BoardGame boardGame, BoardGameChooser boardGameChooser) {

        StringBuilder stringBuilder = new StringBuilder();
        int h = (playerX.rowX - 1) * boardGameChooser.boardGameSize;
        for (int i = 0; i < boardGameChooser.boardGameSize; i++) {
            stringBuilder.append(boardGame.getBoardGame().get(h++));
        }
        String sH = stringBuilder.toString();
        lastMoveList.add(sH);
    }

    public void verticalX(PlayerX playerX, BoardGame boardGame, BoardGameChooser boardGameChooser) {

        StringBuilder stringBuilder = new StringBuilder();
        int v = playerX.columnX;
        for (int i = 0; i < boardGameChooser.boardGameSize; i++) {
            stringBuilder.append(boardGame.getBoardGame().get(v));
            v = v + boardGameChooser.boardGameSize;
        }
        String sV = stringBuilder.toString();
        lastMoveList.add(sV);
    }

    public void diagonalUpLeftToDownRightX(PlayerX playerX, BoardGame boardGame,BoardGameChooser boardGameChooser) {

        StringBuilder stringBuilder = new StringBuilder();
        for (rowValue = playerX.rowX, columnValue = playerX.columnX;
             rowValue > 0 && columnValue >= 0; rowValue--, columnValue--) {
            indexMin = (rowValue - 1) * boardGameChooser.boardGameSize + columnValue;
        }
        for (rowValue = playerX.rowX, columnValue = playerX.columnX;
             rowValue <= boardGameChooser.boardGameSize && columnValue < boardGameChooser.boardGameSize; rowValue++, columnValue++) {
            indexMax = (rowValue - 1) * boardGameChooser.boardGameSize + columnValue;
        }
        diagonalUpLeftToDownRight(boardGame, boardGameChooser, stringBuilder);
    }

    public void diagonalDownLeftToUpRightX(PlayerX playerX, BoardGame boardGame, BoardGameChooser boardGameChooser) {

        StringBuilder stringBuilder = new StringBuilder();
        for (rowValue = playerX.rowX, columnValue = playerX.columnX;
             rowValue <= boardGameChooser.boardGameSize && columnValue >= 0; rowValue++, columnValue--) {
            indexMax = (rowValue - 1) * boardGameChooser.boardGameSize + columnValue;
        }
        for (rowValue = playerX.rowX, columnValue = playerX.columnX;
             rowValue > 0 && columnValue < boardGameChooser.boardGameSize; rowValue--, columnValue++) {
            indexMin = (rowValue - 1) * boardGameChooser.boardGameSize + columnValue;
        }
        diagonalDownLeftToUpRight(boardGame, boardGameChooser, stringBuilder);
    }
}

