package exercises;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Set;

import org.junit.Test;

public class RunsTest {

	Runs runs = new Runs();

	@Test
	public void totalCountForAabcdIs24() {
		assertEquals(24, runs.countPermutationsWithSameNumberOfRuns("aabcd"));
	}

	@Test
	public void totalCountForBookkeeperIs7200() {
		assertEquals(7200,
		        runs.countPermutationsWithSameNumberOfRuns("bookkeeper"));
	}

	@Test
	public void countRunsForZookeeperIs7() {
		assertEquals(7, runs.runCount("zookeeper"));
	}

	@Test
	public void countRunsForAabcdIs4() {
		assertEquals(4, runs.runCount("aabcd"));
	}

	@Test
	public void generatePermutationsForAbc() {
		Set<String> words = runs.generatePermutations("ABC");
		assertEquals(6, words.size());
		assertTrue(words.contains("BCA"));
	}

	@Test
	public void generatePermutationsForZookeeper() {
		Set<String> words = runs.generatePermutations("zookeeper");
		assertEquals(30240, words.size());
		assertTrue(words.contains("zookeeper"));
	}
}
