package tester;
/* Christine Baca cab8xd */ 

import tree.AVLTree;
import tree.BinarySearchTree;

public class AVLTreeTester {
	
	private static int TRIALS = 100;

	public static void main(String[] args) {
		
		/* Here are two test cases for your implementations. */
		/* You SHOULD create more */
		
		/*
		 * 	Correct output:
		 * 	BST Pre: 5 4 3 2 1 9 8 7 6 
		 *	BST In: 1 2 3 4 5 6 7 8 9 
		 *	BST Post: 1 2 3 4 6 7 8 9 5 
		 *	AVL Pre: 4 2 1 3 8 6 5 7 9 
		 *	AVL In: 1 2 3 4 5 6 7 8 9 
		 *	AVL Post: 1 3 2 5 7 6 9 8 4 
		 * 
		 * 
		 */
		AVLTree<Integer> avl = new AVLTree<Integer>();
		BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();
		
		int[] toInsert = {5,4,3,2,1,9,8,7,6};
		
		for(int i : toInsert) {
			avl.insert(i);
			bst.insert(i);
		}
		
		 /* Print out pre, in, and post-order */	
		System.out.print("BST Pre: "); bst.printPreOrder(); 
		System.out.print("BST In: "); bst.printInOrder(); 
		System.out.print("BST Post: "); bst.printPostOrder(); 
		
		
		System.out.print("AVL Pre: "); avl.printPreOrder();
		System.out.print("AVL In: "); avl.printInOrder();
		System.out.print("AVL Post: "); avl.printPostOrder();
		System.out.println();
		
		System.out.println("ORIGINAL TREES");
		System.out.println();
		System.out.print("	BST:"); bst.printTree();
		System.out.println();
		System.out.println("	AST:"); avl.printTree();
		System.out.println();
		

		System.out.println("ORIGINAL TREES");
		System.out.println();
		System.out.print("	BST:");;
		System.out.println();
		bst.flip(); avl.printTree();
		System.out.print("	BST FLIPPED:");;
		
		
		System.out.println("	AST:"); avl.printTree();
		System.out.println();
		
		
/*Tested:
 * 	Prints	(above)
 *	Random positive integer inserts
 *	Remove, findMax (no children, one child, two children)
 *	[AVL] Balance (via insert) (right rotation, 
 right rotation, double left rotation, left rotation)
 
 Implicitly tested:
 	height, findMax, balance, balanceFactor, rotateRight, rotateleft
 */
	
		
		System.out.println("TESTING RANDOM INSERTs on BST & AST");
		System.out.println();
		int[] moreInsert = new int[TRIALS];
		
		System.out.println("..inserting random ints"); System.out.println();
		for(int i = TRIALS; i > 0; i--) {
			moreInsert[i-1] = (int) (Math.random() * 10) + 10; 
		}
		for(int i : moreInsert) {
			avl.insert(i);
			bst.insert(i);
		}
		
		System.out.println(" BST:"); System.out.println();
		bst.printTree();
		
		System.out.println(" AVL:"); System.out.println();
		avl.printTree();
		
		System.out.println("TESTING RANDOM REMOVE: ");
		for(int i : moreInsert) {
			avl.remove(i);
			bst.remove(i);
		}
		
		System.out.println(" Should be original BST:"); System.out.println();
		bst.printTree();
		
		System.out.println(" Should be original AVL:"); System.out.println();
		avl.printTree();
		
		System.out.println("TESTING REMOVE CASES (and findMax implicitly)");System.out.println();
	
		avl = new AVLTree<Integer>();
		bst = new BinarySearchTree<Integer>();
		int[] toInsert2 = {5,2,10,1,4,6,13};
		
		for(int i : toInsert2) {
			avl.insert(i);
			bst.insert(i);
		}
		
		System.out.println("	CASE 1: No children; remove(13)");
		System.out.println(" BST:"); System.out.println();
		bst.printTree();
		bst.remove(13);
		bst.printTree();
		System.out.println(" AVL:"); System.out.println();
		avl.printTree();
		avl.remove(13);
		avl.printTree();
		
		System.out.println("	CASE 2: One child; remove(10)");
		System.out.println(" BST:"); System.out.println();
		bst.printTree();
		bst.remove(10);
		bst.printTree();
		System.out.println(" AVL:"); System.out.println();
		avl.printTree();
		avl.remove(10);
		avl.printTree();
		
		System.out.println("	CASE 3: Two children; reset trees, remove(5)");
		
		//resetting trees
		avl = new AVLTree<Integer>();
		bst = new BinarySearchTree<Integer>();
		
		for(int i : toInsert2) {
			avl.insert(i);
			bst.insert(i);
		}
		
		
		//testing
		System.out.println(" BST:"); System.out.println();
		bst.printTree();
		bst.remove(5);
		bst.printTree();
		System.out.println(" AVL:"); System.out.println();
		avl.remove(5);
		avl.printTree();
	

		
		System.out.println("TESTING AVL BALANCE (via insert)"); System.out.println();
		System.out.println(); System.out.println("...with AVL specific cases [comparing to the slide examples]");
		//System.out.println(");
		System.out.println("	CASE 1: Insert 1 [Right Rotation]");
		avl = new AVLTree<Integer>();
		
		int[] toInsert_1 = {5,3};
		for(int i : toInsert_1) {
			avl.insert(i);
		}
		 avl.printTree(); System.out.println();
	
		 avl.insert(1);
		 avl.printTree();
		 
		 
		System.out.println("	CASE 2: Insert 7  [Double Right Rotation]");
		avl = new AVLTree<Integer>();
		int[] toInsert_2 = {10,5};
				for(int i : toInsert_2) {
					avl.insert(i);
				}
		avl.printTree(); System.out.println();
		avl.insert(7);
		avl.printTree();
		
		System.out.println("	CASE 3: Insert 11  [Double Left Rotation]");
		avl = new AVLTree<Integer>();
		int[] toInsert_3 = {10,12};
				for(int i : toInsert_3) {
					avl.insert(i);
				}
		avl.printTree(); System.out.println();
		avl.insert(11);
		avl.printTree();
		
		 System.out.println("	CASE 4: Insert 25  [Left Rotation]");
		 avl = new AVLTree<Integer>();
		 int[] toInsert_4 = {5,7};
			for(int i : toInsert_4) {
				avl.insert(i);
			}
			 avl.printTree(); System.out.println();
		
			 avl.insert(25);
			 avl.printTree(); 
	}
}
		

