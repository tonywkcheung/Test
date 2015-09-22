package exercises;

import java.util.ArrayList;
import java.util.List;

public class Countdown {

    final int SIZE = 9;
    private Dictionary dictionary;
    
    public String solve(String s) {
        
        if (s == null || s.length() != SIZE) {
            return null;
        }
        
        List<String> possibleSolutions = generateSolutions("", s);
        for (String possibleSolution : possibleSolutions) {
            if (checkWord(possibleSolution)) {
                return possibleSolution;
            }
        }
        
        return null;
    }

    public String longestWord(String s) {
        
        if (s == null || s.length() != SIZE) {
            return null;
        }
        
        List<String> possibleSolutions = generateSolutions("", s);

        for (int i=0; i<SIZE; i++) {
            for (String possibleSolution : possibleSolutions) {
                if (checkWord(possibleSolution.substring(0, SIZE-i))) {
                    return possibleSolution.substring(0, SIZE-i);
                }
            }
        }
        
        return null;
    }

    private List<String> generateSolutions(String prefix, String str) {
        List<String> words = new ArrayList<>();
        
        int len = str.length();
        if (len == 0) {
            words.add(prefix);
        } else {
            for (int i = 0; i < len; i++) {
                words.addAll(generateSolutions(prefix + str.charAt(i),
                        str.substring(0, i) + str.substring(i + 1, len)));
            }
        }
        return words;
    }

    public boolean checkWord(String word){
        if (dictionary == null) {
            dictionary = new Dictionary();
            dictionary.load("/Users/tonycheung/workspace/Test/data/5desk.txt");
        }
        
        return dictionary.checkWord(word);
    }
}
