package com.tictactoe;

import java.util.ArrayList;
import java.util.List;



public class GameMechanics {
    boolean theEnd = false;
    String strRow;
    String strColumn;

    public String whoIsTheWinnerIs(BoardGame boardGame) {

        String theWinner = " ";
        int m = 0;
        int n = 0;

        List<String> winnerList = new ArrayList<>();

        for (int k = 0; k < boardGame.boardGameSizeInt; k++) {
            if (boardGame.boardGameSizeInt == 3) {
                strRow = boardGame.getBoardGame().get(m++) + boardGame.getBoardGame().get(m++) + boardGame.getBoardGame().get(m++);
            } else {
                strRow = boardGame.getBoardGame().get(m++) + boardGame.getBoardGame().get(m++) + boardGame.getBoardGame().get(m++)
                        + boardGame.getBoardGame().get(m++) + boardGame.getBoardGame().get(m++) + boardGame.getBoardGame().get(m++)
                        + boardGame.getBoardGame().get(m++) + boardGame.getBoardGame().get(m++) + boardGame.getBoardGame().get(m++)
                        + boardGame.getBoardGame().get(m++);
            }
            winnerList.add(strRow);
        }

        for (int k = 0; k < boardGame.boardGameSizeInt; k++) {
            if (boardGame.boardGameSizeInt == 3) {
                strColumn = boardGame.getBoardGame().get(n) + boardGame.getBoardGame().get(n + 3) + boardGame.getBoardGame().get(n + 6);
            } else {
                strColumn = boardGame.getBoardGame().get(n) + boardGame.getBoardGame().get(n + 10) + boardGame.getBoardGame().get(n + 20)
                        + boardGame.getBoardGame().get(n + 30) + boardGame.getBoardGame().get(n + 40) + boardGame.getBoardGame().get(n + 50)
                        + boardGame.getBoardGame().get(n + 60) + boardGame.getBoardGame().get(n + 70) + boardGame.getBoardGame().get(n + 80)
                        + boardGame.getBoardGame().get(n + 90);

            }
            winnerList.add(strColumn);
            n++;
        }

        if (boardGame.boardGameSizeInt == 3) {
            String diagonal1 = boardGame.getBoardGame().get(0) + boardGame.getBoardGame().get(4) + boardGame.getBoardGame().get(8);
            String diagonal2 = boardGame.getBoardGame().get(2) + boardGame.getBoardGame().get(4) + boardGame.getBoardGame().get(6);
            winnerList.add(diagonal1);
            winnerList.add(diagonal2);
        } else {
            String diagonal3 = boardGame.getBoardGame().get(40) + boardGame.getBoardGame().get(n + 31) + boardGame.getBoardGame().get(n + 22)
                    + boardGame.getBoardGame().get(n + 13) + boardGame.getBoardGame().get(n + 4);
            String diagonal4 = boardGame.getBoardGame().get(50) + boardGame.getBoardGame().get(n + 41) + boardGame.getBoardGame().get(n + 32)
                    + boardGame.getBoardGame().get(n + 23) + boardGame.getBoardGame().get(n + 14) + boardGame.getBoardGame().get(n + 5);
            String diagonal5 = boardGame.getBoardGame().get(60) + boardGame.getBoardGame().get(n + 51) + boardGame.getBoardGame().get(n + 42)
                    + boardGame.getBoardGame().get(n + 33) + boardGame.getBoardGame().get(n + 24) + boardGame.getBoardGame().get(n + 15)
                    + boardGame.getBoardGame().get(n + 6);
            String diagonal6 = boardGame.getBoardGame().get(70) + boardGame.getBoardGame().get(n + 61) + boardGame.getBoardGame().get(n + 52)
                    + boardGame.getBoardGame().get(n + 43) + boardGame.getBoardGame().get(n + 34) + boardGame.getBoardGame().get(n + 25)
                    + boardGame.getBoardGame().get(n + 16) + boardGame.getBoardGame().get(n + 7);
            String diagonal7 = boardGame.getBoardGame().get(80) + boardGame.getBoardGame().get(n + 71) + boardGame.getBoardGame().get(n + 62)
                    + boardGame.getBoardGame().get(n + 53) + boardGame.getBoardGame().get(n + 44) + boardGame.getBoardGame().get(n + 35)
                    + boardGame.getBoardGame().get(n + 26) + boardGame.getBoardGame().get(n + 17) + boardGame.getBoardGame().get(n + 8);
            String diagonal8 = boardGame.getBoardGame().get(90) + boardGame.getBoardGame().get(n + 81) + boardGame.getBoardGame().get(n + 72)
                    + boardGame.getBoardGame().get(n + 63) + boardGame.getBoardGame().get(n + 54) + boardGame.getBoardGame().get(n + 45)
                    + boardGame.getBoardGame().get(n + 36) + boardGame.getBoardGame().get(n + 27) + boardGame.getBoardGame().get(n + 18)
                    + boardGame.getBoardGame().get(n + 9);
            String diagonal9 = boardGame.getBoardGame().get(0) + boardGame.getBoardGame().get(n + 11) + boardGame.getBoardGame().get(n + 22)
                    + boardGame.getBoardGame().get(n + 33) + boardGame.getBoardGame().get(n + 44) + boardGame.getBoardGame().get(n + 55)
                    + boardGame.getBoardGame().get(n + 66) + boardGame.getBoardGame().get(n + 77) + boardGame.getBoardGame().get(n + 88)
                    + boardGame.getBoardGame().get(n + 99);
            winnerList.add(diagonal3);
            winnerList.add(diagonal4);
            winnerList.add(diagonal5);
            winnerList.add(diagonal6);
            winnerList.add(diagonal7);
            winnerList.add(diagonal8);
            winnerList.add(diagonal9);
        }

        if (boardGame.boardGameSizeInt == 3) {
            for (String check : winnerList) {
                if (check.equals("OOO")) {
                    theWinner = "The Winner is Player O!";
                    theEnd = true;
                } else if (check.equals("XXX")) {
                    theWinner = "The Winner is Player X!";
                    theEnd = true;
                } else if (!boardGame.getBoardGame().contains(" ")) {
                    theWinner = "It's a tie!";
                    theEnd = true;
                }
            }
        } else {
            for (String check : winnerList) {
                if (check.equals("OOOOO")) {
                    theWinner = "The Winner is Player O!";
                    theEnd = true;
                } else if (check.equals("XXXXX")) {
                    theWinner = "The Winner is Player X!";
                    theEnd = true;
                } else if (!boardGame.getBoardGame().contains(" ")) {
                    theWinner = "It's a tie!";
                    theEnd = true;
                }
            }
        }
        System.out.println(theWinner);
        return theWinner;
    }
}


