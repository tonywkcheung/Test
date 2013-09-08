package exercises;

import static org.junit.Assert.*;

import org.junit.Test;

public class T9SpellingTest {

    T9Spelling t9Spelling = new T9Spelling();

    @Test
    public void testHi() {
        assertEquals("44 444", t9Spelling.toNumbers("hi"));
    }

    @Test
    public void testYes() {
        assertEquals("999337777", t9Spelling.toNumbers("yes"));
    }

    @Test
    public void testFoobar() {
        assertEquals("333666 6660 022 2777", t9Spelling.toNumbers("foo  bar"));
    }

    @Test
    public void testHelloWorld() {
        assertEquals("4433555 555666096667775553",
                t9Spelling.toNumbers("hello world"));
    }

}
