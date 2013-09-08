package exercises;

import static org.junit.Assert.*;

import org.junit.Test;

public class LongestCommonSubstringTest {

	@Test
	public void testLongestSubstringBetweenPeaAndPeanut() {
		assertEquals("pea", LongestCommonSubstring.longestCommonSubstring("pea","peanut"));
		assertEquals("pea", LongestCommonSubstring.longestCommonSubstring("peanut","pea"));
	}

	@Test
	public void testLongestSubstringBetweenPeaAndNull() {
		assertEquals(null, LongestCommonSubstring.longestCommonSubstring("pea",null));
		assertEquals(null, LongestCommonSubstring.longestCommonSubstring(null,"pea"));
	}

	@Test
	public void testLongestSubstringBetweenPeaAndEmptyString() {
		assertEquals(null, LongestCommonSubstring.longestCommonSubstring("pea",""));
		assertEquals(null, LongestCommonSubstring.longestCommonSubstring("","pea"));
	}

	@Test
	public void testLongestSubstringBetweenBikeAndMotorBike() {
		assertEquals("bike", LongestCommonSubstring.longestCommonSubstring("bike","motorbike"));
		assertEquals("bike", LongestCommonSubstring.longestCommonSubstring("motorbike","bike"));
	}

	@Test
	public void testLongestSubstringBetweenScopeAndBadCop() {
		assertEquals("cop", LongestCommonSubstring.longestCommonSubstring("scope","badcop"));
		assertEquals("cop", LongestCommonSubstring.longestCommonSubstring("badcop","scope"));
	}

}
