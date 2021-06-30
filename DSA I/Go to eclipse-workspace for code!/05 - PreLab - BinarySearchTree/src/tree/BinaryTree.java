package tree;

public class BinaryTree<T> {

	protected TreeNode<T> root = null;
	
	/* Print methods */
	public void printInOrder() {
		printInOrder(root);
		System.out.println();
	}
	private void printInOrder(TreeNode<T> curNode) {
	//TODO: Implement this method 	
		//Base Case
		if(curNode == null) 	//If the CurNode is empty: return
			return;
		//Recursive Case
		printInOrder(curNode.left);
		System.out.print(curNode.data + " ");
		printInOrder(curNode.right);
	}
	
	public void printPreOrder() {
		printPreOrder(root);
		System.out.println();
	}
	private void printPreOrder(TreeNode<T> curNode) {
		//TODO: Implement this method
		if(curNode == null) 	//If the CurNode is empty: return
			return;
		 System.out.print(curNode.data + " ");	//Prints the curNode value
	     printPreOrder(curNode.left);	//Calls recursion on this method
	     printPreOrder(curNode.right);	//Calls recursion on this method
	}
	
	public void printPostOrder() {
		printPostOrder(root);
		System.out.println();
	}
	//Weird? Needs to count nodes?
	private void printPostOrder(TreeNode<T> curNode) {
		//TODO: Implement this method
		//base case
		if(curNode == null) return;
		printPostOrder(curNode.left);
		printPostOrder(curNode.right);
		System.out.print(curNode.data + " ");
	}
	
	/* CODE BELOW IS IMPLEMENTED FOR YOU */
	
	/* A somewhat more pretty print method for debugging */
	public void printTree() {
		printTree(this.root, 0);
		System.out.println("\n\n");
	}
	private void printTree(TreeNode<T> curNode, int indentLev) {
		if(curNode == null) return;
		for(int i=0; i<indentLev; i++) {
			if(i == indentLev - 1) System.out.print("|-----");
			else System.out.print("      ");
		}
		System.out.println(curNode.data);
		printTree(curNode.left, indentLev+1);
		printTree(curNode.right, indentLev+1);
	}
	
	/* Computes the height of the tree on the fly */
	public int height() {
		return height(root);
	}
	private int height(TreeNode<T> curNode) {
		if(curNode == null) return 0;
		else return Math.max(height(curNode.left), height(curNode.right))+1;
	}
}
