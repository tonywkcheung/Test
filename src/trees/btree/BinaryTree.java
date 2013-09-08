package trees.btree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class BinaryTree<T extends Comparable<T>> {

    Node<T> root;
    List<T> path;
    int size = 0;

    public void insert(T value) {

        Node<T> newNode = new Node<T>(value, null, null);

        if (root == null) {
            root = newNode;
        } else {
            Node<T> currentNode = root;

            while (true) {
                if (value.compareTo(currentNode.value) < 0) {
                    if (currentNode.left == null) {
                        currentNode.left = newNode;
                        break;
                    } else {
                        currentNode = currentNode.left;
                    }
                } else {
                    if (currentNode.right == null) {
                        currentNode.right = newNode;
                        break;
                    } else {
                        currentNode = currentNode.right;
                    }
                }
            }
        }

        size++;
    }

    public boolean exists(T value) {

        if (root == null) {
            return false;
        } else {
            Node<T> currentNode = root;

            while (currentNode != null) {
                if (value.compareTo(currentNode.value) == 0) {
                    return true;
                } else if (value.compareTo(currentNode.value) < 0) {
                    currentNode = currentNode.left;
                } else {
                    currentNode = currentNode.right;
                }
            }
        }
        return false;
    }

    public Node<T> getRoot() {
        return root;
    }

    public void resetPath() {
        path = new ArrayList<T>();
    }

    public String getPath() {
        StringBuffer sb = new StringBuffer();
        for (T value : path) {
            sb.append(value);
            sb.append(",");
        }
        return sb.toString();
    }

    private void visit(Node<T> node) {
        if (path != null) {
            path.add(node.value);
        }

        // System.out.print(node.value.toString() + ",");
    }

    public void preOrderTraversal(Node<T> node) {
        visit(node);
        if (node.left != null) {
            preOrderTraversal(node.left);
        }
        if (node.right != null) {
            preOrderTraversal(node.right);
        }
    }

    public void inOrderTraversal(Node<T> node) {

        if (node.left != null) {
            inOrderTraversal(node.left);
        }
        visit(node);
        if (node.right != null) {
            inOrderTraversal(node.right);
        }
    }

    public void postOrderTraversal(Node<T> node) {
        if (node.left != null) {
            postOrderTraversal(node.left);
        }
        if (node.right != null) {
            postOrderTraversal(node.right);
        }
        visit(node);
    }

    public void iterativeInOrderTraversal(Node<T> node) {
        Stack<Node<T>> stack = new Stack<Node<T>>();

        Node<T> currentNode = node;

        while (currentNode != null || !stack.isEmpty()) {

            if (currentNode != null) {
                stack.push(currentNode);
                currentNode = currentNode.left;
            } else if (!stack.isEmpty()) {
                currentNode = stack.pop();
                visit(currentNode);
                currentNode = currentNode.right;
            }
        }
    }

    public void iterativePreOrderTraversal(Node<T> node) {
        Stack<Node<T>> stack = new Stack<Node<T>>();

        Node<T> currentNode = node;

        while (currentNode != null || !stack.isEmpty()) {

            if (currentNode != null) {
                visit(currentNode);
                stack.push(currentNode);
                currentNode = currentNode.left;
            } else if (!stack.isEmpty()) {
                currentNode = stack.pop();
                currentNode = currentNode.right;
            }
        }
    }

    public void iterativePostOrderTraversal(Node<T> node) {
        Stack<Node<T>> stack1 = new Stack<Node<T>>();
        Stack<Node<T>> stack2 = new Stack<Node<T>>();

        stack1.push(node);

        while (!stack1.isEmpty()) {

            Node<T> currentNode = stack1.pop();

            if (currentNode.left != null) {
                stack1.push(currentNode.left);
            }
            if (currentNode.right != null) {
                stack1.push(currentNode.right);
            }
            stack2.push(currentNode);
        }

        while (!stack2.isEmpty()) {
            visit(stack2.pop());
        }
    }

    public void breadthFirstTraversal(Node<T> node) {
        Queue<Node<T>> queue = new LinkedList<Node<T>>();

        queue.add(node);

        while (!queue.isEmpty()) {

            Node<T> currentNode = queue.remove();

            visit(currentNode);

            if (currentNode.left != null) {
                queue.add(currentNode.left);
            }
            if (currentNode.right != null) {
                queue.add(currentNode.right);
            }
        }
    }
}
