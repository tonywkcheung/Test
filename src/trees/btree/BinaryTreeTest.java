package trees.btree;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class BinaryTreeTest {

	static BinaryTree<String> binaryTree;

	@BeforeClass
	public static void setupOnce() {
		binaryTree = new BinaryTree<String>();

		binaryTree.insert("The");
		binaryTree.insert("Quick");
		binaryTree.insert("Fox");
		binaryTree.insert("Jumped");
		binaryTree.insert("Over");
		binaryTree.insert("The");
		binaryTree.insert("Lazy");
		binaryTree.insert("Brown");
		binaryTree.insert("Cow");

		// The
		// Quick The
		// Fox
		// Brown Jumped
		// Cow Over
		// Lazy
	}

	@Before
	public void setup() {
		binaryTree.resetPath();
	}

	@Test
	public void inOrderTraversalRecursive() {

		binaryTree.inOrderTraversal(binaryTree.getRoot());
		assertEquals("Brown,Cow,Fox,Jumped,Lazy,Over,Quick,The,The,",
		        binaryTree.getPath());
	}

	@Test
	public void preOrderTraversalRecursive() {

		binaryTree.preOrderTraversal(binaryTree.getRoot());
		assertEquals("The,Quick,Fox,Brown,Cow,Jumped,Over,Lazy,The,",
		        binaryTree.getPath());
	}

	@Test
	public void postOrderTraversalRecursive() {
		binaryTree.postOrderTraversal(binaryTree.getRoot());
		assertEquals("Cow,Brown,Lazy,Over,Jumped,Fox,Quick,The,The,",
		        binaryTree.getPath());
	}

	@Test
	public void inOrderTraversalIterative() {
		binaryTree.iterativeInOrderTraversal(binaryTree.getRoot());
		assertEquals("Brown,Cow,Fox,Jumped,Lazy,Over,Quick,The,The,",
		        binaryTree.getPath());
	}

	@Test
	public void preOrderTraversalIterative() {
		binaryTree.iterativePreOrderTraversal(binaryTree.getRoot());
		assertEquals("The,Quick,Fox,Brown,Cow,Jumped,Over,Lazy,The,",
		        binaryTree.getPath());
	}

	@Test
	public void postOrderTraversalIterative() {
		binaryTree.iterativePostOrderTraversal(binaryTree.getRoot());
		assertEquals("Cow,Brown,Lazy,Over,Jumped,Fox,Quick,The,The,",
		        binaryTree.getPath());
	}

	@Test
	public void breadthFirstTraversalIterative() {
		binaryTree.breadthFirstTraversal(binaryTree.getRoot());
		assertEquals("The,Quick,The,Fox,Brown,Jumped,Cow,Over,Lazy,",
		        binaryTree.getPath());
	}
}
