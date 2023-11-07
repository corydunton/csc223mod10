package edu.vwcc.binarytree;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;


class BinaryTreeTest {

    private BinaryTree<Integer> tree;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    public void setUp() {
        tree = new BinaryTree<>();
        System.setOut(new PrintStream(outContent)); // Redirect System.out to outContent.
    }

    @Test
    void testEmptyTreeSize() {
        assertEquals(0, tree.size(), "Empty tree size should be 0");
    }

    @Test
    void testSizeWithOneNode() {
        tree.setRoot(new Node<>(1));
        assertEquals(1, tree.size(), "Tree size with one node should be 1");
    }

    @Test
    void testSizeWithMultipleNodes() {
        Node<Integer> leftChild = new Node<>(2);
        Node<Integer> rightChild = new Node<>(3);
        Node<Integer> root = new Node<>(1, leftChild, rightChild);
        tree.setRoot(root);
        assertEquals(3, tree.size(), "Tree size with three nodes should be 3");
    }

    @Test
    void testContainsRootValue() {
        tree.setRoot(new Node<>(1));
        assertTrue(tree.contains(1), "Tree should contain the root value");
    }

    @Test
    void testDoesNotContainValue() {
        tree.setRoot(new Node<>(1));
        assertFalse(tree.contains(2), "Tree should not contain a non-existent value");
    }

    @Test
    void testContainsMultipleValues() {
        Node<Integer> leftChild = new Node<>(2);
        Node<Integer> rightChild = new Node<>(3);
        Node<Integer> root = new Node<>(1, leftChild, rightChild);
        tree.setRoot(root);
        assertTrue(tree.contains(2), "Tree should contain left child value");
        assertTrue(tree.contains(3), "Tree should contain right child value");
    }

    @Test
    void testEmptyTreeHeight() {
        assertEquals(-1, tree.height(), "Empty tree height should be -1");
    }

    @Test
    void testHeightWithOneNode() {
        tree.setRoot(new Node<>(1));
        assertEquals(0, tree.height(), "Tree height with one node should be 0");
    }

    @Test
    void testHeightWithThreeNodes() {
        Node<Integer> leftChild = new Node<>(2);
        Node<Integer> rightChild = new Node<>(3);
        Node<Integer> root = new Node<>(1, leftChild, rightChild);
        tree.setRoot(root);
        assertEquals(1, tree.height(), "Tree height with three nodes should be 1");
    }
    
    @Test
    void testHeightWithMultipleLevels() {
        Node<Integer> leftChildLeft = new Node<>(4);
        Node<Integer> leftChildRight = new Node<>(5);
        Node<Integer> rightChildLeft = new Node<>(6);
        Node<Integer> rightChildRight = new Node<>(7);
        Node<Integer> leftChild = new Node<>(2, leftChildLeft, leftChildRight);
        Node<Integer> rightChild = new Node<>(3, rightChildLeft, rightChildRight);
        Node<Integer> root = new Node<>(1, leftChild, rightChild);
        tree.setRoot(root);
        assertEquals(2, tree.height(), "Tree height with three levels should be 2");
    }  

    // Inorder Traversal Tests
    
    @Test
    public void testInorderTraversal_emptyTree() {
        tree.inorderTraversal();
        assertEquals("", outContent.toString().trim());
    }

    @Test
    public void testInorderTraversal_singleNode() {
        tree.setRoot(new Node<>(1));
        tree.inorderTraversal();
        assertEquals("1", outContent.toString().trim());
    }
    
    @Test
    public void testInorderTraversal_multipleNodes() {
        Node<Integer> leftChildLeft = new Node<>(4);
        Node<Integer> leftChildRight = new Node<>(5);
        Node<Integer> leftChild = new Node<>(2, leftChildLeft, leftChildRight);
        Node<Integer> rightChildLeft = new Node<>(6);
        Node<Integer> rightChildRight = new Node<>(7);
        Node<Integer> rightChild = new Node<>(3, rightChildLeft, rightChildRight);
        Node<Integer> root = new Node<>(1, leftChild, rightChild);
        tree.setRoot(root);
        tree.inorderTraversal();
        String expectedOutput = "4 2 5 1 6 3 7";
        assertEquals(expectedOutput, outContent.toString().trim(), "Inorder traversal should match expected output.");
    }
    
 // Preorder Traversal Tests

    @Test
    public void testPreorderTraversal_emptyTree() {
        tree.preorderTraversal();
        assertEquals("", outContent.toString().trim());
    }

    @Test
    public void testPreorderTraversal_singleNode() {
        tree.setRoot(new Node<>(1));
        tree.preorderTraversal();
        assertEquals("1", outContent.toString().trim());
    }

    @Test
    public void testPreorderTraversal_multipleNodes() {
        Node<Integer> leftChildLeft = new Node<>(4);
        Node<Integer> leftChildRight = new Node<>(5);
        Node<Integer> leftChild = new Node<>(2, leftChildLeft, leftChildRight);
        Node<Integer> rightChildLeft = new Node<>(6);
        Node<Integer> rightChildRight = new Node<>(7);
        Node<Integer> rightChild = new Node<>(3, rightChildLeft, rightChildRight);
        Node<Integer> root = new Node<>(1, leftChild, rightChild);
        tree.setRoot(root);
        tree.preorderTraversal();
        String expectedOutput = "1 2 4 5 3 6 7";
        assertEquals(expectedOutput, outContent.toString().trim(), "Preorder traversal should match expected output.");
    }

    // Postorder Traversal Tests

    @Test
    public void testPostorderTraversal_emptyTree() {
        tree.postorderTraversal();
        assertEquals("", outContent.toString().trim());
    }

    @Test
    public void testPostorderTraversal_singleNode() {
        tree.setRoot(new Node<>(1));
        tree.postorderTraversal();
        assertEquals("1", outContent.toString().trim());
    }

    @Test
    public void testPostorderTraversal_multipleNodes() {
        Node<Integer> leftChildLeft = new Node<>(4);
        Node<Integer> leftChildRight = new Node<>(5);
        Node<Integer> leftChild = new Node<>(2, leftChildLeft, leftChildRight);
        Node<Integer> rightChildLeft = new Node<>(6);
        Node<Integer> rightChildRight = new Node<>(7);
        Node<Integer> rightChild = new Node<>(3, rightChildLeft, rightChildRight);
        Node<Integer> root = new Node<>(1, leftChild, rightChild);
        tree.setRoot(root);
        tree.postorderTraversal();
        String expectedOutput = "4 5 2 6 7 3 1";
        assertEquals(expectedOutput, outContent.toString().trim(), "Postorder traversal should match expected output.");
    }


    
}