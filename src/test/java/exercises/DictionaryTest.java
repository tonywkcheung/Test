package exercises;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class DictionaryTest {

    private static exercises.Dictionary dictionary;
    private static boolean runOnce = true;
    
    @Before
    public void setUp() {
        
        if (runOnce) {
            dictionary = new exercises.Dictionary();
            dictionary.load("5desk.txt");
        }
        runOnce = false;
    }
    
    @Test
    public void testDogIsAGoodWord() {
        assertTrue(dictionary.checkWord("dog"));
    }

    @Test
    public void testXyzIsABadWord() {
        assertFalse(dictionary.checkWord("xyz"));
    }
    
    @Test
    public void testAbandonedIsAGoodWord() {
        assertTrue(dictionary.checkWord("abandoned"));

    }
}
