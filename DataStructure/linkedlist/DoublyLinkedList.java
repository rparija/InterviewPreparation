package linkedlist;

public class DoublyLinkedList {

	static Node head;

	public static void insertAtHead(int data) {
		Node node = new Node();
		node.data = data;
		node.next = null;
		node.prev = null;
		if (head == null) {
			head = node;
		} else {
			Node oldNode=head;
			oldNode.prev=node;
			node.next=oldNode;
			head=node;
		}
	}

	public static void insertAtTail(int data) {
		Node node = new Node();
		node.data = data;
		node.next = null;
		node.prev = null;
		if (head == null) {
			head = node;
		} else {
			Node oldNode = head;
			while (oldNode.next != null) {
				oldNode = oldNode.next;
			}
			oldNode.next = node;
			node.prev = oldNode;
			oldNode = null;
		}
	}

	public static void print(Node node) {
		if (node != null) {
			System.out.println("LinkedList traversal");
			while (node.next != null) {
				System.out.print(node.data + ",");
				node = node.next;
			}
			System.out.print(node.data);
			System.out.println();
		}

	}

	public static void reversePrint(Node node) {
		if (node != null) {
			System.out.println("LinkedList traversal in Reverse");
			while (node.next != null) {
				node = node.next;
			}
			while (node.prev != null) {
				System.out.print(node.data + ",");
				node = node.prev;
			}
			System.out.println(node.data);
		}

	}

	public static void main(String[] args) {

		insertAtTail(40);
		insertAtHead(10);
		insertAtHead(20);
		insertAtHead(30);
		print(head);
		reversePrint(head);
		head = null;
	}
}
