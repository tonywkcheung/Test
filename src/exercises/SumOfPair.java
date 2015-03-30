package exercises;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SumOfPair {
    public Map<Integer, Integer> getPairs(int[] ints, int sum) {
        Map<Integer, Integer> results = new HashMap<>();
        Set<Integer> numbers = new HashSet<>();
        for (int value : ints) {
            if (value <= sum) {
                if (numbers.contains(sum - value)) {
                    results.put(value, sum - value);
                }
                numbers.add(value);
            }
        }
        return results;
    }
}
