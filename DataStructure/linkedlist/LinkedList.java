package linkedlist;

public class LinkedList {
	public static Node head;

	public static Node insert(int data) {
		Node node = new Node();
		node.data = data;
		node.next = null;

		if (head == null) {
			head = node;
		} else {
			Node newNode = head;
			while (newNode.next != null) {
				newNode = newNode.next;
			}
			newNode.next = node;
		}
		return head;
	}

	public static Node insertNodeAtStart(int data) {
		Node node = new Node();
		node.data = data;
		node.next = null;
		if (head == null) {
			head = node;
		} else {
			node.next = head;
			Node oldNode = head;
			while (oldNode.next != null) {
				oldNode = oldNode.next;
			}
			head = node;
		}
		return head;
	}

	public static void insertNodeAtNthPosition(int data, int n) {
		Node newNode = new Node();
		newNode.data = data;
		newNode.next = null;
		if (head == null) {
			head = newNode;
		} else {
			if (n == 1) {
				newNode.next = head;
				head = newNode;
			} else {
				Node node = head;
				int i = 1;
				while (i < n - 1 && node.next != null) {
					node = node.next;
					i++;
				}
				Node tempNode = node.next;
				node.next = newNode;
				newNode.next = tempNode;
			}
		}

	}

	public static void deleteNodeAtNthPosition(int n) {

		if (head == null) {

		} else {
			if (n == 1) {
				Node oldNode = head;
				head = oldNode.next;
			} else {
				Node oldNode = head;
				int i = 1;
				while (i < n - 1 && oldNode.next != null) {
					oldNode = oldNode.next;
					i++;
				}
				Node tempNode = oldNode.next;
				oldNode.next = tempNode.next;
			}
		}

	}

	public static void show() {
		Node node = head;
		while (node.next != null) {
			System.out.println(node.data);
			node = node.next;
		}
		System.out.println(node.data);
	}

	public static Node removeNthFromEnd(Node head, int n) {
		if (head == null || head.next == null) {

			return head = null;
		}
		Node temp = head;
		int i = 1;
		while (temp.next != null) {
			i++;
			temp = temp.next;
		}
		temp = head;
		if(i==n)
		{
			temp=temp.next;
			return temp;
		}
		i -= n;

		while (i-1 > 0) {
			i--;
			temp = temp.next;
		}
		
		Node t = temp.next;
		temp.next = t.next;
		return head;
	}

	public static void main(String[] args) {
		/*
		 * insertNodeAtStart(12); insertNodeAtStart(13); insertNodeAtStart(14);
		 * insertNodeAtStart(15); insertNodeAtStart(16); show();
		 * insertNodeAtNthPosition(17, 1); show(); deleteNodeAtNthPosition(3); show();
		 */
		insert(1);
		Node n = insert(2);
		 /*insert(3);
		 insert(4);
		 n=insert(5);
		*/n = removeNthFromEnd(n, 2);
		System.out.println(n);
	}

}
