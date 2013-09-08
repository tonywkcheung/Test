package exercises;

import java.util.HashSet;
import java.util.Set;

public class Runs {
	
	public int countPermutationsWithSameNumberOfRuns(String str) {
		if (str == null || str.length() < 2) {
			return 0;
		}

		int runCount = runCount(str);
		Set<String> words = generatePermutations(str);
		
		int count =0;
		for (String word : words) {
			if (runCount == (runCount(word))) {
				count++;
			}
		}
		
		return count;
	}
	
	public Set<String> generatePermutations(String s) {
		Set<String> set = new HashSet<String>();		
		permutation("", s, set);		
		return set;
	}
	
	private static void permutation(String prefix, String str, Set<String> set) {
	    int n = str.length();
	    if (n == 0) {
	    	//System.out.format("%s\n", prefix);
	    	set.add(prefix);
	    }
	    else {
	        for (int i = 0; i < n; i++) {
	            //System.out.format("%s:%c:%s:%s:%d\n", prefix, str.charAt(i), str.substring(0, i), str.substring(i+1, n),i);
	            permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, n), set);
	        }
	    }
	}
	
	public int runCount(String s) {
		if (s == null || s.length() < 2) {
			return 0;
		}
		
		int run = 0;
		char previousChar = '\0';
		for (int i=0; i<s.length(); i++) {
			char currentChar = s.charAt(i);
			
			if (currentChar != previousChar) {
				run++;
			}
			previousChar = currentChar;
		}
		
		return run;
	}
}
