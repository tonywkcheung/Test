package exercises;

import java.util.ArrayList;
import java.util.List;


public class RabinKarp {
    public int findSubstring(String str, String subString) {

        int targetHash = hash(subString);
        int targetLen = subString.length();
        int currentHash = hash(str.substring(0, targetLen));

        System.out.println(targetHash + " " + subString.substring(0, targetLen));
        //System.out.println(currentHash + " " + str.substring(0, targetLen));

        if (currentHash == targetHash) {
            return 0;
        }

        int index = -1;
        for (int i = 1; i<=str.length()- targetLen; i++) {
            currentHash -= str.charAt(i-1) - 'A';
            currentHash += str.charAt(i+targetLen-1) - 'A';

            //currentHash = hash(str.substring(i, i+targetLen));
            //System.out.println(currentHash + " " + str.substring(i, i+targetLen));

            if (currentHash == targetHash) {
                if (subString.equals(str.substring(i, i+targetLen))) {
                    index = i;
                    break;
                }
            }
        }

        return index;
    }

    private int hash(String s) {
        int h = 1;
        for (int i=0; i<s.length(); i++) {
            h += s.charAt(i) - 'A';
        }

        return h;
    }


    public static void main(String[] args) {
        RabinKarp rabinKarp = new RabinKarp();
        //                                   0123456789012345678901
        int index = rabinKarp.findSubstring("a needle in a haystack!!", "haystack");

        System.out.println(index);
    }

}
