package exercises;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CountdownTest {
    private static Countdown countdown;
    private static boolean runOnce = true;
    
    @Before
    public void setUp() {
        
        if (runOnce) {
            countdown = new Countdown();
        }
        runOnce = false;
    }
    
    @Test
    public void testGreyhoundSolvable() {
        assertEquals("greyhound", countdown.solve("gyhdnoeur"));
    }
    
    @Test
    public void testAbandonedSolvable() {
        assertEquals("abandoned", countdown.solve("bonedadan"));
    }

    @Test
    public void testConnumdrumUnsolvable() {
        assertNull(countdown.solve("axaxagsja"));
    }
    
    @Test
    public void testNetworkLongestWord() {
        assertEquals("network", countdown.longestWord("norketwxs"));
    }

    @Test
    public void testSuborderLongestWord() {
        assertEquals("suborder", countdown.longestWord("redbusorq"));
    }

}
