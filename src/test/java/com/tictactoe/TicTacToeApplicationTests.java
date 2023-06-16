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
    @DisplayName("Player O - test")
    class PlayerOTests {

        @Test
        @DisplayName("Test to verify to check if Player O wins")
        void testWhoIsTheWinnerOinRows() {

            //Given
            BoardGame boardGame = new BoardGame();
            TheWinnerResult theWinnerResult = new TheWinnerResult();
            GameMechanics gameMechanics = new GameMechanics();
            gameMechanics.lastMoveList = new ArrayList<>();
            gameMechanics.lastMoveList.add("OOOX");
            WinningString winningString = new WinningString();
            winningString.oWinningString = "OOO";
            winningString.xWinningString = "XXX";

            //When
            var winner = theWinnerResult.whoIsTheWinner(boardGame, gameMechanics, winningString);

            //Then
            Assertions.assertEquals("The Winner is Player O!", winner);
        }
    }

    @Nested
    @DisplayName("Player X - tests")
    class PlayerXTests {

        @Test
        @DisplayName("Test to verify the wins of the 'x' symbol in rows.")
        void testWhoIsTheWinnerXinRows() {

            //Given
            BoardGame boardGame = new BoardGame();
            TheWinnerResult theWinnerResult = new TheWinnerResult();
            GameMechanics gameMechanics = new GameMechanics();
            gameMechanics.lastMoveList = new ArrayList<>();
            gameMechanics.lastMoveList.add("OOXXXX");
            WinningString winningString = new WinningString();
            winningString.oWinningString = "OOOO";
            winningString.xWinningString = "XXXX";

            //When
            var winner = theWinnerResult.whoIsTheWinner(boardGame, gameMechanics, winningString);

            //Then
            Assertions.assertEquals("The Winner is Player X!", winner);
        }
    }


    @Nested
    @DisplayName("Tie - tests")
    class TieTest {
        @Test
        @DisplayName("Test to verify if the Tie results works correctly")
        void testWhoIsTheWinnerTie() {

            //Given
            TheWinnerResult theWinnerResult = new TheWinnerResult();
            GameMechanics gameMechanics = new GameMechanics();
            gameMechanics.lastMoveList = new ArrayList<>();
            gameMechanics.lastMoveList.add("OXO");
            WinningString winningString = new WinningString();
            winningString.oWinningString = "OOO";
            winningString.xWinningString = "XXX";
            List<String> boardGame = new ArrayList<>();
            boardGame.add("O");
            boardGame.add("O");
            boardGame.add("X");
            boardGame.add("X");
            boardGame.add("O");
            when(boardGameMock.getBoardGame()).thenReturn(boardGame);

            //When
            var tie1st = theWinnerResult.whoIsTheWinner(boardGameMock, gameMechanics, winningString);

            //Then
            Assertions.assertEquals("It's a tie!", tie1st);
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
            playerO.index = 8;
            playerX.index = 2;
            when(boardGameMock.getBoardGame()).thenReturn(gb);

            //When&Then
            assertThrows(NotEmptyFieldException.class, () -> symbolSet.setTheSymbolO(boardGameMock, playerO));
            assertThrows(NotEmptyFieldException.class, () -> symbolSet.setTheSymbolX(boardGameMock, playerX));
        }

        @Test
        @DisplayName("Test to check an exception OutOfBounceException")
        void testNotExistingColumnOrRowException() throws OutOfBounceException {

            //Given
            BoardGameChooser boardGameChooser = new BoardGameChooser();
            PlayerO playerO = new PlayerO();

            InputChecker inputChecker = new InputChecker();
            playerO.columnO = 2;
            playerO.rowO = 11;


            //When&Then
            assertThrows(OutOfBounceException.class, () -> inputChecker.inputCheckerO(playerO, boardGameChooser));
        }
    }
}





