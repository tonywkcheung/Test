package sort;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class InsertionSortTest {

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void testNull() {
        InsertionSort<Character> insertionSort = new InsertionSort<>();
        insertionSort.sort(null);
    }

    @Test
    public void testEmpty() {
        InsertionSort<Character> insertionSort = new InsertionSort<>();
        insertionSort.sort(new Character[]{});
    }

    @Test
    public void testSimpleElement() {
        InsertionSort<Character> insertionSort = new InsertionSort<>();
        insertionSort.sort(new Character[]{'A'});
    }

    @Test
    public void testSort() {
        Character[] chars = new Character[]{'C','A','B','I','N'};
        InsertionSort<Character> insertionSort = new InsertionSort<>();
        insertionSort.sort(chars);
        assertEquals("[A, B, C, I, N]", Arrays.toString(chars));
    }
}
