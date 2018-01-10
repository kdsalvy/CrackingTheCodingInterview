package chapter03.stacks.and.queues;

import java.util.Random;

/**
 * Design a stack which has three methods, push, pop and min with each having
 * time complexity as O(1)
 * 
 * @author skedia
 *
 */
public class StackPushPopMin {

	class Stack {
		Node top;

		void push(int d) {
			Node n = new Node();
			n.d = d;
			n.prev = top;
			if (top == null)
				n.min = d;
			else
				n.min = Math.min(top.min, d);
			top = n;
		}

		int pop() {
			int pop = top.d;
			top = top.prev;
			return pop;
		}

		int min() {
			if (top != null)
				return top.min;
			else
				return -1;
		}

	}

	class Node {
		int d;
		Node prev;
		int min;
	}

	public static void main(String[] args) {
		StackPushPopMin sPPM = new StackPushPopMin();
		Stack s = sPPM.new Stack();
		for (int i = 0; i < 20; i++)
			s.push(new Random().nextInt(100));
		for (int i = 0; i < 20; i++) {
			System.out.print("Min: " + s.min());
			System.out.print(" :: Pop: " + s.pop());
			System.out.println("");
		}
	}

}
