package exercises;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.EmptyStackException;

import static org.junit.Assert.*;

public class MaxStackTest {

    private MaxStack maxStack;

    @Rule
    public ExpectedException thrown= ExpectedException.none();

    @Before
    public void setUp() throws Exception {
        maxStack = new MaxStack();
    }

    @Test
    public void testSinglePushFollowedByPop() throws Exception {
        maxStack.push(1);
        assertEquals(1, maxStack.pop().intValue());
    }

    @Test
    public void testMultiplePushFollowedByPop() throws Exception {
        maxStack.push(1);
        maxStack.push(2);
        maxStack.push(3);
        assertEquals(3, maxStack.pop().intValue());
        assertEquals(2, maxStack.pop().intValue());
        assertEquals(1, maxStack.pop().intValue());
    }

    @Test
    public void testPushFollowedByPeek() throws Exception {
        maxStack.push(1);
        maxStack.push(2);
        maxStack.push(3);
        assertEquals(3, maxStack.peek().intValue());
        assertEquals(3, maxStack.peek().intValue());
    }

    @Test
    public void testPeekDoesNotRemoveFromStack() throws Exception {
        maxStack.push(1);
        maxStack.push(2);
        maxStack.push(3);
        assertEquals(3, maxStack.peek().intValue());
        assertEquals(3, maxStack.pop().intValue());
        assertEquals(2, maxStack.pop().intValue());
        assertEquals(1, maxStack.pop().intValue());
    }

    @Test
    public void testPopWithNoPush() throws Exception {
        thrown.expect(EmptyStackException.class);
        assertNull(maxStack.pop());
    }

    @Test
    public void testPeekWithNoPush() throws Exception {
        assertNull(maxStack.peek());
    }

    @Test
    public void testPushOfNull() throws Exception {
        maxStack.push(null);
    }

    @Test
    public void testPushFollowedByMax() throws Exception {
        maxStack.push(1);
        assertEquals(1, maxStack.max().intValue());
        maxStack.push(2);
        assertEquals(2, maxStack.max().intValue());
        maxStack.push(3);
        assertEquals(3, maxStack.max().intValue());
        assertEquals(3, maxStack.pop().intValue());
        assertEquals(2, maxStack.max().intValue());
        assertEquals(2, maxStack.pop().intValue());
        assertEquals(1, maxStack.max().intValue());
        assertEquals(1, maxStack.pop().intValue());
    }
}