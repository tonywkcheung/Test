package exercises;

import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static exercises.OverLappingIntervals.*;
import static org.junit.Assert.assertEquals;

public class OverLappingIntervalsTest {

    private OverLappingIntervals overLappingIntervals;

    @Before
    public void setUp() {
        overLappingIntervals = new OverLappingIntervals();
    }

    @Test
    public void firstTest() {
        //[0-20], [15-40], and [25-50]
        HashSet<Interval> intervals = new HashSet<>();

        intervals.add(new Interval(0,20));
        intervals.add(new Interval(15,40));
        intervals.add(new Interval(25,50));

        Set<Interval> overlappingIntervals = overLappingIntervals.getIntersection(intervals);
        assertEquals("[[25, 40], [15, 20]]", overlappingIntervals.toString());
    }

    @Test
    public void noOverlaps() {

        HashSet<Interval> intervals = new HashSet<>();

        intervals.add(new Interval(0,10));
        intervals.add(new Interval(10,40));
        intervals.add(new Interval(40,50));

        Set<Interval> overlappingIntervals = overLappingIntervals.getIntersection(intervals);
        assertEquals("[]", overlappingIntervals.toString());
    }
}