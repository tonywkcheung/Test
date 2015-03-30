package exercises;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class DictionaryTest {

    private static Dictionary dictionary;
    private static boolean runOnce = true;
    
    @Before
    public void setUp() {
        
        if (runOnce) {
            dictionary = new Dictionary();
            dictionary.load("/Users/tonycheung/workspace/Test/data/5desk.txt");
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
