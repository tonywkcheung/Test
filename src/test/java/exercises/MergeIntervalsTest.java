package exercises;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class MergeIntervalsTest {

    private MergeIntervals mergeIntervals;

    @Before
    public void setUp() {
        mergeIntervals = new MergeIntervals();
    }

    @Test
    public void mergeIntervalsExample1() {
        List<Interval> intervals = new ArrayList<>();

        //[(0, 1), (3, 5), (4, 8), (10, 12), (9, 10)]
        intervals.add(new Interval(0,1));
        intervals.add(new Interval(3,5));
        intervals.add(new Interval(4,8));
        intervals.add(new Interval(10,12));
        intervals.add(new Interval(9,10));

        List<Interval> mergedIntervals = mergeIntervals.merge(intervals);
        assertEquals("[[0, 1], [3, 8], [9, 12]]", mergedIntervals.toString());
    }

    @Test
    public void mergeIntervalsExample2() {
        List<Interval> intervals = new ArrayList<>();

        intervals.add(new Interval(1,2));
        intervals.add(new Interval(2,3));


        List<Interval> mergedIntervals = mergeIntervals.merge(intervals);
        assertEquals("[[1, 3]]", mergedIntervals.toString());
    }

    @Test
    public void mergeIntervalsExample3() {
        List<Interval> intervals = new ArrayList<>();

        intervals.add(new Interval(1,5));
        intervals.add(new Interval(2,3));


        List<Interval> mergedIntervals = mergeIntervals.merge(intervals);
        assertEquals("[[1, 5]]", mergedIntervals.toString());
    }

    @Test
    public void mergeIntervalsExample4() {
        List<Interval> intervals = new ArrayList<>();

        //[(1, 10), (2, 6), (3, 5), (7,9)]
        intervals.add(new Interval(1,10));
        intervals.add(new Interval(2,6));
        intervals.add(new Interval(3,5));
        intervals.add(new Interval(7,9));

        List<Interval> mergedIntervals = mergeIntervals.merge(intervals);
        assertEquals("[[1, 10]]", mergedIntervals.toString());
    }

}