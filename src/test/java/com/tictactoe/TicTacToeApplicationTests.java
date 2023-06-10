package com.tictactoe;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@DisplayName("Tic Tac Toe - Game")
class TicTacToeApplicationTests {

    private static int testCounter = 0;

    @Mock
    private BoardGame boardGameMock;

    @BeforeAll
    public static void beforeAllTests() {
        System.out.println("This is the beginning of tests.");
    }

    @AfterAll
    public static void afterAllTests() {
        System.out.println("All tests are finished.");
    }

    @BeforeEach
    public void beforeEveryTest() {
        testCounter++;
        System.out.println("Preparing to execute test #" + testCounter);
    }


    @Nested
    @DisplayName("Player O - tests")
    class PlayerOTests {
        @Test
        @DisplayName("Test to verify if the symbol is set in a correct place")
        void testSetSymbolO() throws NotExistingColumnOrRowException, NotEmptyFieldException {

            //Given
            BoardGame boardGame = new BoardGame();
            SymbolSet symbolSet = new SymbolSet();
            BoardGameChooser boardGameChooser = new BoardGameChooser();
            PlayerO playerO = new PlayerO();
            boardGame.createBoardGame(boardGameChooser);
            playerO.index = 4;

            //When
            try {
                symbolSet.setTheSymbolO(boardGame, playerO);
            } catch (NotEmptyFieldException e) {
                throw new RuntimeException(e);
            }
            String field = boardGame.getBoardGame().get(4);

            //Then
            Assertions.assertEquals("O", field);
            boardGame.printBoardGame(boardGameChooser);
        }

        @Test
        @DisplayName("Test to verify the wins of the 'o' symbol in rows - Player O.")
        void testWhoIsTheWinnerOinRows() {

            //Given
            GameMechanics gameMechanics = new GameMechanics();
            List<String> gb = new ArrayList<>();
            gb.add("O");
            gb.add("O");
            gb.add("O");
            gb.add(" ");
            gb.add(" ");
            gb.add(" ");
            gb.add(" ");
            gb.add(" ");
            gb.add(" ");
            when(boardGameMock.getBoardGame()).thenReturn(gb);

            //When
            var winner = gameMechanics.whoIsTheWinnerIs(boardGameMock);

            //Then
            Assertions.assertEquals("The Winner is Player O!", winner);
        }

        @Test
        @DisplayName("Test to verify the wins of the 'o' symbol in columns.")
        void testWhoIsTheWinnerOinColumns() {

            //Given
            GameMechanics gameMechanics = new GameMechanics();
            BoardGame boardGameMock = mock(BoardGame.class);
            List<String> gb = new ArrayList<>();
            gb.add("O");
            gb.add(" ");
            gb.add(" ");
            gb.add("O");
            gb.add(" ");
            gb.add(" ");
            gb.add("O");
            gb.add(" ");
            gb.add(" ");
             when(boardGameMock.getBoardGame()).thenReturn(gb);

            //When
            var winner = gameMechanics.whoIsTheWinnerIs(boardGameMock);

            //Then
            Assertions.assertEquals("The Winner is Player O!", winner);
        }

        @Test
        @DisplayName("Test to verify the wins of the 'o' symbol in crossLines.")
        void testWhoIsTheWinnerOinCrossLines() {

            //Given
            GameMechanics gameMechanics = new GameMechanics();
            BoardGame boardGameMock = mock(BoardGame.class);
            List<String> gb = new ArrayList<>();
            gb.add("O");
            gb.add(" ");
            gb.add(" ");
            gb.add(" ");
            gb.add("O");
            gb.add(" ");
            gb.add(" ");
            gb.add(" ");
            gb.add("O");
            when(boardGameMock.getBoardGame()).thenReturn(gb);

            //When
            var winner = gameMechanics.whoIsTheWinnerIs(boardGameMock);

            //Then
            Assertions.assertEquals("The Winner is Player O!", winner);
        }
    }

    @Nested
    @DisplayName("Player X - tests")
    class PlayerXTests {
        @Test
        @DisplayName("Test to verify if the symbol is set in a correct place - Player X")
        void testSetSymbolX() throws NotExistingColumnOrRowException, NotEmptyFieldException {

            //Given
            BoardGame boardGame = new BoardGame();
            SymbolSet symbolSet = new SymbolSet();
            PlayerX playerX = new PlayerX();
            BoardGameChooser boardGameChooser = new BoardGameChooser();
            boardGame.createBoardGame(boardGameChooser);
            playerX.index = 5;
            boardGameChooser.boardGameSize = "3";
            //When
            try {
                symbolSet.setTheSymbolX(boardGame, playerX);
            } catch (NotEmptyFieldException e) {
                throw new RuntimeException(e);
            }
            String field = boardGame.getBoardGame().get(5);

            //Then
            Assertions.assertEquals("X", field);
            boardGame.printBoardGame(boardGameChooser);
        }

        @Test
        @DisplayName("Test to verify the wins of the 'x' symbol in rows.")
        void testWhoIsTheWinnerXinRows() {

            //Given
            GameMechanics gameMechanics = new GameMechanics();
            BoardGame boardGameMock = mock(BoardGame.class);
            List<String> gb = new ArrayList<>();
            gb.add(" ");
            gb.add(" ");
            gb.add(" ");
            gb.add("X");
            gb.add("X");
            gb.add("X");
            gb.add(" ");
            gb.add(" ");
            gb.add(" ");
            when(boardGameMock.getBoardGame()).thenReturn(gb);

            //When
            var winner = gameMechanics.whoIsTheWinnerIs(boardGameMock);

            //Then
            Assertions.assertEquals("The Winner is Player X!", winner);
        }

