package trees.trie;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Node {

	private final Character ch;
	private final String value;
	private Map<Character, Node> children = new HashMap<Character, Node>();
	private boolean isWord;

	public Node(char ch, String value) {
		this.ch = ch;
		this.value = value;
	}

	public boolean addChild(Node node) {
		if (children.containsKey(node.getChar())) {
			return false;
		}

		children.put(node.getChar(), node);
		return true;
	}

	public Collection<Node> getChildren() {
		return children.values();
	}

	public String getValue() {
		return value.toString();
	}

	public char getChar() {
		return ch;
	}

	public Node getChild(char c) {
		return children.get(c);
	}

	public boolean isWord() {
		return isWord;
	}

	public void setIsWord(boolean isWord) {
		this.isWord = isWord;
	}

	@Override
	public String toString() {
		return value;
	}
}
