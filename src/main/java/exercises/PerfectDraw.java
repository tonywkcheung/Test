package exercises;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PerfectDraw {
    private static List<Character> perfectDraw(String str) {

        List<Character> chars = new ArrayList<>();
        char[] array = str.toCharArray();
        Random random = new Random();
        for (int i = str.length()-1; i >= 0; i--) {
            int rand = random.nextInt(i+1);
            char temp = array[rand];
            array[rand] = array[i];
            array[i] = temp;
            chars.add(array[i]);
        }
        return chars;
    }

    public static void main(String[] args) {
        List<Character> cards = perfectDraw("23456789TJQKA");
        System.out.println(cards);
    }

}
