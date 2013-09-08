package exercises;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

public class FactorialTest {

	static Factorial factorial;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		factorial = new Factorial();
	}

	@Test
	public void testFactorial0() {
		assertEquals(1, factorial.calc(0));
	}

	@Test
	public void testFactorial5() {
		assertEquals(120, factorial.calc(5));
	}

}
