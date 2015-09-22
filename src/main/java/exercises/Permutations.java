package exercises;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
    public List<String> getPermutations(String input) {

        return getPermutations("", input);

    }

    public List<String> getPermutations(String prefix, String str) {
        List<String> words = new ArrayList<>();

        int len = str.length();
        if (len == 0) {
            words.add(prefix);
        }
        else {
            for (int i = 0; i < len; i++) {
                words.addAll(getPermutations(prefix + str.charAt(i),
                        str.substring(0, i) + str.substring(i + 1, len)));
            }
        }

        return words;

    }

    public static void main(String[] args) {
        Permutations p = new Permutations();
        List<String> words = p.getPermutations("llama");
        for (String word : words) {
            System.out.println(word);
        }
    }
}
