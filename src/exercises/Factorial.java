package exercises;

public class Factorial {
	public long calc(long n) {
		if (n == 0) {
			return 1;
		}
		else {
			return n * calc(n-1);
		}
	}
}
