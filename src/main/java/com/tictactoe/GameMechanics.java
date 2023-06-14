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

    public void horizontalO(PlayerO playerO, BoardGame boardGame) {

        StringBuilder stringBuilder = new StringBuilder();
        int h = (Integer.parseInt(playerO.rowO) - 1) * boardGame.boardGameSizeInt;
        for (int i = 0; i < boardGame.boardGameSizeInt; i++) {
            stringBuilder.append(boardGame.getBoardGame().get(h++));
        }
        String sH = stringBuilder.toString();
        System.out.println(sH);
        lastMoveList.add(sH);
    }

    public void verticalO(PlayerO playerO, BoardGame boardGame) {

        StringBuilder stringBuilder = new StringBuilder();
        int v = playerO.columnO.charAt(0) - 'a';
        for (int i = 0; i < boardGame.boardGameSizeInt; i++) {
            stringBuilder.append(boardGame.getBoardGame().get(v));
            v = v + boardGame.boardGameSizeInt;
        }
        String sV = stringBuilder.toString();
        lastMoveList.add(sV);
    }

    public void diagonalUpLeftToDownRightO(PlayerO playerO, BoardGame boardGame) {

        StringBuilder stringBuilder = new StringBuilder();
        for (rowValue = Integer.parseInt(playerO.rowO), columnValue = playerO.columnO.charAt(0) - 'a'; rowValue > 0 && columnValue >= 0; rowValue--, columnValue--) {
            indexMin = (rowValue - 1) * boardGame.boardGameSizeInt + columnValue;
        }
         for (rowValue = Integer.parseInt(playerO.rowO), columnValue = playerO.columnO.charAt(0) - 'a'; rowValue <= boardGame.boardGameSizeInt && columnValue < boardGame.boardGameSizeInt; rowValue++, columnValue++) {
            indexMax = (rowValue - 1) * boardGame.boardGameSizeInt + columnValue;
        }
        for(int i = indexMin; i <= indexMax; i = i + boardGame.boardGameSizeInt + 1){
            stringBuilder.append(boardGame.getBoardGame().get(indexMin));
            indexMin = indexMin + boardGame.boardGameSizeInt + 1;
        }
            String sd = stringBuilder.toString();
            lastMoveList.add(sd);
    }

    public void diagonalDownLeftToUpRightO(PlayerO playerO, BoardGame boardGame) {

        StringBuilder stringBuilder = new StringBuilder();
        for (rowValue = Integer.parseInt(playerO.rowO), columnValue = playerO.columnO.charAt(0) - 'a'; rowValue <= boardGame.boardGameSizeInt && columnValue >= 0; rowValue++, columnValue--) {
            indexMax = (rowValue - 1) * boardGame.boardGameSizeInt + columnValue;
        }
        for (rowValue = Integer.parseInt(playerO.rowO), columnValue = playerO.columnO.charAt(0) - 'a'; rowValue > 0 && columnValue < boardGame.boardGameSizeInt; rowValue--, columnValue++) {
            indexMin = (rowValue - 1) * boardGame.boardGameSizeInt + columnValue;
        }
        for(int i = indexMax; i >= indexMin; i = i - boardGame.boardGameSizeInt + 1){
            stringBuilder.append(boardGame.getBoardGame().get(indexMax));
            indexMax = indexMax - boardGame.boardGameSizeInt + 1;
        }
        String sd2 = stringBuilder.toString();
        lastMoveList.add(sd2);
    }

    public void horizontalX(PlayerX playerX, BoardGame boardGame) {

        StringBuilder stringBuilder = new StringBuilder();
        int h = (Integer.parseInt(playerX.rowX) - 1) * boardGame.boardGameSizeInt;
        for (int i = 0; i < boardGame.boardGameSizeInt; i++) {
            stringBuilder.append(boardGame.getBoardGame().get(h++));
        }
        String sH = stringBuilder.toString();
        lastMoveList.add(sH);
    }

    public void verticalX(PlayerX playerX, BoardGame boardGame) {

        StringBuilder stringBuilder = new StringBuilder();
        int v = playerX.columnX.charAt(0) - 'a';
        for (int i = 0; i < boardGame.boardGameSizeInt; i++) {
            stringBuilder.append(boardGame.getBoardGame().get(v));
            v = v + boardGame.boardGameSizeInt;
        }
        String sV = stringBuilder.toString();
        lastMoveList.add(sV);
    }

    public void diagonalUpLeftToDownRightX(PlayerX playerX, BoardGame boardGame) {

        StringBuilder stringBuilder = new StringBuilder();
        for (rowValue = Integer.parseInt(playerX.rowX), columnValue = playerX.columnX.charAt(0) - 'a'; rowValue > 0 && columnValue >= 0; rowValue--, columnValue--) {
            indexMin = (rowValue - 1) * boardGame.boardGameSizeInt + columnValue;
        }
        for (rowValue = Integer.parseInt(playerX.rowX), columnValue = playerX.columnX.charAt(0) - 'a'; rowValue <= boardGame.boardGameSizeInt && columnValue < boardGame.boardGameSizeInt; rowValue++, columnValue++) {
            indexMax = (rowValue - 1) * boardGame.boardGameSizeInt + columnValue;
        }
        for(int i = indexMin; i <= indexMax; i = i + boardGame.boardGameSizeInt + 1){
            stringBuilder.append(boardGame.getBoardGame().get(indexMin));
            indexMin = indexMin + boardGame.boardGameSizeInt + 1;
        }
        String sd = stringBuilder.toString();
        lastMoveList.add(sd);
    }

    public void diagonalDownLeftToUpRightX(PlayerX playerX, BoardGame boardGame) {

        StringBuilder stringBuilder = new StringBuilder();
        for (rowValue = Integer.parseInt(playerX.rowX), columnValue = playerX.columnX.charAt(0) - 'a'; rowValue <= boardGame.boardGameSizeInt && columnValue >= 0; rowValue++, columnValue--) {
            indexMax = (rowValue - 1) * boardGame.boardGameSizeInt + columnValue;
        }
        for (rowValue = Integer.parseInt(playerX.rowX), columnValue = playerX.columnX.charAt(0) - 'a'; rowValue > 0 && columnValue < boardGame.boardGameSizeInt; rowValue--, columnValue++) {
            indexMin = (rowValue - 1) * boardGame.boardGameSizeInt + columnValue;
        }
        for(int i = indexMax; i >= indexMin; i = i - boardGame.boardGameSizeInt + 1){
            stringBuilder.append(boardGame.getBoardGame().get(indexMax));
            indexMax = indexMax - boardGame.boardGameSizeInt + 1;
        }
        String sd2 = stringBuilder.toString();
        lastMoveList.add(sd2);
    }
}

