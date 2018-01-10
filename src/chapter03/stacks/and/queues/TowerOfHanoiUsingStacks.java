package chapter03.stacks.and.queues;

import java.util.Stack;

public class TowerOfHanoiUsingStacks {

	public static void main(String[] args) {
		Stack<Integer> A = new Stack<>();
		Stack<Integer> B = new Stack<>();
		Stack<Integer> C = new Stack<>();

		A.push(5);
		A.push(4);
		A.push(3);
		A.push(2);
		A.push(1);

		towerOfHanoi(5, A, B, C);
		System.out.println(B.toString());
	}

	private static void towerOfHanoi(int i, Stack<Integer> a, Stack<Integer> b, Stack<Integer> c) {
		if (i == 1) {
			b.push(a.pop());
			return;
		}
		towerOfHanoi(i - 1, a, c, b);
		b.push(a.pop());
		towerOfHanoi(i - 1, c, b, a);
	}
}
