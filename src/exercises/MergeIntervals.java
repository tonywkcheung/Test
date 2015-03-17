package exercises;

import java.util.*;

public class MergeIntervals {

    public List<Interval> merge(List<Interval> intervals) {

        PriorityQueue<Interval> queue = new PriorityQueue<>(intervals);

        List<Interval> mergedIntervals = new ArrayList<>();

        if (intervals.size() < 1) {
            return mergedIntervals;
        }

        Interval currentInterval = queue.poll();

        while (!queue.isEmpty()) {
            Interval nextInterval = queue.poll();

            if (Interval.overlapping(currentInterval, nextInterval)) {
                Interval mergedInterval = Interval.merge(currentInterval, nextInterval);
                currentInterval = mergedInterval;
            }
            else {
                mergedIntervals.add(currentInterval);
                currentInterval = nextInterval;
            }

            if (queue.isEmpty()) {
                mergedIntervals.add(currentInterval);
            }
        }

        return mergedIntervals;
    }

}
