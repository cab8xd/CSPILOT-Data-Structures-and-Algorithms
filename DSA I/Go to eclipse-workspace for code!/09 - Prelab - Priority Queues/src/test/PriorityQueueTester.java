package test;

import java.util.ArrayList;
import java.util.HashMap;

import priorityqueue.MinHeap;

public class PriorityQueueTester {

	public static <T extends Comparable<T>> void heapSort(ArrayList<T> list) {
		// TODO: WRITE THIS METHOD

		/*
		 * 1) Make a heap 2) Insert n elements 3) Remove n elements
		 */
		if (list.size() == 0)
			return;
		MinHeap<T> sh = new MinHeap<T>(list);
		for (int c = 0; c < list.size(); c++) {
			list.set(c, sh.poll());

		}

	}

	// EVERYTHING BELOW IS USED FOR TESTING
	// ----------------------------------------

	public static <T extends Comparable<T>> boolean checkSorted(ArrayList<T> data) {
		for (int i = 1; i < data.size(); i++) {
			if (data.get(i - 1).compareTo(data.get(i)) > 0)
				return false;
		}
		return true;
	}

	public static <T extends Comparable<T>> boolean checkSameElements(ArrayList<T> l1, ArrayList<T> l2) {
		if (l1.size() != l2.size())
			return false;

		HashMap<T, Integer> count = new HashMap<T, Integer>();
		for (T key : l1) {
			if (!count.containsKey(key))
				count.put(key, 1);
			else
				count.put(key, count.get(key) + 1);
		}
		for (T key : l2) {
			if (!count.containsKey(key))
				return false;
			else
				count.put(key, count.get(key) - 1);
		}
		for (T key : count.keySet()) {
			if (count.get(key) != 0)
				return false;
		}
		return true;
	}

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {

		System.out.println("------TEST 1------");
		int NUM_TESTS = 10000;

		// TEST 1: TESTING PUSH AND POLL

		ArrayList<Integer> list = new ArrayList<Integer>();

		System.out.print("Adding new elements to a list...");
		for (int i = 0; i < NUM_TESTS; i++) {
			Integer r = (int) (Math.random() * NUM_TESTS);
			list.add(r);
		}
		System.out.println("DONE");

		ArrayList<Integer> list2 = (ArrayList<Integer>) list.clone();

		System.out.print("Pushing elements to a heap...");
		MinHeap<Integer> mh = new MinHeap<Integer>();
		for (int i = 0; i < NUM_TESTS; i++)
			mh.push(list.get(i));
		System.out.println("DONE");

		System.out.print("Removing elements...");
		for (int i = 0; i < NUM_TESTS; i++) {
			list.set(i, mh.poll());
		}
		System.out.println("DONE");

		System.out.print("Checking if removal seemed to work...");

		if (list.size() == NUM_TESTS && checkSorted(list) && checkSameElements(list, list2)) {
			System.out.println("LOOKS GOOD");
		} else
			System.out.println("ERROR...Something went wrong");

		System.out.println("------TEST 2------");

		// TEST 2: TESTING HEAPIFY
		list = new ArrayList<Integer>();

		System.out.print("Adding new elements to a list...");
		for (int i = 0; i < NUM_TESTS; i++) {
			Integer r = (int) (Math.random() * NUM_TESTS);
			list.add(r);
		}
		System.out.println("DONE");

		list2 = (ArrayList<Integer>) list.clone();

		System.out.print("Creating heap from list...");
		mh = new MinHeap<Integer>(list);
		System.out.println("DONE");
		System.out.println("heap:");
		System.out.print("Removing elements...");
		for (int i = 0; i < NUM_TESTS; i++) {
			list.set(i, mh.poll());
		}
		System.out.println("DONE");

		System.out.print("Checking if removal seemed to work...");
		if (list.size() == NUM_TESTS && checkSorted(list) && checkSameElements(list, list2)) {
			System.out.println("LOOKS GOOD");
		} else
			System.out.println("ERROR...Something went wrong");

		list = new ArrayList<Integer>();

		System.out.print("Adding elements to list...");
		for (int i = 0; i < NUM_TESTS; i++) {
			Integer r = (int) (Math.random() * NUM_TESTS);
			list.add(r);
		}
		System.out.println("DONE");

		list2 = (ArrayList<Integer>) list.clone();

		System.out.print("Calling heapSort...");
		heapSort(list);
		System.out.println("DONE");

		System.out.print("Checking if same elements came out sorted...");
		if (list.size() == NUM_TESTS && checkSorted(list) && checkSameElements(list, list2)) {
			System.out.println("LOOKS GOOD");
		} else
			System.out.println("ERROR...Something went wrong");

	}
}
