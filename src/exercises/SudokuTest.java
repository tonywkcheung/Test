package exercises;

import static org.junit.Assert.*;

import org.junit.Test;

public class SudokuTest {

    @Test
    public void testSudoku() {

        Sudoku sudoku = new Sudoku();

        sudoku.initValues("row0", new int[] { 0, 0, 3, 9, 0, 0, 7, 6, 0 });
        sudoku.initValues("row1", new int[] { 0, 4, 0, 0, 0, 6, 0, 0, 9 });
        sudoku.initValues("row2", new int[] { 6, 0, 7, 0, 1, 0, 0, 0, 4 });
        sudoku.initValues("row3", new int[] { 2, 0, 0, 6, 7, 0, 0, 9, 0 });
        sudoku.initValues("row4", new int[] { 0, 0, 4, 3, 0, 5, 6, 0, 0 });
        sudoku.initValues("row5", new int[] { 0, 1, 0, 0, 4, 9, 0, 0, 7 });
        sudoku.initValues("row6", new int[] { 7, 0, 0, 0, 9, 0, 2, 0, 1 });
        sudoku.initValues("row7", new int[] { 3, 0, 0, 2, 0, 0, 0, 4, 0 });
        sudoku.initValues("row8", new int[] { 0, 2, 9, 0, 0, 8, 5, 0, 0 });

        sudoku.updateStatistics();

        assertFalse(sudoku.complete());

        System.out.println(sudoku.toString());

        assertEquals("[0, 1, 4, 5, 8]", sudoku.getLine("row0").empty()
                .toString());
        assertEquals("[1, 2, 4, 5, 8]", sudoku.getLine("row0").unassigned()
                .toString());

        assertEquals("[0, 1, 3, 5, 7]", sudoku.getLine("grid0").empty()
                .toString());
        assertEquals("[1, 2, 5, 8, 9]", sudoku.getLine("grid0").unassigned()
                .toString());

        sudoku.solve(0, 0);

        System.out.println(sudoku.toString());
    }

    @Test
    public void testGridLinkage() {

        Sudoku sudoku = new Sudoku();
        assertEquals(0, sudoku.getGrid(0, 0));
        assertEquals(1, sudoku.getGrid(0, 4));
        assertEquals(8, sudoku.getGrid(8, 8));
    }
}
