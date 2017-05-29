package exercises;


import java.util.*;
import java.util.concurrent.SynchronousQueue;

public class NumberProduct {

    public static List<List<Integer>> NumberProduct(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Set<Integer> seen = new HashSet<>();

        if (nums.length == 0) {
            return Collections.emptyList();
        }

        seen.add(nums[0]);
        for (int i=1; i<nums.length; i++) {
            if (seen.contains(target - nums[i])) {
                List<Integer> pair = new ArrayList<>();
                pair.add(target - nums[i]);
                pair.add(nums[i]);
                result.add(pair);
            }
            seen.add(nums[i]);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {1,2,5,6,7,3,9,11,14,24};

        List<List<Integer>> result = NumberProduct(nums, 13);

        System.out.println(result);
    }
}
