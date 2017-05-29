package exercises;

import java.util.ArrayList;
import java.util.List;

public class Combinations {

    public List<String> getCombinations(String str) {
        return getCombinations("", str);
    }

    private List<String> getCombinations(String prefix, String postfix) {

        List combinations = new ArrayList<>();

        if (postfix.length() == 1) {
            combinations.add(prefix + postfix);
            return combinations;
        }

        for (int i=0; i<postfix.length(); i++) {
            String s1 = postfix.substring(i, i+1);
            String s2 = postfix.substring(0, i) + postfix.substring(i+1);
            combinations.addAll(getCombinations(prefix+s1, s2));
        }

        return combinations;
    }

    public static void main(String[] args) {
        Combinations combinations = new Combinations();
        List<String> combinationList = combinations.getCombinations("TONY");
        System.out.println(combinationList);
    }
}
