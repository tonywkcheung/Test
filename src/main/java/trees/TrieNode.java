package trees;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class TrieNode {

    private final Character ch;
    private final String value;
    private Map<Character, TrieNode> children = new HashMap<Character, TrieNode>();
    private boolean isWord;

    public TrieNode(char ch, String value) {
        this.ch = ch;
        this.value = value;
    }

    public boolean addChild(TrieNode node) {
        if (children.containsKey(node.getChar())) {
            return false;
        }

        children.put(node.getChar(), node);
        return true;
    }

    public Collection<TrieNode> getChildren() {
        return children.values();
    }

    public String getValue() {
        return value.toString();
    }

    public char getChar() {
        return ch;
    }

    public TrieNode getChild(char c) {
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
