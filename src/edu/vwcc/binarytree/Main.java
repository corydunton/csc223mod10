package edu.vwcc.binarytree;

/**
 * This program demonstrates construction and inorder traversal of 2 binary
 * trees.
 * 
 * intTree - consists on five integers charTree - consists of eight chars
 * 
 * Author Name: [Your Name] Date: [Your Date]
 */

public class Main {

	public static void main(String[] args) {

		// #1. First we construct a binary tree with Integer nodes
		BinaryTree intTree = new BinaryTree(); // root node is null

		Node firstNode = new Node(10);
		firstNode.left = new Node(20);
		Node leafNode = new Node(40);
		Node rightChild = new Node(30, leafNode, new Node(50));
		firstNode.right = rightChild;

		intTree.setRoot(firstNode); // set root node

		System.out.print("\nINT TREE:\nInorder traversal is: \n\n");
		intTree.inorderTraversal();

		System.out.println("\n\nGenerating GUI visualization in separate window...");
		TreeGUI.displayTree(intTree.getRoot());

		// #2. Now we construct a binary tree with Character nodes
		BinaryTree charTree = new BinaryTree();
		Node<Character> gNode = new Node<>('G');
		Node<Character> dNode = new Node<>('D', gNode, null);
		Node<Character> bNode = new Node<>('B', dNode, null);
		Node<Character> hNode = new Node<>('H');
		Node<Character> fNode = new Node<>('F', hNode, null);
		Node<Character> eNode = new Node<>('E');
		Node<Character> cNode = new Node<>('C', eNode, fNode);
		Node<Character> aNode = new Node<>('A', bNode, cNode);
		charTree.setRoot(aNode);

		System.out.print("\nCHAR TREE:\nInorder traversal is: \n\n");
		charTree.inorderTraversal();

		System.out.println("\n\nGenerating GUI visualization in separate window...\n\n");
		TreeGUI.displayTree(charTree.getRoot());

		// #3 TODO: Reconstruct the charTree however you need to such that the
		// inorder Traversal spells on the Console: H E L L O W O R L D
		// call both inorderTraversal and TreeGUI.dispayTree with it
		// Finally, call and print some stats about your new tree: size, height, and if
		// it contains the space char ' '

		// #4 TODO: Without changing your new HELLOWORLD charTree, now show the console
		// output for
		// preorder and postorder Traversals once you have completed them in BinaryTree

	}
}