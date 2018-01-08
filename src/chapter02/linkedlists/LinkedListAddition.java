package chapter02.linkedlists;

import chapter02.linkedlists.LinkedList.Node;

/**
 * Add given two numbers represented as linked list where the digits are stored
 * in a reverse manner.
 * 
 * @author skedia
 *
 */
public class LinkedListAddition {

	public static void main(String[] args) {
		LinkedList l1 = new LinkedList();
		l1.add(9);
		l1.add(2);
		l1.add(4);
		l1.add(5);
		LinkedList l2 = new LinkedList();
		l2.add(2);
		l2.add(4);
		l2.add(3);
		l2.add(1);
		// l2.add(4);
		LinkedList l3 = new LinkedList();
		System.out.println(new LinkedListAddition().addLinkedList(l1.head, l2.head, l3.head, 0));
	}

	public Node addLinkedList(Node n1, Node n2, Node n3, int carry) {
		if (n1 == null && n2 == null) {
			if (carry != 0) {
				Node c = new Node();
				c.d = carry;
				n3.n = c;
			}
			return n3;
		}

		n3 = new Node();
		n3.d = ((n1 == null ? 0 : n1.d) + (n2 == null ? 0 : n2.d) + carry) % 10;
		carry = ((n1 == null ? 0 : n1.d) + (n2 == null ? 0 : n2.d)) / 10;

		n3.n = addLinkedList(n1.n, n2.n, n3.n, carry);

		return n3;

	}

}
