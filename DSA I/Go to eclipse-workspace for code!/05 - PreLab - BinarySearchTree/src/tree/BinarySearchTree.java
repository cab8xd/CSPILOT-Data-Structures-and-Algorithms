package tree;

public class BinarySearchTree<T extends Comparable<T>> extends BinaryTree<T> implements Tree<T> {

	@Override
	public void remove(T data) {
		this.root = remove(data, root);
	}

	protected TreeNode<T> remove(T data, TreeNode<T> curNode) {
		// TODO: Implement this method
		// System.out.println("BEFORE remove" + curNode.data);
		if (curNode == null) // base case
			return curNode; // Item not found; do nothing

		// Finding the curNode to remove
		if (data.compareTo(curNode.data) < 0)
			curNode.left = remove(data, curNode.left);
		else if (data.compareTo(curNode.data) > 0)
			curNode.right = remove(data, curNode.right);

		// If the curNode has two children
		else if (curNode.left != null && curNode.right != null) // Two children
		{
			curNode.data = findMax(curNode.left).data;// replacing successor
			curNode.left = remove(curNode.data, curNode.left);
		}

		// If the curNode is found
		else {
			// if-else statement. if the left is not null,
			// curNode becomes the left child.
			// else curNode becomes the right child
			if (curNode.left != null) {

				curNode = (curNode.left);

			} else {
				curNode = curNode.right;
			}
		}

		return curNode;
	}

	@Override
	public boolean find(T data) {
		return find(data, root); // start at the root of the tree.
		// Polymorphism with the other find method
	}

	private boolean find(T data, TreeNode<T> curNode) {
		// TODO: Implement this method
		if (curNode == null)
			return false; // if the item is not in the curNode (off end of tree)
		else if (data.compareTo(curNode.data) < 0) // if the curNode is less than the data
			return find(data, curNode.left); // Move down left
		else if (data.compareTo(curNode.data) > 0) // if the curNode is greater than data
			return find(data, curNode.right); // Move down to the right child
		return true; // if the curNode is (implicitly) equal to the data
	}

	public void insert(T data) {
		this.root = insert(data, root); // polymorphism; start at root of tree
	}

	/**
	 * Helper method for inserting recursively
	 * 
	 * @param data
	 * @param curNode
	 * @return a reference to the new root of the subtree
	 */

	protected TreeNode<T> insert(T data, TreeNode<T> curNode) {
		// TODO: Implement this method
		if (curNode == null)
			return new TreeNode<T>(data); // New curNode inputed with data
		else if (data.compareTo(curNode.data) < 0)
			curNode.left = insert(data, curNode.left);// move down left
		else if (data.compareTo(curNode.data) > 0)
			curNode.right = insert(data, curNode.right); // move down right
		else
			; // duplicate, ignoring the insert
		return curNode; // curNode still the root of this subtree (matches. no duplicating)
	}

	/**
	 * Returns the max item in the given subtree
	 */
	public TreeNode<T> findMax(TreeNode<T> curNode) {
		// TODO: Implement this method
		if (curNode.right == null)
			return curNode; // returns curNode if empty
		return findMax(curNode.right);

	}
}
