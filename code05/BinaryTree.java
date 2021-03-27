package assignment01;

public class BinaryTree  {

    protected TreeNode root;

    //Constructor 1 (Default)
    //Initializes an empty tree
    public BinaryTree() {
        /* DO NOT EDIT THIS METHOD */
        root = null;
    }

    //Constructor 2
    //Initializes the tree with a root
    public BinaryTree(int rootItem) {
        /* DO NOT EDIT THIS METHOD */
        root = new TreeNode(rootItem, null, null);
    }

    //Constructor 3
    //Initializes the tree with the root, left subtree and right subtree
    public BinaryTree(int rootItem, BinaryTree leftTree, BinaryTree rightTree) {
        /* DO NOT EDIT THIS METHOD */
        root = new TreeNode(rootItem, null, null);
        attachToLeftSubtree(leftTree);
        attachToRightSubtree(rightTree);
    }

    //Tree Traversal: In Order
    public void inorderTraversal(){
        /* DO NOT EDIT THIS METHOD */
        inorderRecursive(root);
    }

    //Tree Traversal: In Order (recursive)
    public void inorderRecursive(TreeNode current) {
        /* DO NOT EDIT THIS METHOD */
        if (current != null) {
            inorderRecursive(current.getLeft());
            System.out.print(" " + current.getItem());
            inorderRecursive(current.getRight());
        }
    }

    //Attaches an item to the left branch
    public void attachToLeft(int newItem) {

        /* YOUR CODE HERE */
    	// if the left child is not null
    	if(root.getLeft() != null) {
    		System.out.println("the left branch of the tree is already occupied");
    		return;
    	}
    	// attach new node as the left child
    	TreeNode left = new TreeNode(newItem, null, null);
    	root.setLeft(left);
    }

    //Attaches an item to the right branch
    public void attachToRight(int newItem) {

        /* YOUR CODE HERE */
    	// when right child is already occupied
    	if(root.getRight() != null) {
    		System.out.println("the right branch of the tree is already occupied");
    		return;
    	}
    	// add right child
    	TreeNode right = new TreeNode(newItem, null, null);
    	root.setRight(right);
    }

    //Attaches a sub-tree to the left branch
    public void attachToLeftSubtree(BinaryTree leftTree) {

        /* YOUR CODE HERE */
    	// when left subtree is full
    	if(root.getLeft() != null) {
    		System.out.println("the left branch of the tree is already occupied");
    		return;
    	}
    	
    	// set the root of leftTree as the left child
    	root.setLeft(leftTree.root);
    }

    //Attaches a sub-tree to the right branch
    public void attachToRightSubtree(BinaryTree rightTree) {

        /* YOUR CODE HERE */
    	// when right subtree is not null
    	if(root.getRight() != null) {
    		System.out.println("the right branch of the tree is already occupied");
    		return;
    	}
    	
    	// attach the root of rightTree to the right
    	root.setRight(rightTree.root);
    }

    //Returns the number of nodes in the tree.
    public int size(){

        /* YOUR CODE HERE */
    	// when the root is empty, return 0
    	if(root == null)
    		return 0;
        return sizeRecursive(root); //temporary, change this later

    }

    //Recursive method to calculate the number of nodes.
    public int sizeRecursive(TreeNode node) {

        /* YOUR CODE HERE */
    	// return 0 when the current node is empty
    	if (node == null){
            return 0;
        }
    	
    	// return the number of left subtree and right subtree plus 1 - the current one
        return sizeRecursive(node.getLeft()) + sizeRecursive(node.getRight()) + 1; //temporary, change this later
    }

    //Returns the height of the tree
    public int height(){

        /* YOUR CODE HERE */
    	if(root == null)
    		return 0;
    	
        return heightSubtree(root) - 1; //temporary, change this later
    }

    public int heightSubtree(TreeNode current){

        /* YOUR CODE HERE */
    	if(current == null)
    		return 0;
    	// the height of the right subtree
    	int r = heightSubtree(current.getRight());
    	// the height of the left subtree
    	int l = heightSubtree(current.getLeft());
    	
    	// use the higher one plus 1
    	if(r > l)
    		return r+1;
    	
        return l+1; //temporary, change this later
    }
}