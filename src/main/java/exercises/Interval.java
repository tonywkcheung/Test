package exercises;

public class Interval implements Comparable {
    final public int start;
    final public int end;

    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public String toString() {
        return String.format("[%d, %d]", start, end);
    }

    @Override
    public int compareTo(Object o) {
        return Integer.compare(this.start, ((Interval) o).start);
    }

    public static boolean overlapping(Interval a, Interval b) {
        if (a.start <= b.start && a.end >= b.start) {
            return true;
        }

        if (a.end == b.start) {
            return true;
        }

        return false;
    }

    public static Interval merge(Interval a, Interval b) {
        return new Interval(Math.min(a.start, b.start), Math.max(a.end, b.end));
    }

}
