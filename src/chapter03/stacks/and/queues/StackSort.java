package chapter03.stacks.and.queues;

import java.util.Random;
import java.util.Stack;

/**
 * Sort a given stack
 * 
 * @author skedia
 *
 */
public class StackSort {

	public void sort(Stack<Integer> s1) {
		if (s1.isEmpty())
			return;
		int temp = s1.pop();
		sort(s1);
		insertInPlace(temp, s1);
	}

	public void insertInPlace(int temp, Stack<Integer> s1) {
		if (s1.isEmpty() || s1.peek() < temp) {
			s1.push(temp);
			return;
		}
		int d = s1.pop();
		insertInPlace(temp, s1);
		s1.push(d);

	}

	public static void main(String[] args) {
		StackSort ss = new StackSort();
		Stack<Integer> stack = new Stack<>();

		for (int i = 0; i < 10; i++)
			stack.push(new Random().nextInt(100));

		System.out.println("Unsorted: " + stack);

		ss.sort(stack);

		System.out.println("Sorted: " + stack);
	}

}
