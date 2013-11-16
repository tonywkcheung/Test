package trees;

public class BTreeNode<T extends Comparable<T>> {

    T value;

    BTreeNode<T> left;
    BTreeNode<T> right;

    public BTreeNode(T value, BTreeNode<T> left, BTreeNode<T> right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

}
