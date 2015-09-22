package hackerrank;


import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LCSTest {

    @Test
    public void test1() {
        assertEquals(0, LCS.findCommonChild("AA", "BB"));
    }

    @Test
    public void test2() {
        /*
        S H I N C H A N
        N O H A R A A A

        0 0 0 0 0 0 0 0
        0 0 1 1 1 1 1 1
        0 0 1 1 1 1 1 1
        0 0 1 1 1 1 1 1
        0 0 1 1 1 1 1 1
        0 0 1 1 1 1 1 1
        0 0 1 2 2 2 2 2
        0 0 1 2 2 2 2 2
        */
        assertEquals(3, LCS.findCommonChild("SHINCHAN", "NOHARAAA"));
    }

    @Test
    public void test3() {
        assertEquals(2, LCS.findCommonChild("ABCDEF", "FBDAMN"));
    }

    @Test
    public void test4() {
        assertEquals(2, LCS.findCommonChild("HARRY", "SALLY"));
    }
}