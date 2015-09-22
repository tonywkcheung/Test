package hackerrank;

import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;


public class ReverseStrings {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();

        reverseString(s);
    }

    public static String reverseString(String s) {
        Stack<String> stack = new Stack<>();
        StringTokenizer stringTokenizer = new StringTokenizer(s);
        StringBuilder sb = new StringBuilder();

        while (stringTokenizer.hasMoreTokens()) {
            stack.push(stringTokenizer.nextToken());
        }

        while (!stack.empty()) {
            String str = stack.pop();
            sb.append(str).append(" ");
        }

        return sb.toString().trim();
    }
}