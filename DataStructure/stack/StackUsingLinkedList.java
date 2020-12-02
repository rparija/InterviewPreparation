package stack;

import linkedlist.Node;

public class StackUsingLinkedList {

	static Node head;
	
	public static void push(int data) {
		Node node=new Node();
		node.data=data;
		node.next=null;
		if(head==null) 
		{
			head=node;
		}else
		{
			Node oldNode=head;
			while(oldNode.next!=null)
			{
				oldNode=oldNode.next;
			}
			oldNode.next=node;
		}
	}

	public static int popInQueue() {
		
		if(head==null) 
		{
			return 0;
		}else
		{
			Node oldNode=head.next;
			head=oldNode;
			if(head!=null)
			return head.data;
			return 0;
		}
		
	}

	public static int pop() {
		
		if(head==null) 
		{
			return 0;
		}else
		{
			Node oldNode=head;
			Node prev=null;
			while(oldNode.next!=null)
			{
				 prev=oldNode;
				 oldNode=oldNode.next;
			}
			if(prev!=null)
			{
			prev.next=null;
			return prev.data;
			}
			return 0;
		}
		
	}


	public static void show() {
		Node node=head;
		while(node !=null)
		{
			System.out.print(node.data+",");
			node=node.next;
		}
		System.out.println();
	}


	
	public static void main(String[] args) {
		push(1);
		push(2);
		push(3);
		push(4);
		push(5);
		show();
		System.out.println(pop());
		System.out.println(pop());
		System.out.println(pop());
		System.out.println(pop());
		show();
		System.out.println(pop());
		show();
	}
}
