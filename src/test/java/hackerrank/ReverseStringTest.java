package hackerrank;


import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ReverseStringTest {

    @Test
    public void test1() {
        assertEquals("Tony is name my Hello", ReverseStrings.reverseString("Hello my name is Tony"));
    }
}