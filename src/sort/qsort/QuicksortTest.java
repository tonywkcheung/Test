package sort.qsort;

import java.util.Arrays;
import java.util.Random;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class QuicksortTest {

	private Integer[] numbers;
	private final static int SIZE = 7;
	private final static int MAX = 20;

	@Before
	public void setUp() throws Exception {
		numbers = new Integer[SIZE];
		Random generator = new Random();
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = generator.nextInt(MAX);
		}
	}

	@Test
	public void testNull() {
		Quicksort<Integer> qsort = new Quicksort<Integer>();
		qsort.sort(null);
	}

	@Test
	public void testEmpty() {
		Quicksort<Integer> qsort = new Quicksort<Integer>();
		qsort.sort(new Integer[0]);
	}

	@Test
	public void testSimpleElement() {
		Quicksort<Integer> qsort = new Quicksort<Integer>();
		Integer[] test = new Integer[1];
		test[0] = 5;
		qsort.sort(test);
	}

	@Test
	public void testSpecial() {
		Quicksort<Integer> qsort = new Quicksort<Integer>();
		Integer[] test = { 5, 5, 6, 6, 4, 4, 5, 5, 4, 4, 6, 6, 5, 5 };
		qsort.sort(test);
		if (!validate(test)) {
			fail("Should not happen");
		}
		printResult(test);
	}

	@Test
	public void testQuickSort() {
		for (Integer i : numbers) {
			System.out.println(i + " ");
		}
		long startTime = System.currentTimeMillis();

		Quicksort<Integer> qsort = new Quicksort<Integer>();
		qsort.sort(numbers);

		long stopTime = System.currentTimeMillis();
		long elapsedTime = stopTime - startTime;
		System.out.println("Quicksort " + elapsedTime);

		if (!validate(numbers)) {
			fail("Should not happen");
		}
		assertTrue(true);
	}

	@Test
	public void testStandardSort() {
		long startTime = System.currentTimeMillis();
		Arrays.sort(numbers);
		long stopTime = System.currentTimeMillis();
		long elapsedTime = stopTime - startTime;
		System.out.println("Standard Java sort " + elapsedTime);
		if (!validate(numbers)) {
			fail("Should not happen");
		}
		assertTrue(true);
	}

	@Test
	public void testStrings() {
		Quicksort<String> qsort = new Quicksort<String>();
		String[] test = { "Bravo", "Alpha", "Foxtrot" };
		qsort.sort(test);

		printResult(test);
	}

	private boolean validate(Integer[] numbers) {
		for (int i = 0; i < numbers.length - 1; i++) {
			if (numbers[i] > numbers[i + 1]) {
				return false;
			}
		}
		return true;
	}

	private void printResult(Object[] objects) {
		for (int i = 0; i < objects.length; i++) {
			System.out.print(objects[i]);
		}
		System.out.println(objects);
	}
} 
