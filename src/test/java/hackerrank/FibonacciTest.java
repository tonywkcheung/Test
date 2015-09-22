package hackerrank;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class FibonacciTest {

    @Test
    public void testIsFibonacci() {
        assertTrue(Fibonacci.isFibonacci(0));
        assertTrue(Fibonacci.isFibonacci(1));
        assertTrue(Fibonacci.isFibonacci(2));
        assertTrue(Fibonacci.isFibonacci(3));
        assertFalse(Fibonacci.isFibonacci(4));
        assertTrue(Fibonacci.isFibonacci(5));
        assertFalse(Fibonacci.isFibonacci(6));
        assertTrue(Fibonacci.isFibonacci(13));
        assertTrue(Fibonacci.isFibonacci(21));
        assertFalse(Fibonacci.isFibonacci(22));
    }

    @Test
    public void testFibonacciSequences() {
        assertEquals(1, Fibonacci.calculateFibonacci(0));
        assertEquals(1, Fibonacci.calculateFibonacci(1));
        assertEquals(2, Fibonacci.calculateFibonacci(2));
        assertEquals(3, Fibonacci.calculateFibonacci(3));
        assertEquals(5, Fibonacci.calculateFibonacci(4));
        assertEquals(8, Fibonacci.calculateFibonacci(5));
        assertEquals(13, Fibonacci.calculateFibonacci(6));
        assertEquals(21, Fibonacci.calculateFibonacci(7));
    }
}