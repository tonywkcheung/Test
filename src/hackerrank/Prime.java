package hackerrank;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Prime {

    public static boolean isPrime(long num) {

        if (num == 0) {
            return false;
        }
        else if (num == 1) {
            return true;
        }
        else {
            int sqrt = (int) Math.sqrt(num);
            for (int i=2; i<=sqrt; i++){
                if (num % i == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    public static List<Integer> calculatePrimesTo(int n) {
        boolean[] array = new boolean[n+1];

        for (int i=2; i<= (n/2); i++) {
            for (int j=0; j<=n; j+=i) {
                if (j > i) {
                    array[j] = true;
                }
            }
        }

        List<Integer> primes = new ArrayList<>();
        primes.add(1);
        for (int i=2; i<=n; i++) {
            if (!array[i]) {
                primes.add(i);
            }
        }

        return primes;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int size = Integer.parseInt(in.nextLine());

        for (int i = 0; i < size; i++) {
            long num = Long.parseLong(in.nextLine());
            isPrime(num);
        }
    }
}
