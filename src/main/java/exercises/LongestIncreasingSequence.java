package exercises;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;


public class LongestIncreasingSequence {

    int[] values;
    int[] parent;
    int[] length;
    
    public void initialise(int[] v) {
        values = v;
        parent = new int[values.length];
        length = new int[values.length];
        
        for (int i=0;i<values.length; i++) {
            // initialize parent and length
            parent[i] = -1;
            length[i] = 0;
        }
        length[0] = 1;
    }
    
    public Collection<Integer> solve() {
        
        for (int i=1;i<values.length; i++) {
            for (int j=i-1; j>=0; j--) {
                if (values[i] > values[j] && length[i] < length[j]) {
                    parent[i] = j;
                    length[i] = length[j]+1;
                }
            }            
        }
        
        // find highest
        int max = 0;
        int maxIdx = 0;
        for (int i=0; i<values.length; i++) {
            if (max < length[i]) {
                max = length[i];
                maxIdx = i;
            }
        }

        List<Integer> result = new ArrayList<>();

        // loop back and construct sequence
        int index = maxIdx;
        while (index >= 0) {
            result.add(values[index]);
            index = parent[index]; 
        }

        Collections.reverse(result);
        
        return result;
    }
}
