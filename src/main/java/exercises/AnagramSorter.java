package exercises;

import java.util.*;

public class AnagramSorter {
    public Collection<Set<String>> sortAnagrams(List<String> strings) {

        if (strings == null) {
            return Collections.EMPTY_SET;
        }

        Map<String, Set<String>> map = new HashMap<>();
        for (String s : strings) {
            if (s==null) {
                continue;
            }
            char[] array = s.toCharArray();
            Arrays.sort(array);
            String key = new String(array);
            Set set = map.getOrDefault(key, new HashSet<>());
            set.add(s);
            map.put(key, set);
        }
        return map.values();
    }
}
