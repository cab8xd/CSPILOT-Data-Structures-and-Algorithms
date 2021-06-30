package tree;

/**
 * Self-balancing AVL Tree
 * @author Mark Floryan
 *
 * @param <T>
 */
public class AVLTree<T extends Comparable<T>> extends BinarySearchTree<T>{
	
	

	@Override
	public void insert(T data) {
		this.root = insert(data, this.root);
	}
	protected TreeNode<T> insert(T data, TreeNode<T> curNode) {
		curNode = super.insert(data, curNode);//inserts data
		
		if(curNode == null) return null; //checks for null error
		
		//TODO: Update the height of curNode if necessary and call balance
		//Update height of node
	    curNode.height = Math.max(height(curNode.left), height(curNode.right)) + 1;
	    
	    //Balance Node
	    return balance(curNode);
	    
	}

	@Override
	public void remove(T data) {
		this.root = remove(data, this.root);
	}
	protected TreeNode<T> remove(T data, TreeNode<T> curNode) {
		/* Call BST remove before balancing */
		curNode = super.remove(data,  curNode);
		
		if(curNode == null) return null;
		
		//TODO: Update the height of curNode if necessary and call balance
		curNode.height = Math.max(height(curNode.left), height(curNode.right)) + 1;
		
		//System.out.println("Removed");
		
		return balance(curNode);
	}//removes adds 2 cases. removing a node (children are both factors of 0 rotate left, if the current node is 2 (left heavy)
	//, rotate right)
	
	/**
	 * Balances the given node. 
	 * Assumes it is the lowest unbalanced node if unbalanced
	 * @param node
	 * @return the new root of this subtree
	 */
	//null error is weird.
	
	
	
	//No children, Two children (remove, sort)
	
	/*
	 * For remove:
	 * Check the parent node balance factor 
	 * 	if the balance factor of parent node is 2 OR -2
	 * 		if the parent node's right child is zero
	 * 			rotate parent node to the left
	 * 		else if the left child is zero
	 * 			rotate parent node to the right 
	 */
	
	private TreeNode<T> balance(TreeNode<T> curNode) {
		//TODO: Implement this method
		int balance  = balanceFactor(curNode);

		if(balance > 1) // right
		{
			//System.out.println("balance > 1");
				if(balanceFactor(curNode.right) < 0) {
					//System.out.println("right < 0");
					curNode.right = rotateRight(curNode.right);
					curNode= rotateLeft(curNode);
				}

				else
					curNode = rotateLeft(curNode);
				//System.out.println("after right < 0");
		}
		else if (balance < -1) // left
		{
			//System.out.println("balance < 1");
			//if(curNode.right != null) {
				//balanceRight = balanceFactor(curNode.right);
				if(balanceFactor(curNode.left) > 0) {
				curNode.left = rotateLeft(curNode.left);
				curNode = rotateRight(curNode);
				}
	
				else
					curNode = rotateRight(curNode);
			}
		
		//One case: if the parent node balance = 2 and the parent.right is balanced, rotate left
	return curNode;
	}
		
		/*
	      if (balanceFactor(curNode) == -2) {
	    	  //System.out.println("Before left");
	            if (curNode.right != null && balanceFactor(curNode.right) > 0)
	            {
	            	//System.out.println("Before 2x RotateRight");
	                curNode.right = rotateRight(curNode.right);
	                //System.out.println(" 2x RotateRight");
	            }
	            curNode = rotateLeft(curNode);
	         	//System.out.println("Afterleft");
	        }
	        else if (balanceFactor(curNode) == 1) 
	        {
	            if (curNode.left != null && balanceFactor(curNode.left) < 0)
	                curNode.right = rotateLeft(curNode.left);
	            curNode = rotateRight(curNode);
	        }
	        return curNode;
	        */
	
	
	
	private TreeNode<T> rotateLeft(TreeNode<T> curNode) {
		//TODO: Implement this method
		//Right rotation: left side is longer (negative balance -2)
		TreeNode<T> pivot =  curNode.right; //curNode is imbalanced node
		curNode.right = pivot.left;
		pivot.left = curNode;
		
		//update heights
		curNode.height = Math.max(height(curNode.left), height(curNode.right)) + 1;
		pivot.height = Math.max(height(pivot.left), height(pivot.right)) + 1;
		return pivot;
	}
	
	private TreeNode<T> rotateRight(TreeNode<T> curNode){
		//TODO: Implement this method
		//Left rotation: right side is longer (positive balance 2)
		TreeNode<T> pivot = curNode.left;
		
		//temp 1 = cur.left 
		//temp 2 = temp1.right
		
		
		//temp 1 = temp 2
		//temp 2 = curNode
		//return temp 2
		
		
		curNode.left = pivot.right;
		pivot.right = curNode;
		
		//update heights
		curNode.height = Math.max(height(curNode.left), height(curNode.right)) + 1;
		pivot.height = Math.max(height(pivot.left), height(pivot.right)) + 1;
		
		return pivot;
	}
	
	private int balanceFactor(TreeNode<T> node) {
		//System.out.println("right " + height(node.right));
		//System.out.println("left " + height(node.left));
		//System.out.println(height(node.right) - height(node.left));
		return height(node.right) - height(node.left);
	}
	
	/* height method that checks for the null case */
	private int height(TreeNode<T> node) {
		if(node == null) return 0;
		return node.height;
	}
}
