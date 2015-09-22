package exercises;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class IntervalTest {

    @Test
    public void isOverlapping() {
        assertTrue(Interval.overlapping(new Interval(3,5),new Interval(4,8) ));
        assertTrue(Interval.overlapping(new Interval(9,10),new Interval(10,12) ));

    }

    @Test
    public void notOverlapping() {
        assertFalse(Interval.overlapping(new Interval(3, 5), new Interval(7, 8)));
    }
}