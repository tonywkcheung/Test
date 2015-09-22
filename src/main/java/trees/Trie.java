package trees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import trees.TrieNode;

public class Trie {

    private Map<Character, TrieNode> root = new HashMap<Character, TrieNode>();

    public Trie() {
    }

    public Trie(List<String> initialWords) {
        for (String word : initialWords) {
            addWord(word);
        }
    }

    public void addWord(String w) {
        addWord(w.toCharArray());
    }

    public void addWord(char[] word) {
        TrieNode node;

        if (!root.containsKey(word[0])) {
            root.put(word[0], new TrieNode(word[0], "" + word[0]));
        }

        node = root.get(word[0]);

        for (int i = 1; i < word.length; i++) {
            if (node.getChild(word[i]) == null) {
                node.addChild(new TrieNode(word[i], node.getValue() + word[i]));
            }

            node = node.getChild(word[i]);
        }

        node.setIsWord(true);
    }

    public boolean containsPrefix(String prefix) {
        return contains(prefix.toCharArray(), false);
    }

    public boolean containsWord(String word) {
        return contains(word.toCharArray(), true);
    }

    public TrieNode getWord(String word) {
        TrieNode node = getNode(word.toCharArray());
        return node != null && node.isWord() ? node : null;
    }

    public TrieNode getPrefix(String prefix) {
        return getNode(prefix.toCharArray());
    }

    private boolean contains(char[] s, boolean isWord) {
        TrieNode node = getNode(s);
        return (node != null && node.isWord() && isWord)
                || (!isWord && node != null);
    }

    private TrieNode getNode(char[] chars) {
        TrieNode node = root.get(chars[0]);

        for (int i = 1; i < chars.length && node != null; i++) {
            node = node.getChild(chars[i]);

            if (node == null) {
                return null;
            }
        }

        return node;
    }

    public List<String> getMatchingWords(String subString) {

        List<String> words = new ArrayList<String>();
        TrieNode n = getPrefix(subString);

        if (n == null) {
            return null;
        }

        for (TrieNode node : getNodes(n)) {
            if (node.isWord()) {
                words.add(node.getValue());
            }
        }

        return words;
    }

    public String getLongestCommonSubstring() {
        List<TrieNode> nodes = new ArrayList<TrieNode>();
        for (TrieNode node : root.values()) {
            for (TrieNode child : node.getChildren()) {
                nodes.addAll(getNodes(child));
            }
        }

        for (TrieNode node : nodes) {
            System.out.println(node);
        }
        return null;
    }

    public List<TrieNode> getNodes(TrieNode n) {

        List<TrieNode> nodes = new ArrayList<TrieNode>();
        nodes.add(n);

        if (n != null) {
            for (TrieNode child : n.getChildren()) {
                nodes.addAll(getNodes(child));
            }
        }

        return nodes;
    }

    @Override
    public String toString() {
        return root.toString();
    }
}
