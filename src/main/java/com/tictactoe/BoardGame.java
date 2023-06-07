package com.tictactoe;

import java.util.ArrayList;
import java.util.List;

public class BoardGame {
    boolean theEnd = false;
    private final List<String> plansza = new ArrayList<>();

    public void createBoardGame() {

        for (int i = 0; i < 9; i++) {
            plansza.add(" ");
        }
    }

    public void printBoardGame() {
        System.out.println();
        System.out.println("    " + "A" + " " + "B" + " " + "C" + " ");
        System.out.println("1  " + "|" + plansza.get(0) + "|" + plansza.get(1) + "|" + plansza.get(2) + "|");
        System.out.println("2  " + "|" + plansza.get(3) + "|" + plansza.get(4) + "|" + plansza.get(5) + "|");
        System.out.println("3  " + "|" + plansza.get(6) + "|" + plansza.get(7) + "|" + plansza.get(8) + "|");
        System.out.println();
    }

public  void setTheSymbolO(UserO userO) throws  NotEmptyFieldException {
        if (plansza.get(userO.getIndexO()).equals(" ")) {
            plansza.remove(userO.getIndexO());
            plansza.add(userO.getIndexO(), "O");
        } else {
            throw new NotEmptyFieldException();
        }
}

    public  void setTheSymbolX(UserX userX) throws  NotEmptyFieldException {
        if (plansza.get(userX.getIndexX()).equals(" ")) {
            plansza.remove(userX.getIndexX());
            plansza.add(userX.getIndexX(), "X");
        } else {
            throw new NotEmptyFieldException();
        }
    }

    public void theWinnerIs() {

         String row1 = plansza.get(0) + plansza.get(1) + plansza.get(2);
         String row2 = plansza.get(3) + plansza.get(4) + plansza.get(5);
         String row3 = plansza.get(6) + plansza.get(7) + plansza.get(8);
         String columnA = plansza.get(0) + plansza.get(3) + plansza.get(6);
         String columnB = plansza.get(1) + plansza.get(4) + plansza.get(7);
         String columnC = plansza.get(2) + plansza.get(5) + plansza.get(8);
         String crosslineI = plansza.get(0) + plansza.get(4) + plansza.get(8);
         String crosslineII = plansza.get(2) + plansza.get(4) + plansza.get(6);

        if(row1.contentEquals("OOO") || row2.contentEquals("OOO") ||row3.contentEquals("OOO") ||
                columnA.contentEquals("OOO") || columnB.contentEquals("OOO") || columnC.contentEquals("OOO") ||
                crosslineI.contentEquals("OOO") || crosslineII.contentEquals("OOO")) {
            System.out.println("The Winner is Player O!");
            theEnd = true;
        } else if (row1.contentEquals("XXX") || row2.contentEquals("XXX") ||row3.contentEquals("XXX") ||
                    columnA.contentEquals("XXX") || columnB.contentEquals("XXX") || columnC.contentEquals("XXX") ||
                    crosslineI.contentEquals("XXX") || crosslineII.contentEquals("XXX")) {
            System.out.println("The Winner is Player X!");
            theEnd = true;
        } else if (!plansza.contains(" ")) {System.out.println("It's a tie!");
            theEnd = true;
        }
    }


}


