package trees.rbtree;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

/**
 * This program tests the red-black tree class.
 */
public class RedBlackTreeTest {

	@Before
	public void setUp() {
	}

	@Test
	public void insertAndRemovalTest() {
		RedBlackTree tree = new RedBlackTree();
		tree.add("D");
		tree.add("B");
		tree.add("A");
		tree.add("C");
		tree.add("F");
		tree.add("E");
		tree.add("I");
		tree.add("G");
		tree.add("H");
		tree.add("J");
		tree.remove("A"); // Removing leaf
		tree.remove("B"); // Removing element with one child
		tree.remove("F"); // Removing element with two children
		tree.remove("D"); // Removing root

		assertEquals("CEGHIJ", treeToString(tree));
	}

	/**
	 * Makes a string with all data from a tree in inorder.
	 * 
	 * @param t
	 *            the tree
	 * @return a string with the concatenation of all data
	 */
	public static String treeToString(RedBlackTree t) {
		class MyVisitor implements RedBlackTree.Visitor {
			String result = "";

			public void visit(Node n) {
				result = result + n.data;
			}
		}
		;

		MyVisitor v = new MyVisitor();
		t.inOrderVisit(v);
		return v.result;
	}

	/**
	 * Inserts all permutations of a string into a red black tree and checks
	 * that it contains the strings afterwards.
	 */
	@Test
	public void insertionTest() {
		String letters = "ABCDEFGHI";

		PermutationGenerator gen = new PermutationGenerator(letters);
		for (String perm : gen.getPermutations()) {
			RedBlackTree tree = new RedBlackTree();
			for (int i = 0; i < perm.length(); i++) {
				String s = perm.substring(i, i + 1);
				tree.add(s);
			}
			assertEquals(letters, treeToString(tree));
		}
	}

	/**
	 * Tests deletion, given templates to test. Each template is a tree with a
	 * black node that is to be deleted. All other nodes should be given all
	 * possible combinations of red and black.
	 */
	@Test
	public void removalTest() {

		RedBlackTree[] treesToBeRemoved = removalTestTemplates();

		for (RedBlackTree t : treesToBeRemoved) {
			int nodesToColor = count(t.root) - 2; // We don't recolor the root
			                                      // or toDelete
			for (int k = 0; k < Math.pow(2, nodesToColor); k++) {
				RedBlackTree rb = new RedBlackTree();
				rb.root = copy(t.root);

				Node[] nodes = getNodes(rb);
				Node toDelete = null;

				// Color with the bit pattern of k
				int bits = k;
				for (Node n : nodes) {
					if (n == rb.root) {
						n.color = RedBlackTree.BLACK;
					} else if (n.color == RedBlackTree.BLACK) {
						toDelete = n;
					} else {
						n.color = bits % 2;
						bits = bits / 2;
					}
				}

				// Add children to make equal costs to null
				int targetCost = costToRoot(toDelete);
				for (int i = 0; i < nodes.length; i++) {
					fill(nodes[i], targetCost);
				}

				int filledSize = populate(rb);
				boolean good = true;
				try {
					checkRedBlack(rb);
				} catch (IllegalStateException ex) {
					good = false;
				}
				if (good) {
					Comparable<?> d = toDelete.data;
					// System.out.println(dump(rb.root));
					rb.remove(d);
					checkRedBlack(rb);
					for (Integer j = 1; j <= filledSize; j++) {
						if (!rb.find(j) && !d.equals(j))
							throw new IllegalStateException(j + " deleted");
						if (rb.find(d))
							throw new IllegalStateException(d + " not deleted");
					}
				}
			}
		}
	}

	@SuppressWarnings("unused")
	private static String dump(Node n) {
		if (n == null)
			return "";
		return "(" + dump(n.left) + n.data + "NRBD".charAt(n.color + 1)
		        + dump(n.right) + ")";
	}

