package exercises;

public class ChooseNFromK {
    Factorial factorial = new Factorial();

    public long calc(long n, long k) {
        return factorial.calc(n) / (factorial.calc(k) * factorial.calc(n - k));
    }
}
