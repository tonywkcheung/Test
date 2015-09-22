package hackerrank;

import org.junit.Test;

import static org.junit.Assert.*;

public class PrimeTest {

    @Test
    public void testZeroAndOneArePrime() {
        assertFalse(Prime.isPrime(0));
        assertTrue(Prime.isPrime(1));

    }

    @Test
    public void testIsPrime() {
        assertTrue(Prime.isPrime(2));
        assertTrue(Prime.isPrime(3));
        assertFalse(Prime.isPrime(4));
        assertTrue(Prime.isPrime(5));
        assertFalse(Prime.isPrime(6));
        assertTrue(Prime.isPrime(7));
        assertFalse(Prime.isPrime(8));
        assertFalse(Prime.isPrime(9));
        assertFalse(Prime.isPrime(10));
        assertTrue(Prime.isPrime(11));
        assertFalse(Prime.isPrime(12));
    }

    @Test
    public void testPrimeSequences() {
        assertEquals("[1, 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97]", Prime.calculatePrimesTo(100).toString());
    }
}