	/**
	 * Makes an array of templates for testing removal.
	 */
	private static RedBlackTree[] removalTestTemplates() {
		RedBlackTree[] templates = new RedBlackTree[2];
		for (int i = 0; i < templates.length; i++) {
			templates[i] = new RedBlackTree();
		}

		Node[] n = new Node[8];
		for (int i = 0; i < n.length; i++) {
			n[i] = new Node();
		}

		/*
		 * n0 / \ n1 n2 / \ n3 n4 / \ n7* n5 / n6
		 */

		templates[0].root = n[0];
		n[0].setLeftChild(n[1]);
		n[0].setRightChild(n[2]);
		n[2].setLeftChild(n[3]);
		n[2].setRightChild(n[4]);
		n[3].setLeftChild(n[7]);
		n[4].setRightChild(n[5]);
		n[5].setLeftChild(n[6]);

		n[7].color = RedBlackTree.BLACK;

		// Mirror image

		for (int i = 0; i < n.length; i++) {
			n[i] = new Node();
		}
		templates[1].root = n[0];

		n[0].setRightChild(n[1]);
		n[0].setLeftChild(n[2]);
		n[2].setRightChild(n[3]);
		n[2].setLeftChild(n[4]);
		n[3].setRightChild(n[7]);
		n[4].setLeftChild(n[5]);
		n[5].setRightChild(n[6]);

		n[7].color = RedBlackTree.BLACK;

		return templates;
	}

	/**
	 * Gets all nodes of a tree.
	 * 
	 * @param t
	 *            a red-black tree
	 * @return an array of all nodes in t
	 */
	private static Node[] getNodes(RedBlackTree t) {
		final Node[] nodes = new Node[count(t.root)];
		class MyVisitor implements RedBlackTree.Visitor {
			int current = 0;

			public void visit(Node n) {
				nodes[current] = n;
				current++;
			}
		}
		;
		MyVisitor v = new MyVisitor();
		t.inOrderVisit(v);
		return nodes;
	}

	/**
	 * Fills all empty child nodes of t with fully populated black trees so that
	 * the exit cost from the root is targetCost. If it is already higher, the
	 * child node is not changed.
	 * 
	 * @param n
	 *            the root of a red-black tree
	 * @param targetCost
	 *            the target cost
	 */
	private static void fill(Node n, int targetCost) {
		int cost = targetCost - costToRoot(n);
		if (n.left == null)
			n.setLeftChild(fullTree(cost));
		if (n.right == null)
			n.setRightChild(fullTree(cost));
	}

	/**
	 * Computes the cost from a node to a root.
	 * 
	 * @param n
	 *            a node of a red-black tree
	 * @return the number of black nodes between n and the root
	 */
	private static int costToRoot(Node n) {
		int c = 0;
		while (n != null) {
			c = c + n.color;
			n = n.parent;
		}
		return c;
	}

	/**
	 * Makes a full tree of black nodes of a given depth.
	 * 
	 * @param depth
	 *            the desired depth
	 * @return the root node of a full black tree
	 */
	private static Node fullTree(int depth) {
		if (depth <= 0)
			return null;
		Node r = new Node();
		r.color = RedBlackTree.BLACK;
		r.setLeftChild(fullTree(depth - 1));
		r.setRightChild(fullTree(depth - 1));
		return r;
	}

	/**
	 * Copies all nodes of a red-black tree.
	 * 
	 * @param n
	 *            the root of a red-black tree
	 * @return the root node of a copy of the tree
	 */
	private static Node copy(Node n) {
		if (n == null) {
			return null;
		}
		Node newNode = new Node();
		newNode.setLeftChild(copy(n.left));
		newNode.setRightChild(copy(n.right));
		newNode.data = n.data;
		newNode.color = n.color;
		return newNode;
	}

	/**
	 * Counts the nodes in a tree
	 * 
	 * @param n
	 *            the root of a red-black tree
	 * @return the number of nodes in the tree
	 */
	private static int count(Node n) {
		if (n == null) {
			return 0;
		} else
			return 1 + count(n.left) + count(n.right);
	}

