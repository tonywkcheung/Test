package exercises;

import static org.junit.Assert.*;

import org.junit.Test;

public class BitManipulationTest {

	@Test
	public void shiftLeft() {
		int i = 1 << 2;
		System.out.println("i:" + Integer.toBinaryString(i));
		assertEquals(i, 4);
	}

	@Test
	public void shiftRight() {
		int i = 8 >> 1;
		System.out.println("i:" + Integer.toBinaryString(i));
		assertEquals(i, 4);
	}

	// 128 64 32 16 8 4 2 1
	// 0 1 1 0 0 1 0 0
	// 1 1 1 0 0 0 0 0
	@Test
	public void bitAndMask() {
		int mask = -1 << 4;
		int i = 100 & mask;
		System.out.println("mask:" + Integer.toBinaryString(mask));
		System.out.println("100:" + Integer.toBinaryString(100));
		assertEquals(96, i);
	}

	@Test
	public void bitOrMask() {
		int mask = 1 << 4;
		int i = 100 | mask;
		System.out.println("mask:" + Integer.toBinaryString(mask));
		System.out.println("100:" + Integer.toBinaryString(100));
		assertEquals(116, i);
	}

	@Test
	public void bitXorMask() {
		int mask = 1 << 4;
		int i = 17 ^ mask;
		System.out.println("mask:" + Integer.toBinaryString(mask));
		System.out.println("17:" + Integer.toBinaryString(17));
		assertEquals(1, i);
	}

	@Test
	public void bitApplyMask() {
		int max = ~0;
		int i = 2;
		int j = 6;
		int left = max - ((1 << j) - 1);
		int right = ((1 << i) - 1);
		int mask = left | right;
		System.out.println("max:   " + Integer.toBinaryString(max));
		System.out.println("left:  " + Integer.toBinaryString(left));
		System.out.println("right: " + Integer.toBinaryString(right));
		System.out.println("mask:  " + Integer.toBinaryString(mask));
	}

}
