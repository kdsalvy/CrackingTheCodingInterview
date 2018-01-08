package chapter02.linkedlists;

import chapter02.linkedlists.LinkedList.Node;

/**
 * Delete middle node of a given linked list if only the pointer to that middle
 * node is provided
 * 
 * @author skedia
 *
 */
public class MiddleNodeDeletion {
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

		MiddleNodeDeletion mnd = new MiddleNodeDeletion();
		Node mNode = mnd.getMiddleNode(list.head);
		mnd.deleteMiddleNode(mNode);
		System.out.println(list);
	}

	public void deleteMiddleNode(Node middleNode) {
		if (middleNode == null)
			return;
		while (middleNode != null) {
			middleNode.d = middleNode.n.d;
			if (middleNode.n.n == null)
				middleNode.n = null;
			middleNode = middleNode.n;
		}
	}

	public Node getMiddleNode(Node node) {
		if (node == null)
			return node;
		Node fPtr = node.n;
		Node sPtr = node;

		while (fPtr != null) {
			fPtr = fPtr.n;
			if (fPtr != null) {
				sPtr = sPtr.n;
				fPtr = fPtr.n;
			}
		}
		return sPtr;
	}

}
