package chapter02.linkedlists;

import java.util.HashSet;
import java.util.Set;

import chapter02.linkedlists.LinkedList.Node;

/**
 * Remove duplicates from an unsorted linked list. Try to do it without using
 * buffer space as well.
 * 
 * @author skedia
 *
 */
public class RemoveDuplicates {

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

		RemoveDuplicates rd = new RemoveDuplicates();
		// rd.removeDuplicatesWithBuffer(list);
		// System.out.println(list);
		list = rd.removeDuplicatesWithoutBuffer(list);
		System.out.println(list);

	}

	public void removeDuplicatesWithBuffer(LinkedList list) {
		Set<Integer> set = new HashSet<>();
		Node node = list.head;
		Node prev = null;
		while (node != null) {
			if (set.contains(node.d)) {
				prev.n = node.n;
			} else {
				set.add(node.d);
				prev = node;
			}
			node = node.n;
		}
	}

	// sort in place and remove
	public LinkedList removeDuplicatesWithoutBuffer(LinkedList list) {
		if (list.head == null)
			return list;
		// sort the list
		list.head = sort(list.head);

		// if adjacent nodes are same then remove
		Node p1 = list.head;
		Node p2 = list.head.n;

		while (p2.n != null) {
			if (p1.d == p2.d) {
				p1.n = p2.n;
				p2 = p2.n;
			} else {
				p1 = p2;
				p2 = p2.n;
			}
		}
		return list;
	}

	// use merge sort to sort the linked list
	public Node sort(Node node) {
		if (node.n == null)
			return node;

		// find the middle node and break linkage from there
		Node p1 = getMiddleNode(node);
		// p1 will be at the middle point now separate it from right half
		Node nextOfMiddle = p1.n;
		p1.n = null;

		Node lH = sort(node);
		Node rH = sort(nextOfMiddle);

		return sortedMerge(lH, rH);

	}

	private Node getMiddleNode(Node node) {
		if (node == null)
			return node;
		Node p1 = node;
		Node p2 = node.n;
		while (p2 != null) {
			p2 = p2.n;
			if (p2 != null) {
				p1 = p1.n;
				p2 = p2.n;
			}
		}
		return p1;
	}

	private Node sortedMerge(Node lH, Node rH) {
		Node temp = new Node();
		Node result = temp;
		// base cases
		if (lH == null)
			return rH;
		if (rH == null)
			return lH;

		while (lH != null && rH != null) {
			if (lH.d <= rH.d) {
				temp.n = lH;
				lH = lH.n;
				temp = temp.n;
			} else if (lH.d > rH.d) {
				temp.n = rH;
				rH = rH.n;
				temp = temp.n;
			}
		}

		while (lH != null) {
			temp.n = lH;
			lH = lH.n;
			temp = temp.n;
		}
		while (rH != null) {
			temp.n = rH;
			rH = rH.n;
			temp = temp.n;
		}

		return result.n;
	}
}
