package exercises;


public class LongestCommonSubstring {
	
	static String longestCommonSubstring(String left, String right)
	{
		if (left == null || right == null) {
			return null;
		}
		
		if (left.length() == 0 || right.length() == 0) {
			return null;
		}
		
	    int Start = 0;
	    int Max = 0;
	    for (int i = 0; i < left.length(); i++)
	    {
	        for (int j = 0; j < right.length(); j++)
	        {
	            int x = 0;
	            while (left.charAt(i + x) == right.charAt(j + x))
	            {
	                x++;
	                if (((i + x) >= left.length()) || ((j + x) >= right.length())) break;
	            }
	            if (x > Max)
	            {
	                Max = x;
	                Start = i;
	            }
	         }
	    }
	    return left.substring(Start, (Start + Max));
	}
/*	
	public static String longestCommonSubstring(String left, String right) {
		
		if (left == null || right == null) {
			return null;
		}
		
		if (left.length() == 0 || right.length() == 0) {
			return null;
		}
		
		String pattern = (left.length() >= right.length()) ? right : left;
		String text = (left.length() >= right.length()) ? left : right;
		
		List<String> candidateSubstrings = getSubstrings(pattern);
		
		for (String s : candidateSubstrings) {
			if (text.contains(s)) {
				return s;
			}
		}

		return null;
	}

	private static List<String> getSubstrings(final String pattern) {
		int length = pattern.length();
		
		List<String> substrings = new ArrayList<String>();
		
		for (int i=length; i>0; i--) {
			int offset = 0;
			while ((offset + i) <= length) {
				String substring = pattern.substring(offset, i+offset);
				substrings.add(substring);
				//System.out.format("%s %s %d %d\n",pattern, substring, offset, i );
				offset++;
			}
		}
		
		return substrings;
	}
	*/
}
