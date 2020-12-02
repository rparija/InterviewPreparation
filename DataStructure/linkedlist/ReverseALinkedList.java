package linkedlist;

import java.util.Currency;

public class ReverseALinkedList {

	static Node head;

	public static void insert(int data) {
		Node node = new Node();
		node.data = data;
		node.next = null;

		if (head == null) {
			head = node;
		} else {
			Node oldNode = head;
			while (oldNode.next != null) {
				oldNode = oldNode.next;
			}
			oldNode.next = node;
		}
	}

	public static void show(Node head) {
		Node node = head;
		while (node.next != null) {
			System.out.print(node.data + ",");
			node = node.next;
		}
		System.out.println(node.data);
	}

	public static Node print(Node head) {
		Node node = head;
		if (node.next == null) {
			System.out.print(node.data + ",");
			return node;
		}
		System.out.println(node.data);
		print(node.next);
		return node;
	}

	public static Node reverse(Node head) {

		if (head == null) {
			System.out.println("head is null");
			return head;
		} else {

			Node current = head;
			Node next = null;
			Node prev = null;
			while (current.next != null) {
				next = current.next;
				current.next = prev;
				current.prev = next;
				prev = current;
				current = next;
			}
			current.next = prev;
			current.prev = null;
			head = current;
			return head;
		}

	}

	public static void reverseUsingRecursion(Node node) {
		if (node.next == null) {
			head = node;
			return;
		}
		reverseUsingRecursion(node.next);
		Node reversedNode = node.next;
		reversedNode.next = node;
		node.next = null;

	}

	public static Node reverseUsingRecursionLeetCode(Node head) {
		 if(head.next==null)
	        {
	            return head;
	        }
	        Node temp=reverseUsingRecursionLeetCode(head.next);
	        head.next.next=head;
	        head.next=null;
	        return temp;

	}
	
	 public static Node reverseList(Node head) {
	        
	        if(head==null)
	        {
	            return head;
	        }else
	        {
	            Node curr=head;
	            Node prev=null;
	            while(curr!=null)
	            {
	            	Node next=curr.next;
	                curr.next=prev;
	                prev=curr;
	                curr=next;
	            }
	            
	            return prev;
	        }
	        
	    }
	public static void main(String[] args) {
		insert(12);
		insert(13);
		insert(14);
		show(head);
		/*
		 * head=reverse(head); System.out.println("reversed linkedList"); show(head);
		 */
		print(head);
		reverseUsingRecursion(head);
		print(head);
		Node node=reverseUsingRecursionLeetCode(head);
		System.out.println(node);
		Node node1=reverseList(node);
		System.out.println(node1);
	}
}
