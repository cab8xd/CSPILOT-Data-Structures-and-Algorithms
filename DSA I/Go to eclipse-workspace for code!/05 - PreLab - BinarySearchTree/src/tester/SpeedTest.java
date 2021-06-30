package tester;

import tree.BinarySearchTree;

//have test cases

// 5 2 10 6 remove 2

import java.util.ArrayList;

import tree.AVLTree;

public class SpeedTest {

	public static void main(String[] args) {
		int numElements = 1000000;
		
		BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();
		AVLTree<Integer> avl = new AVLTree<Integer>();
	
		
		ArrayList<Integer> toAdd = new ArrayList<Integer>();
		for(int i=0; i<numElements; i++) {
			toAdd.add((int)(Math.random()*(numElements)+i)); //Possible Errors?
		}
		
		System.out.print("Inserting into BST...");
		for(int i=0; i<numElements; i++) {
			bst.insert(toAdd.get(i));
			//System.out.print(toAdd.get(i));
		}
		System.out.println("DONE");
		
		System.out.print("Searching in BST...");
		for(int i=0; i<numElements; i++) {
			if(!bst.find(toAdd.get(i))) {
				System.out.println("FATAL ERROR: Element " + i + " was not found in your tree!");
				System.exit(1);
			}
		}
		System.out.println("DONE");
		
		System.out.print("Inserting into AVL...");
		for(int i=0; i<numElements; i++) {
			avl.insert(toAdd.get(i));
		}
		System.out.println("DONE");
		
		System.out.print("Searching in AVL...");
		for(int i=0; i<numElements; i++) {
			if(!avl.find(toAdd.get(i))) {
				System.out.println("FATAL ERROR: Element " + i + " was not found in your tree!");
				System.exit(1);
			}
		}
		System.out.println("DONE");
		
		System.out.println("Height of BST: " + bst.height());
		System.out.println("Height of AVL: " + avl.height());
	
	}
}
