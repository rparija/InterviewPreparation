package practice;

public class LinkedListPractice {

	static LinkedNode head;

	public LinkedListPractice(LinkedNode node) {
		head = node;
	}

	public static boolean isCyclePresent() {
		LinkedNode singleNode = head;
		LinkedNode doubleNode = head.next.next;

		while (doubleNode != null) {
			if (singleNode.data == doubleNode.data) {
				return true;
			}
			doubleNode = doubleNode.next.next;
			singleNode = singleNode.next;
		}
		return false;
	}

	public static LinkedNode intersectionPoint(LinkedNode node1, LinkedNode node2) {
		int lengthofNode1 = 0;
		int lengthofNode2 = 0;
		LinkedNode temp1 = node1;
		LinkedNode temp2 = node2;
		while (node1.next != null) {
			lengthofNode1++;
			node1 = node1.next;
		}
		while (node2.next != null) {
			lengthofNode2++;
			node2 = node2.next;
		}
		int diff = 0;
		if (lengthofNode1 > lengthofNode2) {
			diff = lengthofNode1 - lengthofNode2;

			while (diff > 0) {
				temp1 = temp1.next;
				diff--;
			}

		} else {
			diff = lengthofNode2 - lengthofNode1;

			while (diff > 0) {
				temp2 = temp2.next;
				diff--;
			}
		}

		while (temp1.next != null) {
			if (temp1.data == temp2.data) {
				return temp1;
			}
			temp1 = temp1.next;
			temp2 = temp2.next;
		}

		return temp1 = null;
	}

	public static void insert(int value) {
		LinkedNode node = new LinkedNode(value, null);
		if (head == null) {
			head = node;
		} else {
			LinkedNode temp = head;
			while (temp.next != null) {
				temp = temp.next;
			}
			temp.next = node;
		}
	}

	public static void insertAtNthPosition(int value, int position) {
		LinkedNode node = new LinkedNode(value, null);
		if (head == null) {
			head = node;
		} else {
			LinkedNode tempNode = head;
			LinkedNode prev = tempNode;
			--position;
			if (position == 0) {
				node.next = tempNode;
				head=node;
			} else {
				while (tempNode.next != null && position != 0) {
					prev = tempNode;
					tempNode = tempNode.next;
					--position;
				}
				if (position == 0) {
					node.next = tempNode;
					prev.next = node;
				}else if(tempNode.next==null && position==1)
				{
					tempNode.next=node;
				}
				else {
					System.out.println("Node position:" + position + " is invalid");
				}
			}
		}
	}

	public static void print() {
		LinkedNode temp = head;
		while (temp != null) {
			System.out.println(temp.data);
			temp = temp.next;
		}
	}

	public static void reverse() {
		LinkedNode prev = null;
		LinkedNode curr = head;
		while (curr != null) {
			LinkedNode next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		head = prev;
	}

	public static void main(String[] args) {

		LinkedNode node = new LinkedNode(10, null);
		LinkedListPractice node1 = new LinkedListPractice(node);
		insert(20);
		insert(30);
		insert(40);
		insertAtNthPosition(25, 5);
		// head.next.next.next.next=head;
		// System.out.println(isCyclePresent());
		print();
		/*
		 * LinkedNode node2= new LinkedNode(100, null); LinkedListPractice node3= new
		 * LinkedListPractice(node2); insert(200); insert(300);
		 */
		// reverse();
		// print();

		// LinkedNode node4=intersectionPoint(node, node2);
		// System.out.println("Intersection found at "+ node4!=null?node4.data:null);
	}
}
