package test;

import java.util.PriorityQueue;

import priorityqueue.MinHeap;

public class MyTest {

	final static int NUM_TESTS = 1000000;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("-------Binary Heap PQ");
		System.out.println("INSERT--PEEK---POLL--");
		for (int trials = 10; trials > 0; trials--) {
			// System.out.println("Trial :" + (10 - trials));
			System.out.println();
			int t = (int) System.currentTimeMillis();

			MinHeap<Integer> mh = new MinHeap<Integer>();
			for (int i = 0; i < NUM_TESTS; i++) {
				Integer r = (int) (Math.random() * NUM_TESTS);
				mh.push(r);
			}
			int time = ((int) System.currentTimeMillis()) - t;
			System.out.print(time);
			// System.out.println(" ");
			for (int i = 0; i < NUM_TESTS; i++) {
				mh.peek();
			}
			time = ((int) System.currentTimeMillis()) - t;
			System.out.print("	" + time);
			// System.out.println(" ");
			for (int i = 0; i < NUM_TESTS; i++) {
				mh.poll();
			}
			// System.out.println("DONE");
			time = ((int) System.currentTimeMillis()) - t;
			System.out.print("	" + time);

		}
		System.out.println();
		System.out.println("-------Java Built in PQ");
		System.out.println();

		System.out.println("INSERT--PEEK---POLL--");
		for (int trials = 10; trials > 0; trials--) {
			// System.out.println("Trial :" + (10 - trials));
			System.out.println();
			int t = (int) System.currentTimeMillis();

			PriorityQueue<Integer> m = new PriorityQueue<Integer>();
			for (int i = 0; i < NUM_TESTS; i++) {
				Integer r = (int) (Math.random() * NUM_TESTS);
				m.add(r);
			}
			int time = ((int) System.currentTimeMillis()) - t;
			System.out.print(time);
			// System.out.println(" ");
			for (int i = 0; i < NUM_TESTS; i++) {
				m.peek();
			}
			time = ((int) System.currentTimeMillis()) - t;
			System.out.print("	" + time);
			// System.out.println(" ");
			for (int i = 0; i < NUM_TESTS; i++) {
				m.poll();
			}
			// System.out.println("DONE");
			time = ((int) System.currentTimeMillis()) - t;
			System.out.print("	" + time);

		}

	}

}
