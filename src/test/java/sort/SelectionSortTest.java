package sort;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class SelectionSortTest {

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void testNull() {
        SelectionSort<Character> selectionSort = new SelectionSort<>();
        selectionSort.sort(null);
    }

    @Test
    public void testEmpty() {
        SelectionSort<Character> selectionSort = new SelectionSort<>();
        selectionSort.sort(new Character[]{});
    }

    @Test
    public void testSimpleElement() {
        SelectionSort<Character> selectionSort = new SelectionSort<>();
        selectionSort.sort(new Character[]{'A'});
    }

    @Test
    public void testSort() {
        Character[] chars = new Character[]{'C','A','B','I','N'};
        SelectionSort<Character> selectionSort = new SelectionSort<>();
        selectionSort.sort(chars);
        assertEquals("[A, B, C, I, N]", Arrays.toString(chars));
    }
}
