package exercises;

import java.util.HashSet;
import java.util.Set;

public class OverLappingIntervals {

    public Set<Interval> getIntersection(Set<Interval> intervals) {
        Set<Interval> overlappingIntervals = new HashSet<>();

        for (Interval a : intervals) {
            for (Interval b : intervals) {
                if (a != b) {
                    if (a.start < b.start && a.end > b.start) {
                        Interval overlapInterval = new Interval(b.start, a.end);
                        overlappingIntervals.add(overlapInterval);
                    }
                }
            }
        }
        return overlappingIntervals;
    }
}
