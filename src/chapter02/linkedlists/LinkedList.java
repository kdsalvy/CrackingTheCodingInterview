package chapter02.linkedlists;

public class LinkedList {
	Node head;

	public static class Node {
		int d;
		Node n;

		@Override
		public String toString() {
			return "Node [d=" + d + ", n=" + n + "]";
		}
	}

	public void add(int d) {
		if (head == null) {
			head = new Node();
			head.d = d;
		} else {
			Node temp = head;
			while (temp.n != null) {
				temp = temp.n;
			}
			temp.n = new Node();
			temp.n.d = d;
		}
	}

	public int size() {
		int i = 1;
		Node temp = head;
		while (temp != null)
			i++;
		return i;
	}

	@Override
	public String toString() {
		return "LinkedList [head=" + head + "]";
	}
}
