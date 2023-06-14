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
    private GameMechanics gameMechanicsMock;

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
        @DisplayName("Test to verify the wins of the 'o' symbol in rows")
        void testWhoIsTheWinnerOinRows() {

            //Given
            GameMechanics gameMechanics = new GameMechanics();
            BoardGame boardGame = new BoardGame();
            gameMechanics.oWinningString = "OOO";
            List<String> gb = new ArrayList<>();
            gb.add("OOO");
            gb.add("O");
            gb.add("O");
            gb.add(" ");
            gb.add(" ");
            gb.add(" ");
            gb.add(" ");
            gb.add(" ");
            gb.add(" ");
            when(gameMechanicsMock.getLastMoveList()).thenReturn(gb);

            //When
            var winner = gameMechanics.whoIsTheWinner(boardGame);

            //Then
            Assertions.assertEquals("The Winner is Player O!", winner);
        }

        @Test
        @DisplayName("Test to verify the wins of the 'o' symbol in columns.")
        void testWhoIsTheWinnerOinColumns() {

            //Given
            FirstGameMechanics gameMechanics = new FirstGameMechanics();
            BoardGame boardGameMock = mock(BoardGame.class);
            boardGameMock.boardGameSizeInt = 3;
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
            FirstGameMechanics gameMechanics = new FirstGameMechanics();
            BoardGame boardGameMock = mock(BoardGame.class);
            boardGameMock.boardGameSizeInt = 3;
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
        @DisplayName("Test to verify the wins of the 'x' symbol in rows.")
        void testWhoIsTheWinnerXinRows() {

            //Given
            FirstGameMechanics gameMechanics = new FirstGameMechanics();
            BoardGame boardGameMock = mock(BoardGame.class);
            boardGameMock.boardGameSizeInt = 3;
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
            FirstGameMechanics gameMechanics = new FirstGameMechanics();
            BoardGame boardGameMock = mock(BoardGame.class);
            boardGameMock.boardGameSizeInt = 3;
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
            FirstGameMechanics gameMechanics = new FirstGameMechanics();
            BoardGame boardGameMock = mock(BoardGame.class);
            boardGameMock.boardGameSizeInt = 3;
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
            BoardGameChooser boardGameChooser = new BoardGameChooser();
            TheWinnerResult theWinnerResult = new TheWinnerResult();
            PlayerO playerO = new PlayerO();
            PlayerX playerX = new PlayerX();
            boardGameMock.boardGameSizeInt = 3;
            List<String> gb = new ArrayList<>();
            gb.add("OOO");
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
            var tie1st = theWinnerResult.whoIsTheWinner(boardGameMock, boardGameChooser, gameMechanics);

            //Then
            Assertions.assertEquals("It's a tie!", tie1st);
        }

        @Test
        @DisplayName("Test to verify if the Tie results works correctly - 2nd test")
        void testWhoIsTheWinnerTie2ndTest() {

            //Given
            GameMechanics gameMechanics = new GameMechanics();
            PlayerO playerO = new PlayerO();
            PlayerX playerX = new PlayerX();
            BoardGame boardGameMock = mock(BoardGame.class);
            boardGameMock.boardGameSizeInt = 3;
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
            var tie2nd = gameMechanics.whoIsTheWinner(boardGameMock);

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
        @DisplayName("Test to check an exception NotExistingColumnOrRowException")
        void testNotExistingColumnOrRowException() throws NotExistingColumnOrRowException {

            //Given
            BoardGame boardGameMock = mock(BoardGame.class);
            PlayerO playerO = new PlayerO();

            InputChecker inputChecker = new InputChecker();
            playerO.columnO = "a";
            playerO.rowO = "11";


            //When&Then
            assertThrows(NotExistingColumnOrRowException.class, () -> inputChecker.inputCheckerO(playerO, boardGameMock));

        }
    }
}




