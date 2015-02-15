package hackerrank;

import java.util.Scanner;

public class LCS {

    public static int findCommonChild(String left, String right) {
        if (left == null || left.length() == 0 || right == null || right.length() == 0) {
            return 0;
        }

        int[][] array = new int[left.length()+1][right.length()+1];

        for (int i = 0; i <= left.length(); i++) {
            for (int j = 0; j <= right.length(); j++) {

                if (i == 0 || j == 0) {
                    array[i][j] = 0;
                }
                else if (left.charAt(i-1) == right.charAt(j-1)) {
                    array[i][j] = array[i-1][j-1] + 1;
                }
                else {
                    array[i][j] = Math.max(array[i-1][j], array[i][j-1]);
                }
            }
        }

        for (int i = 0; i < left.length(); i++) {
            for (int j = 0; j < right.length(); j++) {

                System.out.print(array[i][j] + " ");
            }
            System.out.println("");
        }

        return array[left.length()][right.length()];
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String left = in.nextLine();
        String right = in.nextLine();

        int commonChild = findCommonChild(left, right);
        System.out.println(commonChild);
    }
}
