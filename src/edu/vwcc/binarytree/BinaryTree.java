package edu.vwcc.binarytree;

/**
 * Generic Base binary tree class.
 * Author Name: [Your Name]
 * Date: [Your Date]
 */
public class BinaryTree<T> {
    private Node<T> root; 
  

    /*
     * Performs an inorder traversal of this binary tree
     * Note: this method has already been completed for you
     * Also notice how to separate out the recursive implementation
     */
    public void inorderTraversal() {
        inorderRecursive(root);
    }
    // the private recursive implementation method for inorderTraversal
    private void inorderRecursive(Node<T> node) {
        if (node != null) {
            inorderRecursive(node.left);
            System.out.print(node.value + " ");
            inorderRecursive(node.right);
        }
    }
    
    /*
     * Perform an preorder traversal of this binary tree
     */
    public void preorderTraversal() {
        // TODO
    }
    
    
    /*
     * Perform an postorder traversal of this binary tree
     */
    public void postorderTraversal() {
        // TODO
    }
        

    // Returns the number of nodes in the tree.
    public int size() {
        // TODO
        return 0;
    }

    // Returns true if a node with the specified value exists in the tree, otherwise false.
    public boolean contains(T value) {
        // TODO
        return false;
    }
    
    // Returns the height of the tree (= number of edges between nodes)
    public int height() {
        // TODO
        return -1;
    }


    // GETTER & SETTER
	public Node<T> getRoot() {
		return root;
	}

	public void setRoot(Node<T> root) {
		this.root = root;
	}
}


