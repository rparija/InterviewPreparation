package linkedlist;

/*Get count of the nodes in the first list, let count be c1.
Get count of the nodes in the second list, let count be c2.
Get the difference of counts d = abs(c1 – c2)
Now traverse the bigger list from the first node till d nodes so that from here onwards both the lists have equal no of nodes.
Then we can traverse both the lists in parallel till we come across a common node. 
(Note that getting a common node is done by comparing the address of the nodes)*/

public class LinkedListIntersection {
	public Node getIntersectionNode(Node headA, Node headB) {

		if (headA == null || headB == null) {
			return null;
		}
		Node node = headA;
		int i = 0;
		while (node.next != null) {
			node = node.next;
			i++;
		}

		node = headB;
		int j = 0;
		while (node.next != null) {
			node = node.next;
			j++;
		}
		int k = 0;
		Node secNode = null;
		if (i < j) {
			k = j - i;
			node = headB;
			while (k > 0) {
				node = node.next;
				k--;
			}

			secNode = headA;

		} else {
			k = i - j;
			node = headA;
			while (k > 0) {
				node = node.next;
				k--;
			}

			secNode = headB;

		}
		while (node != null && secNode != null) {

			if (node == secNode) {
				return secNode;
			}
			secNode = secNode.next;

			node = node.next;

		}
		return null;

	}
}