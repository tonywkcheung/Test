package exercises;

import java.util.ArrayList;
import java.util.List;


public class PrimeNumbers {
    public List<Integer> getPrimes(int n) {
        boolean[] nonPrimes = new boolean[n+1];

        for (int i=2; i<=(n/2); i++) {
            for (int j=(2*i); j<=n; j=j+i){
                nonPrimes[j] = true;
            }
        }

        List results = new ArrayList<>();
        for (int i=2; i<=n; i++) {
            if (!nonPrimes[i]) {
                results.add(i);
            }
        }

        return results;
    }


    public static void main(String[] args) {
        PrimeNumbers primeNumbers = new PrimeNumbers();

        List<Integer> primes = primeNumbers.getPrimes(97);

        System.out.println(primes);
    }

}