	/**
	 * Populates this tree with the values 1, 2, 3, ... in inorder.
	 * 
	 * @param t
	 *            a red-black tree
	 * @return the number of nodes in t
	 */
	private static int populate(RedBlackTree t) {
		class MyVisitor implements RedBlackTree.Visitor {
			int count;

			public void visit(Node n) {
				count++;
				n.data = new Integer(count);
			}
		}
		;
		MyVisitor v = new MyVisitor();
		t.inOrderVisit(v);
		return v.count;
	}

	/**
	 * Checks whether a red-black tree is valid and throws an exception if not.
	 * 
	 * @param t
	 *            the tree to test
	 */
	public static void checkRedBlack(RedBlackTree t) {
		checkRedBlack(t.root, t.root);

		// Check that it's a BST
		class MyVisitor implements RedBlackTree.Visitor {
			Comparable<?> previous;

			@SuppressWarnings("unchecked")
			public void visit(Node n) {
				if (previous != null) {
					if (n.data.compareTo(previous) <= 0)
						throw new IllegalStateException(n.data
						        + " is not larger than " + previous);
					previous = n.data;
				}
			}
		}
		;
		MyVisitor v = new MyVisitor();
		t.inOrderVisit(v);
	}

	private static int checkRedBlack(Node n, Node root) {
		if (n == null)
			return 0;
		int nleft = checkRedBlack(n.left, root);
		int nright = checkRedBlack(n.right, root);
		if (nleft != nright)
			throw new IllegalStateException("Left and right children of "
			        + n.data + " have different black depths");
		if (n.parent == null) {
			if (n != root)
				throw new IllegalStateException(n.data
				        + " is not root and has no parent");
			if (n.color != RedBlackTree.BLACK)
				throw new IllegalStateException("Root " + n.data
				        + " is not black");
		} else {
			if (n.color == RedBlackTree.RED
			        && n.parent.color == RedBlackTree.RED)
				throw new IllegalStateException("Parent of rred " + n.data
				        + " is red");
			if (n == root)
				throw new IllegalStateException(n.data
				        + " is root and has a parent");
		}
		if (n.left != null && n.left.parent != n)
			throw new IllegalStateException("Left child of " + n.data
			        + " has bad parent link");
		if (n.right != null && n.right.parent != n)
			throw new IllegalStateException("Right child of " + n.data
			        + " has bad parent link");
		if (n.color != RedBlackTree.RED && n.color != RedBlackTree.BLACK)
			throw new IllegalStateException(n.data + " has color " + n.color);
		return n.color + nleft;
	}
}

/**
 * This class generates permutations of a word.
 */
class PermutationGenerator {
	private String word;

	/**
	 * Constructs a permutation generator.
	 * 
	 * @param aWord
	 *            the word to permute
	 */
	public PermutationGenerator(String aWord) {
		word = aWord;
	}

	/**
	 * Gets all permutations of a given word.
	 */
	public ArrayList<String> getPermutations() {
		ArrayList<String> permutations = new ArrayList<String>();

		// The empty string has a single permutation: itself
		if (word.length() == 0) {
			permutations.add(word);
			return permutations;
		}

		// Loop through all character positions
		for (int i = 0; i < word.length(); i++) {
			// Form a simpler word by removing the ith character
			String shorterWord = word.substring(0, i) + word.substring(i + 1);

			// Generate all permutations of the simpler word
			PermutationGenerator shorterPermutationGenerator = new PermutationGenerator(
			        shorterWord);
			ArrayList<String> shorterWordPermutations = shorterPermutationGenerator
			        .getPermutations();

			// Add the removed character to the front of
			// each permutation of the simpler word,
			for (String s : shorterWordPermutations) {
				permutations.add(word.charAt(i) + s);
			}
		}
		// Return all permutations
		return permutations;
	}
}
