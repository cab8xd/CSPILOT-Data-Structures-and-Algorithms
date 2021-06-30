package priorityqueue;

import java.util.ArrayList;

public class MinHeap<T extends Comparable<T>> implements PriorityQueue<T> {

	/* The actual heap of data */
	private ArrayList<T> heap;

	/* number of elements in the heap */
	private int size = 0;

	public MinHeap() {
		// TODO: WRITE THIS METHOD
		this.heap = new ArrayList();
		heap.add(null);
		size++;

	}

	// Constructs a heap from the given array
	// pre - filled with the data in the heap
	// data may need to be restructured

	public MinHeap(ArrayList<T> data) {
		heap = new ArrayList();
		heap.add(null);
		// TODO: WRITE THIS METHOD
		for (T e : data) {
			push(e);
		}
		size = heap.size();
		heapify();
		return;
	}

	/* helper methods */
	// Turns the internal array without
	// heap ordering property into the
	// equivalent heap with the ordering property

	// Note: this method does not work well. Push compensates for the ordering in
	// the second constructor instead of heapify (though it is implemented anyway).
	private void heapify() {
		for (int i = 1; i < Math.floorDiv(size, 2); i++) {
			percolateDown(i);
		}
	}

	/* places the value T onto the heap */
	@Override
	public void push(T data) {
		// TODO: WRITE THIS METHOD
		heap.add(data);
		if (size > 0)
			percolateUp(size); // Starts at the end of the list (new object location.)

		size++;
	}

	// Percolate the item at index up until
	// the ordering property is restored
	private void percolateUp(int index) {
		// TODO: WRITE THIS METHOD
		if (index <= 1) {
			// System.out.println("Base Case: index <= 1 ");
			return;
		}
		int pIndex = Math.floorDiv(index, 2); // Eh.

		if (heap.get(index).compareTo(heap.get(pIndex)) < 0) {
			// System.out.println("child < parent --> swap + recurse");
			swap(index, pIndex); // Need Helper Method.
			percolateUp(pIndex); // Recursion

		}
	}

	private void swap(int a, int b) {
		// System.out.println("Swapping " + heap.get(a) + " and " + heap.get(b));
		T aItem = heap.get(a);
		if (heap.get(a) == null || heap.get(b) == null)
			return;
		heap.set(a, heap.get(b));
		heap.set(b, aItem);
	}

	// Percolate the item at index down until
	// the ordering property is restored
	private void percolateDown(int index) {
		// TODO: WRITE THIS METHOD

		int child;
		T t = heap.get(index);

		for (; index * 2 <= size; index = child) {

			child = index * 2;
			if (child != size && heap.get(child + 1).compareTo(heap.get(child)) < 0)
				child++;
			if (heap.get(child).compareTo(t) < 0)
				heap.set(index, heap.get(child));
			else
				break;
		}
		heap.set(index, t);
	}

	/* priority queue interface */

	/*
	 * removes and returns the item with next priority (i.e., lowest value ) The
	 * Minimum gets removes.
	 */
	@Override
	public T poll() {
		// Null Case
		if (size < 1) {
			System.out.println("Empty");
			return null;
		}

		// Minimum item.
		T ret = heap.get(1);

		// Base case
		if (size == 1) {
			return ret;
		}
		// Recursive Case
		else {
			heap.set(1, heap.get(size - 1));
			size--;
			percolateDown(1);
			return ret;
		}

	}

	/* returns the next item to be polled , without removing */
	@Override
	public T peek() {
		// TODO: WRITE THIS METHOD

		if (!(!heap.contains(null)) || size == 0) {
			return null;
		} else {
			return heap.get(1);
		}

	}

	/* returns number of elements on the heap */
	@Override
	public int size() {
		// TODO: WRITE THIS METHOD
		return size;
	}

	public void printTree() {
		printTree(1, 0);
		System.out.println("\n\n");
	}

	private void printTree(int curNode, int indentLev) {
		if (curNode < 1 || curNode >= size)
			return;
		for (int i = 0; i < indentLev; i++) {
			if (i == indentLev - 1)
				System.out.print("|-----");
			else
				System.out.print("      ");
		}
		System.out.println(heap.get(curNode));
		printTree(curNode * 2, indentLev + 1);
		printTree(curNode * 2 + 1, indentLev + 1);
	}

	/*
	 * In Lab 9 Heaps
	 * 
	 * 
	 * 1. update Priority:
	 * 
	 * Add a new method to your MinHeap called updatePriority(T oldElement, T
	 * newElement). This method should find oldElement in the heap, update it to be
	 * set to newElement instead, and then make sure the heap ordering property
	 * still holds.
	 * 
	 * 
	 * 1. remove the old element 2. push the new element
	 */
	private void updatePriority(T oldElement, T newElement) {
		ArrayList<T> h = new ArrayList();
		h = heap;
		heap = new ArrayList();
		for (T e : h) {
			push(e);
			if (peek().equals(oldElement)) {
				poll();
				push(newElement);
				break;
			}
		}

	}

	/*
	 * 2. Write a method called computeProduct(ArrayList<Integer> list, int i). This
	 * method should return the product of the smallest i elements in the given
	 * list. Note that list is not provided to you in sorted order. Use a MinHeap to
	 * solve this problem
	 */

	// Pseudocode:

	/*
	 * push each element into a heap Poll through the list to the two smallest items
	 * return the product
	 */

}
