package hackerrank;

import java.util.Scanner;

public class Fibonacci {

    public static boolean isFibonacci(long n) {

        if (n == 0) {
            return true;
        }

        boolean isFibonacci = false;
        long i = 0;
        long j = 1;
        long sum;

        do {
            sum = i + j;
            if (n == sum) {
                isFibonacci = true;
                break;
            }

            i = j;
            j = sum;

        } while (sum < n);

        if (isFibonacci) {
            return true;
        } else {
            return false;
        }
    }

    public static int calculateFibonacci(int n) {
        if (n == 0) {
            return 1;
        }
        else if (n == 1) {
            return 1;
        }

        return calculateFibonacci(n-1) + calculateFibonacci(n-2);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int size = Integer.parseInt(in.nextLine());

        for (int i = 0; i < size; i++) {
            long num = Long.parseLong(in.nextLine());
            isFibonacci(num);
        }
    }
}
