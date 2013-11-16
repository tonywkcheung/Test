package trees;

/**
 * This class implements a red-black tree whose nodes hold objects that
 * implement the Comparable interface.
 */
public class RedBlackTree {
    RedBlackNode root; // Package access, for testing

    static final int BLACK = 1;
    static final int RED = 0;
    private static final int NEGATIVE_RED = -1;
    private static final int DOUBLE_BLACK = 2;

    /**
     * Constructs an empty tree.
     */
    public RedBlackTree() {
        root = null;
    }

    /**
     * Inserts a new node into the tree.
     * 
     * @param obj
     *            the object to insert
     */
    @SuppressWarnings("rawtypes")
    public void add(Comparable obj) {
        RedBlackNode newNode = new RedBlackNode();
        newNode.data = obj;
        newNode.left = null;
        newNode.right = null;
        if (root == null) {
            root = newNode;
        } else {
            root.addNode(newNode);
        }
        fixAfterAdd(newNode);
    }

    /**
     * Tries to find an object in the tree.
     * 
     * @param obj
     *            the object to find
     * @return true if the object is contained in the tree
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public boolean find(Comparable obj) {
        RedBlackNode current = root;
        while (current != null) {
            int d = current.data.compareTo(obj);
            if (d == 0)
                return true;
            else if (d > 0)
                current = current.left;
            else
                current = current.right;
        }
        return false;
    }

    /**
     * Tries to remove an object from the tree. Does nothing if the object is
     * not contained in the tree.
     * 
     * @param obj
     *            the object to remove
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public void remove(Comparable obj) {
        // Find node to be removed

        RedBlackNode toBeRemoved = root;
        boolean found = false;
        while (!found && toBeRemoved != null) {
            int d = toBeRemoved.data.compareTo(obj);
            if (d == 0) {
                found = true;
            } else {
                if (d > 0) {
                    toBeRemoved = toBeRemoved.left;
                } else {
                    toBeRemoved = toBeRemoved.right;
                }
            }
        }

        if (!found) {
            return;
        }

        // toBeRemoved contains obj

        // If one of the children is empty, use the other

        if (toBeRemoved.left == null || toBeRemoved.right == null) {
            RedBlackNode newChild;
            if (toBeRemoved.left == null) {
                newChild = toBeRemoved.right;
            } else {
                newChild = toBeRemoved.left;
            }

            fixBeforeRemove(toBeRemoved);

            if (toBeRemoved.parent == null) {
                root = newChild;
            } // Found in root
            else {
                toBeRemoved.replaceWith(newChild);
            }
            return;
        }

        // Neither subtree is empty

        // Find smallest element of the right subtree

        RedBlackNode smallest = toBeRemoved.right;
        while (smallest.left != null) {
            smallest = smallest.left;
        }

        // smallest contains smallest child in right subtree

        // Move contents, unlink child

        toBeRemoved.data = smallest.data;
        fixBeforeRemove(smallest);
        smallest.replaceWith(smallest.right);
    }

    /**
     * Visits all nodes of this tree in order.
     * 
     * @param v
     *            the visitor to apply at each node
     */
    public void inOrderVisit(Visitor v) {
        inOrderVisit(root, v);
    }

    public static interface Visitor {
        /**
         * This method is called at each node.
         * 
         * @param n
         *            the visited node
         */
        void visit(RedBlackNode n);
    }

    private static void inOrderVisit(RedBlackNode n, Visitor v) {
        if (n == null)
            return;
        inOrderVisit(n.left, v);
        v.visit(n);
        inOrderVisit(n.right, v);
    }

    /**
     * Restores the tree to a red-black tree after a node has been added.
     * 
     * @param newNode
     *            the node that has been added
     */
    private void fixAfterAdd(RedBlackNode newNode) {
        if (newNode.parent == null) {
            newNode.color = BLACK;
        } else {
            newNode.color = RED;
            if (newNode.parent.color == RED) {
                fixDoubleRed(newNode);
            }
        }
    }

    /**
     * Fixes the tree so that it is a red-black tree after a node has been
     * removed.
     * 
     * @param removed
     *            the node that is to be removed
     */
    private void fixBeforeRemove(RedBlackNode removed) {
        if (removed.color == RED) {
            return;
        }

        if (removed.left != null || removed.right != null) // It is not a leaf
        {
            // Color the child black
            if (removed.left == null) {
                removed.right.color = BLACK;
            } else {
                removed.left.color = BLACK;
            }
        } else {
            bubbleUp(removed.parent);
        }
    }

