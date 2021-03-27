public class BST {
	private TreeNode root; // The root of the tree.

	// ======================================
	// Creates an empty binary search tree.
	// ======================================
	public BST() {
		root = null;
	}

	// ================================================================
	// Add the specified item to the binary search tree in the
	// appropriate position according to its key value.
	// ================================================================
	public void insert(int newItem) {
		/* YOUR CODE HERE */
		
		// when the tree is empty
		if(root == null) {
			root = new TreeNode(newItem);
			return;
		}
		
		TreeNode current = root; // use to iterate through the tree
		TreeNode parent = null; // the parent node of the current one
		boolean found = false;	// flag used to indicate whether the new item is already in the tree or not
		while ((current != null) && (!found)) {
			if (newItem == current.data)
				found = true;
			else if (newItem < current.data) {
				// go left when smaller
				parent = current;
				current = current.left;
			}
			else {
				// go right
				parent = current;
				current = current.right;
			}
		}
		
		// do nothing because the new item is already in the tree
		if (found)
			System.out.println("the new item is already in the tree");
		else {
			// if not found, it means the new item should be inserted into the tree
			current = new TreeNode(newItem);
			// left or right child of the parent node
			if(current.data < parent.data) {
				parent.setLeft(current);
			}else {
				parent.setRight(current);
			}
		}
		
	} // end insert

	// ================================================================
	// Traverse the tree in-order and show value in the binary
	// search tree.
	// ================================================================
	public void printTree() {
		if (root == null)
			System.out.println("Empty tree.");
		else {
			inorderPrint(root);
		}
	}

	// A recursive function to show data in-order
	public void inorderPrint(TreeNode current) {
		if (current != null) {
			inorderPrint(current.left);
			System.out.print(current.data + " ");
			inorderPrint(current.right);
		}
	}

	// ================================================================
	// Traverse the tree and show the data in in in-order and show value
	// in descending order.
	// ================================================================
	public void printTreeDesc() {
		if (root == null)
			System.out.println("Empty tree.");
		else {
			recPrintTreeDesc(root);
		}
	}

	// ============================================
	// A recursive method to to show data in in descending order
	// ============================================
	public void recPrintTreeDesc(TreeNode current) {
		/* YOUR CODE HERE */
		// almost like in-order traversal 
		// for descending order, iterate the right child first then the root before the left
		if (current != null) {
			recPrintTreeDesc(current.right);
			System.out.print(current.data + " ");
			recPrintTreeDesc(current.left);
		}
	}

	// ============================================
	// Traverse the tree and print the leaf nodes
	// ============================================
	public void printLeafs() {
		recursivePrintLeafs(root);
	}

	// ============================================
	// A recursive method to print the leaf
	// ============================================
	public void recursivePrintLeafs(TreeNode node) {
		/* YOUR CODE HERE */
		if (node != null) {
			recursivePrintLeafs(node.left);
			// check whether the current node is leaf or not 
			if(node.left == null && node.right == null) {
				System.out.print(node.data + " ");
			}
			recursivePrintLeafs(node.right);
		}
	}

	// ============================================
	// Traverse the tree and print the internal nodes
	// ============================================
	public void printInternalNodes() {
		recursiveInternalNodes(root);
	}

	// =================================================
	// A recursive method to print the internal nodes
	// =================================================
	public void recursiveInternalNodes(TreeNode node) {
		/* YOUR CODE HERE */
		if (node != null) {
			// check whether the current node is leaf or not 
			if(node.left == null && node.right == null) {
				
			}else {
				// when internal node, print it out
				System.out.print(node.data + " ");
			}
			recursiveInternalNodes(node.left);
			recursiveInternalNodes(node.right);
		}
	}

	// ===============================================
	// Count the number of items under a given key
	// ===============================================
	public int countNodes(int key) {
		TreeNode node = search(key);
		if (node == null)
			return -1;
		else
			return recursiveCountNodes(node);
	}

	// =================================================
	// A recursive method to count the number of nodes
	// =================================================
	public int recursiveCountNodes(TreeNode node) {
		/* YOUR CODE HERE */
		if(node == null)
			return 0;
		if(node.left == null && node.right == null) {
			return 1;
		}
		return recursiveCountNodes(node.left) + recursiveCountNodes(node.right) + 1; // temporary, change this later
	}

	// =================================================
	// Find the minimum value stored in the subtree
	// rooted at a given key value
	// =================================================
	public TreeNode findSmallest(int item) {

		/* YOUR CODE HERE */
		TreeNode start = search(item);
		if(start == null) // if the given item does not exist at all, return null
			return null;
		
		// because the left child is always smaller the the current root
		// if the left child exist
		while(start.left != null) {
			start = start.left;
		}
		
		return start; // temporary, change this later
	}

	// =================================================
	// An iterative code to search an item in a tree
	// =================================================
	public TreeNode search(int key) {

		TreeNode current = root;
		boolean found = false;
		while ((current != null) && (!found)) {
			if (key == current.data)
				found = true;
			else if (key < current.data)
				current = current.left;
			else
				current = current.right;
		}

		if (found)
			return current;
		else
			return null;
	}
}