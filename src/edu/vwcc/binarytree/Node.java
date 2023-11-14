package edu.vwcc.binarytree;

/**
 * Generic Node class.
 */

public class Node<T> {
	T value;
	Node<T> left, right;

	// Constructor for leaf nodes.
	public Node(T val) {
		value = val;
		left = null;
		right = null;
	}

	// Constructor for non-leaf nodes.
	public Node(T val, Node<T> leftChild, Node<T> rightChild) {
		value = val;
		left = leftChild;
		right = rightChild;
	}
}
