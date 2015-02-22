package exercises;

import org.junit.Test;

import static org.junit.Assert.*;

public class SumOfPairTest {
    private SumOfPair sumOfPair = new SumOfPair();

    @Test
    public void firstTest() {
        int[] intArray = new int[] {1,5,13,0,3,8,6,2};

        assertEquals("{5=1, 6=0}", sumOfPair.getPairs(intArray, 6).toString());
    }
}