package trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class BinaryTree<T extends Comparable<T>> {

    BinaryTreeNode<T> root;
    List<T> path;
    int size = 0;

    public void insert(T value) {

        BinaryTreeNode<T> newNode = new BinaryTreeNode<T>(value, null, null);

        if (root == null) {
            root = newNode;
        } else {
            BinaryTreeNode<T> currentNode = root;

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
            BinaryTreeNode<T> currentNode = root;

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

    public BinaryTreeNode<T> getRoot() {
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

    private void visit(BinaryTreeNode<T> node) {
        if (path != null) {
            path.add(node.value);
        }

        // System.out.print(node.value.toString() + ",");
    }

    public void preOrderTraversal(BinaryTreeNode<T> node) {
        visit(node);
        if (node.left != null) {
            preOrderTraversal(node.left);
        }
        if (node.right != null) {
            preOrderTraversal(node.right);
        }
    }

    public void inOrderTraversal(BinaryTreeNode<T> node) {

        if (node.left != null) {
            inOrderTraversal(node.left);
        }
        visit(node);
        if (node.right != null) {
            inOrderTraversal(node.right);
        }
    }

    public void postOrderTraversal(BinaryTreeNode<T> node) {
        if (node.left != null) {
            postOrderTraversal(node.left);
        }
        if (node.right != null) {
            postOrderTraversal(node.right);
        }
        visit(node);
    }

    public void iterativeInOrderTraversal(BinaryTreeNode<T> node) {
        Stack<BinaryTreeNode<T>> stack = new Stack<BinaryTreeNode<T>>();

        BinaryTreeNode<T> currentNode = node;

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

    public void iterativePreOrderTraversal(BinaryTreeNode<T> node) {
        Stack<BinaryTreeNode<T>> stack = new Stack<BinaryTreeNode<T>>();

        BinaryTreeNode<T> currentNode = node;

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

    public void iterativePostOrderTraversal(BinaryTreeNode<T> node) {
        Stack<BinaryTreeNode<T>> stack1 = new Stack<BinaryTreeNode<T>>();
        Stack<BinaryTreeNode<T>> stack2 = new Stack<BinaryTreeNode<T>>();

        stack1.push(node);

        while (!stack1.isEmpty()) {

            BinaryTreeNode<T> currentNode = stack1.pop();

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

    public void breadthFirstTraversal(BinaryTreeNode<T> node) {
        Queue<BinaryTreeNode<T>> queue = new LinkedList<BinaryTreeNode<T>>();

        queue.add(node);

        while (!queue.isEmpty()) {

            BinaryTreeNode<T> currentNode = queue.remove();

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
