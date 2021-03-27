import java.util.*;

public class Lab5Q2Test {
	public static void main(String[] args) {
		BST tree = new BST();

		int[] nodeKeys = { 52, 30, 61, 11, 62, 40, 55, 10, 9, 8 };

		for (int i = 0; i < nodeKeys.length; i++) {
			tree.insert(nodeKeys[i]);
		}

		System.out.print("Inorder traversal: ");
		tree.printTree();

		System.out.print("\nTree in Descending Order: ");
		tree.printTreeDesc();

		System.out.print("\nLeaf nodes are: ");
		tree.printLeafs();

		System.out.print("\nInternal nodes are: ");
		tree.printInternalNodes();

		System.out.println("\nNumber of nodes: " + tree.countNodes(52));

		int rootKey = 10;
		if (tree.findSmallest(rootKey) != null)
			System.out.println(
					"Smallest node in the subtree rooted " + rootKey + ": " + (tree.findSmallest(rootKey).data));
		else
			System.out.println("Value not found");

		System.out.println("Number of nodes in the subtree rooted " + rootKey + ": " + tree.countNodes(rootKey));
	}
}
