package exercises;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TopCoder {
	public String findBestSeller(String[] items) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		int highestSales = 0;
		String bestSeller = null;
		
		Arrays.sort(items);
		for (String s : items) {
			Integer i = 0;
			if (map.containsKey(s)) {
				i = map.get(s);
			}
			map.put(s, ++i);

			if (i > highestSales) {
				highestSales = i;
				bestSeller = s;
			}
		}
		
		return bestSeller;
	}
}
