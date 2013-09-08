package exercises;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class SplitStringIntoWords {

	public static List<String> splitWord(String s, Set<String> dictionary) {

		List<String> words = new ArrayList<String>();

		if (s == null) {
			return null;
		}

		if (s.length() == 0) {
			return words;
		}

		for (int i = 1; i <= s.length(); i++) {

			String candidateWord = s.substring(0, i);

			if (dictionary.contains(candidateWord)) {
				List<String> restOfWords = splitWord(
				        s.substring(i, s.length()), dictionary);

				if (restOfWords != null) {

					words.add(candidateWord);

					if (!restOfWords.isEmpty()) {
						words.addAll(restOfWords);
					}

					return words;
				}
			}
		}

		return null;
	}

}
