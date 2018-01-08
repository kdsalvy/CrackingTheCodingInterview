package chapter02.linkedlists;

import chapter02.linkedlists.LinkedList.Node;

/**
 * Find Loop in List and then return the node from where the loop starts
 * 
 * @author skedia
 *
 */
public class LoopInList {

	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		list.add(6);
		list.add(7);
		list.add(8);
		list.add(9);

		LoopInList lil = new LoopInList();

		list = lil.linkLastAndMiddleNode(list);
		Node loopStartingNode = lil.getStartingNodeOfLoop(list);
		loopStartingNode.n = null;
		System.out.println(loopStartingNode);

	}

	public LinkedList linkLastAndMiddleNode(LinkedList list) {
		if (list.head == null)
			return list;
		Node mNode = getMiddleNode(list);
		Node lNode = getLastNode(list);

		lNode.n = mNode;
		return list;
	}

	private Node getLastNode(LinkedList list) {
		Node p = list.head;
		while (p.n != null)
			p = p.n;
		return p;
	}

	private Node getMiddleNode(LinkedList list) {
		Node p1 = list.head.n;
		Node p2 = list.head;

		while (p1 != null) {
			p1 = p1.n;
			if (p1 != null) {
				p2 = p2.n;
				p1 = p1.n;
			}
		}
		return p2;
	}

	public Node getStartingNodeOfLoop(LinkedList list) {
		if (list.head == null)
			return list.head;
		Node n1 = list.head.n;
		Node n2 = list.head;
		Node n3 = list.head;

		// n1 = n2 will confirm that the loop exists in the list
		while (n1 != null && n2 != null && n1 != n2) {
			n1 = n1.n;
			if (n1 != null) {
				n2 = n2.n;
				n1 = n1.n;
			}
		}

		// when n3 will reach n2, n1 will reach the start of the loop
		while (n3 != n2) {
			n3 = n3.n;
			n1 = n1.n;
		}

		return n3;
	}

}
