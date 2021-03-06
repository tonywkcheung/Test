package trees;

/**
 * A node of a red-black tree stores a data item and references of the child
 * nodes to the left and to the right. The color is the "cost" of passing the
 * node; 1 for black or 0 for red. Temporarily, it may be set to 2 or -1.
 */
public class RedBlackNode {
    @SuppressWarnings("rawtypes")
    public Comparable data;
    public RedBlackNode left;
    public RedBlackNode right;
    public RedBlackNode parent;
    public int color;

    /**
     * Constructs a red node with no data.
     */
    public RedBlackNode() {
    }

    /**
     * Sets the left child and updates its parent pointer.
     * 
     * @param child
     *            the new left child
     */
    public void setLeftChild(RedBlackNode child) {
        left = child;
        if (child != null) {
            child.parent = this;
        }
    }

    /**
     * Sets the right child and updates its parent pointer.
     * 
     * @param child
     *            the new right child
     */
    public void setRightChild(RedBlackNode child) {
        right = child;
        if (child != null) {
            child.parent = this;
        }
    }

    /**
     * Updates the parent's and replacement node's links when this node is
     * replaced.
     * 
     * @param replacement
     *            the node that replaces this node
     */
    public void replaceWith(RedBlackNode replacement) {
        if (parent == null)
            return;
        if (this == parent.left)
            parent.setLeftChild(replacement);
        else
            parent.setRightChild(replacement);
    }

    /**
     * Inserts a new node as a descendant of this node.
     * 
     * @param newNode
     *            the node to insert
     */
    @SuppressWarnings("unchecked")
    public void addNode(RedBlackNode newNode) {
        int comp = newNode.data.compareTo(data);
        if (comp < 0) {
            if (left == null) {
                left = newNode;
                left.parent = this;
            } else {
                left.addNode(newNode);
            }
        } else if (comp > 0) {
            if (right == null) {
                right = newNode;
                right.parent = this;
            } else {
                right.addNode(newNode);
            }
        }
    }
}
