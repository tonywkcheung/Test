package exercises;

import static org.junit.Assert.*;

import java.util.Collection;

import org.junit.Test;

public class LongestIncreasingSequenceTest {

    @Test
    public void testLongestIncreasingSequence() {
        
        int[] values = {2,4,3,5,1,7,6,9,8};

        LongestIncreasingSequence longestIncreasingSequence = new LongestIncreasingSequence();
        
        longestIncreasingSequence.initialise(values);
        
        Collection<Integer> sequence = longestIncreasingSequence.solve();
        
        assertNotNull(sequence);
        assertEquals(5,sequence.size());
        
        System.out.println("longest increasing sequence is " + sequence);

        int previous = -1;
        for (Integer i : sequence) {
            if (i.intValue() <= previous) {
                fail("Not in increasing order");
            }
        }
    }
}
