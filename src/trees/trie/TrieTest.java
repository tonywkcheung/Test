package trees.trie;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class TrieTest {
    Trie trie;

    @Before
    public void setUp() {
        trie = new Trie();

        trie.addWord("Trip");
        trie.addWord("The");
        trie.addWord("Quick");
        trie.addWord("Fox");
        trie.addWord("Jumped");
        trie.addWord("Over");
        trie.addWord("The");
        trie.addWord("Lazy");
        trie.addWord("Brown");
        trie.addWord("Cow");
        trie.addWord("Tree");
    }

    @Test
    public void containsTheWord() {
        assertTrue(trie.containsWord("The"));
    }

    @Test
    public void containsBrowPrefix() {
        assertTrue(trie.containsPrefix("Brow"));
    }

    @Test
    public void getWordsBeginningWithTr() {
        assertEquals("[Tree, Trip]", trie.getMatchingWords("Tr").toString());
    }

}
