package trees.trie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Trie {

	private Map<Character, Node> root = new HashMap<Character, Node>();

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
		Node node = null;

		if (!root.containsKey(word[0])) {
			root.put(word[0], new Node(word[0], "" + word[0]));
		}

		node = root.get(word[0]);

		for (int i = 1; i < word.length; i++) {
			if (node.getChild(word[i]) == null) {
				node.addChild(new Node(word[i], node.getValue() + word[i]));
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

	public Node getWord(String word) {
		Node node = getNode(word.toCharArray());
		return node != null && node.isWord() ? node : null;
	}

	public Node getPrefix(String prefix) {
		return getNode(prefix.toCharArray());
	}

	private boolean contains(char[] s, boolean isWord) {
		Node node = getNode(s);
		return (node != null && node.isWord() && isWord)
		        || (!isWord && node != null);
	}

	private Node getNode(char[] chars) {
		Node node = root.get(chars[0]);

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
		Node n = getPrefix(subString);

		if (n == null) {
			return null;
		}

		for (Node node : getNodes(n)) {
			if (node.isWord()) {
				words.add(node.getValue());
			}
		}

		return words;
	}

	public String getLongestCommonSubstring() {
		List<Node> nodes = new ArrayList<Node>();
		for (Node node : root.values()) {
			for (Node child : node.getChildren()) {
				nodes.addAll(getNodes(child));
			}
		}

		for (Node node : nodes) {
			System.out.println(node);
		}
		return null;
	}

	public List<Node> getNodes(Node n) {

		List<Node> nodes = new ArrayList<Node>();
		nodes.add(n);

		if (n != null) {
			for (Node child : n.getChildren()) {
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
