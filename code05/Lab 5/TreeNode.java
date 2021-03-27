public class TreeNode
  {
    public int data;  // value stored in node
    public TreeNode left;  // left child 
    public TreeNode right; // right child 

    
    // Constructor for initialization 
    public TreeNode( int newData )
    {
      data = newData;
      left = null;
      right = null;
    } 
    
    // The usual accessors (you may not have to use them).
    public int getData() { return data; }
    public TreeNode getLeft() { return left; }
    public TreeNode getRight() { return right; }
    
    // add more instance variables and (get/set) methods to run the program
    public void setData(int d) {
    	data = d;
    }
    
    public void setLeft(TreeNode l) {
        // Sets the left child reference to left.
        left = l;
    }
    
    public void setRight(TreeNode r) {
        // Sets the right child reference to right.
        right = r;
    }

    
    
}

