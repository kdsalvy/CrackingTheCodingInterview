package chapter02.linkedlists;

import chapter02.linkedlists.LinkedList.Node;

/**
 * Write a method to return nth node from last node of a linked list
 * 
 * @author skedia
 *
 */
public class NthNodeFromLast {

	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		list.add(9);
		list.add(2);
		list.add(4);
		list.add(5);
		list.add(2);
		list.add(4);
		list.add(10);
		list.add(15);
		list.add(4);

		int n = 3;

		NthNodeFromLast nfl = new NthNodeFromLast();
		System.out.println(nfl.findNthNodeFromEnd(list, n));
	}

	/**
	 * Take two pointers and start iterating the second pointer when the
	 * distance between the pointers is equal to given n.
	 * 
	 * @param list
	 * @param n
	 * @return
	 */
	public Node findNthNodeFromEnd(LinkedList list, int n) {
		if (list.head == null)
			return list.head;

		Node p1 = list.head;
		Node p2 = list.head;

		if (n == 1) {
			while (p1.n != null)
				p1 = p1.n;
			return p1;
		}

		int i = 0;
		while (p1 != null) {
			if (i >= n)
				p2 = p2.n;
			p1 = p1.n;
			i++;
		}
		p2.n = null;
		return p2;
	}

}
