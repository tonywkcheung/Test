package trees.btree;

public class Node<T extends Comparable<T>> {

	T value;
	
	Node<T> left;
	Node<T> right;
	
	public Node(T value, Node<T> left, Node<T> right) {
		this.value = value;
		this.left = left;
		this.right = right;
	}

}