        @Test
        @DisplayName("Test to verify the wins of the 'x' symbol in columns.")
        void testWhoIsTheWinnerXinColumns() {

            //Given
            GameMechanics gameMechanics = new GameMechanics();
            BoardGame boardGameMock = mock(BoardGame.class);
            List<String> gb = new ArrayList<>();
            gb.add(" ");
            gb.add("X");
            gb.add(" ");
            gb.add(" ");
            gb.add("X");
            gb.add(" ");
            gb.add(" ");
            gb.add("X");
            gb.add(" ");
            when(boardGameMock.getBoardGame()).thenReturn(gb);

            //When
            var winner = gameMechanics.whoIsTheWinnerIs(boardGameMock);

            //Then
            Assertions.assertEquals("The Winner is Player X!", winner);
        }

        @Test
        @DisplayName("Test to verify the wins of the 'x' symbol in crossLines.")
        void testWhoIsTheWinnerXinCrossLines() {

            //Given
            GameMechanics gameMechanics = new GameMechanics();
            BoardGame boardGameMock = mock(BoardGame.class);
            List<String> gb = new ArrayList<>();
            gb.add(" ");
            gb.add(" ");
            gb.add("X");
            gb.add(" ");
            gb.add("X");
            gb.add(" ");
            gb.add("X");
            gb.add(" ");
            gb.add("X");
            when(boardGameMock.getBoardGame()).thenReturn(gb);

            //When
            var winner = gameMechanics.whoIsTheWinnerIs(boardGameMock);

            //Then
            Assertions.assertEquals("The Winner is Player X!", winner);
        }
    }

    @Nested
    @DisplayName("Tie - tests")
    class TieTests {
        @Test
        @DisplayName("Test to verify if the Tie results works correctly - 1st test")
        void testWhoIsTheWinnerTie1stTest() {

            //Given
            GameMechanics gameMechanics = new GameMechanics();
            BoardGame boardGameMock = mock(BoardGame.class);
            List<String> gb = new ArrayList<>();
            gb.add("O");
            gb.add("O");
            gb.add("X");
            gb.add("X");
            gb.add("O");
            gb.add("O");
            gb.add("O");
            gb.add("X");
            gb.add("X");
            when(boardGameMock.getBoardGame()).thenReturn(gb);

            //When
            var tie1st = gameMechanics.whoIsTheWinnerIs(boardGameMock);

            //Then
            Assertions.assertEquals("It's a tie!", tie1st);
        }

        @Test
        @DisplayName("Test to verify if the Tie results works correctly - 2nd test")
        void testWhoIsTheWinnerTie2ndTest() {

            //Given
            GameMechanics gameMechanics = new GameMechanics();
            BoardGame boardGameMock = mock(BoardGame.class);
            List<String> gb = new ArrayList<>();
            gb.add("O");
            gb.add("X");
            gb.add("O");
            gb.add("X");
            gb.add("X");
            gb.add("O");
            gb.add("O");
            gb.add("O");
            gb.add("X");
            when(boardGameMock.getBoardGame()).thenReturn(gb);

            //When
            var tie2nd = gameMechanics.whoIsTheWinnerIs(boardGameMock);

            //Then
            Assertions.assertEquals("It's a tie!", tie2nd);
        }
    }

    @Nested
    @DisplayName("Exceptions - tests")
    class ExceptionsTests {
        @Test
        @DisplayName("Test to check an exception NotEmptyFieldException")
        void testNotEmptyFieldException() {

            // Given
            PlayerO playerO = new PlayerO();
            PlayerX playerX = new PlayerX();
            SymbolSet symbolSet = new SymbolSet();
            List<String> gb = new ArrayList<>();
            gb.add("O");
            gb.add("X");
            gb.add("O");
            gb.add("X");
            gb.add("X");
            gb.add("O");
            gb.add("O");
            gb.add("O");
            gb.add("X");
            playerO.index = 8;
            playerX.index = 2;
            when(boardGameMock.getBoardGame()).thenReturn(gb);

            //When&Then
            assertThrows(NotEmptyFieldException.class, () -> symbolSet.setTheSymbolO(boardGameMock, playerO));
            assertThrows(NotEmptyFieldException.class, () -> symbolSet.setTheSymbolX(boardGameMock, playerX));
        }


        @Test
        @DisplayName("Test to check an exception NotExistingColumnOrRowException")
        void testNotExistingColumnOrRowException() throws NotExistingColumnOrRowException {

            //Given
            PlayerO playerO = new PlayerO();
            PlayerX playerX = new PlayerX();
            InputChecker inputChecker = new InputChecker();
            playerO.columnO = "a";
            playerO.rowO = "11";
            playerX.columnX = "z";
            playerX.rowX ="2";

            //When&Then
            assertThrows(NotExistingColumnOrRowException.class, () -> inputChecker.inputCheckerO(playerO, boardGameMock));
            assertThrows(NotExistingColumnOrRowException.class, () -> inputChecker.inputCheckerX(playerX, boardGameMock));
        }
    }
}




