package chapter03.stacks.and.queues;

import java.util.Stack;

/**
 * Implement a queue using 2 stacks
 * 
 * @author skedia
 *
 */
public class QueueUsingTwoStacks {

	Stack<Integer> s1 = null;
	Stack<Integer> s2 = null;

	public QueueUsingTwoStacks() {
		s1 = new Stack<>();
		s2 = new Stack<>();
	}

	public void enqueue(int d) {
		s1.push(d);
	}

	public int dequeue() {
		while (!s1.isEmpty())
			s2.push(s1.pop());
		int item = s2.pop();
		while (!s2.isEmpty())
			s1.push(s2.pop());
		return item;
	}

	public static void main(String[] args) {
		QueueUsingTwoStacks queue = new QueueUsingTwoStacks();
		for (int i = 1; i <= 5; i++) {
			queue.enqueue(i);
		}

		for (int i = 1; i <= 5; i++) {
			System.out.println(queue.dequeue());
		}
	}

}