    /**
     * Move a charge from two children of a parent
     * 
     * @param parent
     *            a node with two children, or null (in which case nothing is
     *            done)
     */
    private void bubbleUp(RedBlackNode parent) {
        if (parent == null) {
            return;
        }
        parent.color++;
        parent.left.color--;
        parent.right.color--;

        RedBlackNode child = parent.left;
        if (child.color == NEGATIVE_RED) {
            fixNegativeRed(child);
            return;
        } else if (child.color == RED) {
            if (child.left != null && child.left.color == RED) {
                fixDoubleRed(child.left);
                return;
            }
            if (child.right != null && child.right.color == RED) {
                fixDoubleRed(child.right);
                return;
            }
        }

        child = parent.right;
        if (child.color == NEGATIVE_RED) {
            fixNegativeRed(child);
            return;
        } else if (child.color == RED) {
            if (child.left != null && child.left.color == RED) {
                fixDoubleRed(child.left);
                return;
            }
            if (child.right != null && child.right.color == RED) {
                fixDoubleRed(child.right);
                return;
            }
        }

        if (parent.color == DOUBLE_BLACK) {
            if (parent.parent == null) {
                parent.color = BLACK;
            } else {
                bubbleUp(parent.parent);
            }
        }
    }

    /**
     * Fixes a "double red" violation.
     * 
     * @param child
     *            the child with a red parent
     */
    private void fixDoubleRed(RedBlackNode child) {
        RedBlackNode parent = child.parent;
        RedBlackNode grandParent = parent.parent;
        if (grandParent == null) {
            parent.color = BLACK;
            return;
        }
        RedBlackNode n1, n2, n3, t1, t2, t3, t4;
        if (parent == grandParent.left) {
            n3 = grandParent;
            t4 = grandParent.right;
            if (child == parent.left) {
                n1 = child;
                n2 = parent;
                t1 = child.left;
                t2 = child.right;
                t3 = parent.right;
            } else {
                n1 = parent;
                n2 = child;
                t1 = parent.left;
                t2 = child.left;
                t3 = child.right;
            }
        } else {
            n1 = grandParent;
            t1 = grandParent.left;
            if (child == parent.left) {
                n2 = child;
                n3 = parent;
                t2 = child.left;
                t3 = child.right;
                t4 = parent.right;
            } else {
                n2 = parent;
                n3 = child;
                t2 = parent.left;
                t3 = child.left;
                t4 = child.right;
            }
        }

        if (grandParent == root) {
            root = n2;
            n2.parent = null;
        } else {
            grandParent.replaceWith(n2);
        }

        n1.setLeftChild(t1);
        n1.setRightChild(t2);
        n2.setLeftChild(n1);
        n2.setRightChild(n3);
        n3.setLeftChild(t3);
        n3.setRightChild(t4);
        n2.color = grandParent.color - 1;
        n1.color = BLACK;
        n3.color = BLACK;

        if (n2 == root) {
            root.color = BLACK;
        } else if (n2.color == RED && n2.parent.color == RED) {
            fixDoubleRed(n2);
        }
    }

    /**
     * Fixes a "negative red" violation.
     * 
     * @param negRed
     *            the negative red node
     */
    @SuppressWarnings("rawtypes")
    private void fixNegativeRed(RedBlackNode negRed) {
        RedBlackNode n1, n2, n3, n4, t1, t2, t3, child;
        RedBlackNode parent = negRed.parent;
        if (parent.left == negRed) {
            n1 = negRed.left;
            n2 = negRed;
            n3 = negRed.right;
            n4 = parent;
            t1 = n3.left;
            t2 = n3.right;
            t3 = n4.right;
            n1.color = RED;
            n2.color = BLACK;
            n4.color = BLACK;
            n2.setRightChild(t1);
            Comparable temp = n4.data;
            n4.data = n3.data;
            n3.data = temp;
            n3.setLeftChild(t2);
            n3.setRightChild(t3);
            n4.setRightChild(n3);
            child = n1;
        } else {
            n4 = negRed.right;
            n3 = negRed;
            n2 = negRed.left;
            n1 = parent;
            t3 = n2.right;
            t2 = n2.left;
            t1 = n1.left;
            n4.color = RED;
            n3.color = BLACK;
            n1.color = BLACK;
            n3.setLeftChild(t3);
            Comparable temp = n1.data;
            n1.data = n2.data;
            n2.data = temp;
            n2.setRightChild(t2);
            n2.setLeftChild(t1);
            n1.setLeftChild(n2);
            child = n4;
        }

        if (child.left != null && child.left.color == RED) {
            fixDoubleRed(child.left);
            return;
        }
        if (child.right != null && child.right.color == RED) {
            fixDoubleRed(child.right);
        }
    }

}
