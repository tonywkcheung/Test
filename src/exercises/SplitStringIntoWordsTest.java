
package exercises;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;


public class SplitStringIntoWordsTest {

	@Test
	public void splitPeanutButterSuccessfully() {
		
		Set<String> dictionary = new HashSet<String>();
		dictionary.add("peanut");
		dictionary.add("butter");
		String peanutButter = "peanutbutter";
		
		List<String> words = SplitStringIntoWords.splitWord(peanutButter, dictionary);

		assertEquals(2, words.size());
		assertEquals("peanut", words.get(0));
		assertEquals("butter", words.get(1));
	}

	@Test
	public void splitPeanutButterJellySuccessfully() {
		
		Set<String> dictionary = new HashSet<String>();
		dictionary.add("peanut");
		dictionary.add("butter");
		dictionary.add("jelly");
		dictionary.add("jel");
		String peanutButterJelly = "peanutbutterjelly";
		
		List<String> words = SplitStringIntoWords.splitWord(peanutButterJelly, dictionary);

		assertEquals(3, words.size());
		assertEquals("peanut", words.get(0));
		assertEquals("butter", words.get(1));
		assertEquals("jelly", words.get(2));
	}

	@Test
	public void splitPeanutButterJellyXxxUnsuccessfully() {
		
		Set<String> dictionary = new HashSet<String>();
		dictionary.add("peanut");
		dictionary.add("butter");
		dictionary.add("jelly");

		String peanutButterJelly = "peanutbutterjellyxxx";
		List<String> words = SplitStringIntoWords.splitWord(peanutButterJelly, dictionary);

		assertNull(words);
	}

	@Test
	public void splitPeanutButterUnsuccessfully() {
		
		Set<String> dictionary = new HashSet<String>();
		dictionary.add("peanut");
		dictionary.add("butt");
		dictionary.add("butter");
		
		String peanutButter = "peanutbutter";
		List<String> words = SplitStringIntoWords.splitWord(peanutButter, dictionary);

		assertNotNull(words);
		assertEquals(2, words.size());
		assertEquals("peanut", words.get(0));
		assertEquals("butter", words.get(1));
	}

}
