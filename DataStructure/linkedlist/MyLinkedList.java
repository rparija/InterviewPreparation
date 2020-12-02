package linkedlist;

class MyLinkedList {

	class Node {
		int data;
		Node next;
	};

	static Node head;

	/** Initialize your data structure here. */
	public MyLinkedList() {
		head = null;
	}

	/**
	 * Get the value of the index-th node in the linked list. If the index is
	 * invalid, return -1.
	 */
	public int get(int index) {
		if (head != null && head.next!=null) {
			if (index == 0) {
				return head.data;
			}
			Node node = head;
			int i = 0;
			while (i < index-1 && node.next != null) {
				node = node.next;
				i++;
			}
			if(node== null || node.next==null )
			{
				return -1;
			}
			
			node=node.next;
			
			return node.data;

		}
		return -1;
	}

	/**
	 * Add a node of value val before the first element of the linked list. After
	 * the insertion, the new node will be the first node of the linked list.
	 */
	public void addAtHead(int val) {
		Node node = new Node();
		node.data = val;
		if (head == null) {
			head = node;
		} else {
			Node oldNode = head;
			node.next = oldNode;
			head = node;
			oldNode = null;
		}
	}

	/** Append a node of value val to the last element of the linked list. */
	public void addAtTail(int val) {
		Node node = new Node();
		node.data = val;
		if (head == null) {
			head = node;
		} else {
			Node oldNode = head;
			while (oldNode.next != null) {
				oldNode = oldNode.next;
			}
			oldNode.next = node;
			oldNode = null;
		}

	}

	/**
	 * Add a node of value val before the index-th node in the linked list. If index
	 * equals to the length of linked list, the node will be appended to the end of
	 * linked list. If index is greater than the length, the node will not be
	 * inserted.
	 */
	public void addAtIndex(int index, int val) {
		Node node = new Node();
		node.data = val;
		if (head == null) {
			head = node;
		}else if(index==0)
		{
			Node tempNode = head;
            node.next=tempNode;
			head = node;
			tempNode = null;
		} 
        else {

			Node oldNode = head;
			int i = 0;
			while (i < index - 1 && oldNode != null) {
				oldNode = oldNode.next;
				i++;
			}
			if (oldNode==null ||oldNode.next==null) {
				System.out.println("node not inserted");
				return;
			}
			node.next = oldNode.next;
			oldNode.next = node;
			oldNode = null;
		}
	}

	/** Delete the index-th node in the linked list, if the index is valid. */
	public void deleteAtIndex(int index) {

		if (head == null) {
			System.out.println("index is invalid");
		}else if(index==0)
		{
			Node tempNode = head;
			head = tempNode.next;
			tempNode.next = null;
		}
		else {
			
			Node oldNode = head;
			int i = 0;
			while (i < index - 1 && oldNode != null) {
				oldNode = oldNode.next;
				i++;
			}
			if (oldNode==null ||oldNode.next==null) {
				System.out.println("index is invalid");
				return;
			}
			if(oldNode.next==null)
			{
				oldNode=null;
			}else
			{
			Node tempNode = oldNode.next;
			oldNode.next=tempNode.next;
			tempNode = null;
			}
		}
	}

	public static void print(Node head)
	{ 
		Node node=head;
		if(node.next==null)
		{
			System.out.print(node.data + ",");
			return ;
		}
		System.out.print(node.data + ",");
		print(node.next);
		

	}
	// Your MyLinkedList object will be instantiated and called as such:
	public static void main(String[] args) {

		MyLinkedList obj = new MyLinkedList();
		//["MyLinkedList","addAtHead","get","addAtHead","addAtHead","deleteAtIndex","addAtHead","get","get","get","addAtHead","deleteAtIndex"]
						//	[[],[4],[1],[1],[5],[3],[7],[3],[3],[3],[1],[4]]
		obj.addAtHead(4);
		int param_1 = obj.get(1);
		obj.addAtHead(1);
		obj.addAtHead(5);
		obj.deleteAtIndex(3);
		obj.addAtHead(7);
		 param_1 = obj.get(3);
		 param_1 = obj.get(3);
		 param_1 = obj.get(3);
		 System.out.println(param_1);
		 obj.addAtHead(1);
			obj.deleteAtIndex(4);
		/*obj.addAtTail(3);
		print(head);
		System.out.println();
		obj.addAtIndex(1,2);
		 param_1 = obj.get(1);
		System.out.println(param_1);
		print(head);
		System.out.println("After Delete:");
		obj.deleteAtIndex(1);
		print(head);
		System.out.println();
		param_1 = obj.get(1);
		System.out.println(param_1);*/

	}
}
