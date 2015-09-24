package exercises;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class AnagramSorterTest {

    private AnagramSorter anagramSorter = new AnagramSorter();

    @Test
    public void testThatStringsAreMergedIntoSingleSet() throws Exception {
        assertEquals("[[arc, car]]", anagramSorter.sortAnagrams(Arrays.asList("car", "arc")).toString());
    }

    @Test
    public void testThatStringsAreNotMergedIntoSingleSet() throws Exception {
        assertEquals("[[car], [mat]]", anagramSorter.sortAnagrams(Arrays.asList("car", "mat")).toString());
    }

    @Test
    public void testThatStringsAreMergedIntoTwoSets() throws Exception {
        assertEquals("[[arc, car], [mat, atm]]", anagramSorter.sortAnagrams(Arrays.asList("car", "arc", "mat", "atm")).toString());
    }

    @Test
    public void testEmptyStringSets() throws Exception {
        assertEquals("[[], [car], [atm]]", anagramSorter.sortAnagrams(Arrays.asList("car", "", "", "atm")).toString());
    }

    @Test
    public void testThatNullsAreIgnored() throws Exception {
        assertEquals("[[arc, car]]", anagramSorter.sortAnagrams(Arrays.asList("car", null, "arc")).toString());
    }

}