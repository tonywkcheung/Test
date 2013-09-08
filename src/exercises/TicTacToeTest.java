package exercises;

import static org.junit.Assert.*;

import org.junit.Test;

public class TicTacToeTest {

    @Test
    public void testWinRow1() {
        char[] board = new char[] { 'x', 'x', 'x', 'o', 'o', ' ', ' ', 'o', ' ', };
        TicTacToe ticTacToe = new TicTacToe(board);
        assertEquals("Won by x on row1", ticTacToe.result());
    }

    @Test
    public void testWinCol3() {
        char[] board = new char[] { 'x', 'x', 'o', 'x', 'o', 'o', ' ', 'x', 'o', };
        TicTacToe ticTacToe = new TicTacToe(board);
        assertEquals("Won by o on col3", ticTacToe.result());
    }

    @Test
    public void testEmptyBoard() {
        char[] board = new char[] { ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ',
                ' ', };
        TicTacToe ticTacToe = new TicTacToe(board);
        assertEquals("No Winner", ticTacToe.result());
    }
}
