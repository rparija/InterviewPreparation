package linkedlist;

public class LinkedListCycle {
	
	//Declare two nodes Slow and fast , move slow one step and fast two steps at a time 	//8,1,19,4,9,8,1
	public static boolean isCyclePresent(Node node)
	{
		Node slow=node;
		Node fast=node;
		boolean cycleExist=false;
		while(slow.next!=null && fast.next!=null)
		{
			slow=slow.next;
			fast=fast.next.next;
			if(slow==fast)
			{
				System.out.println("Cycle is present ");
				cycleExist=true;
				break;
			}
			
		}
		if(cycleExist)
		{
		slow=node;
		while(slow !=fast)
		{
		
			slow=slow.next;
			fast=fast.next;
		}
		System.out.println("cycle starts at "+slow.data);
		return true;}
		else
		{
			return false;
		}
	}

	public static void main(String[] args) {
		LinkedList linkedList= new LinkedList();
		linkedList.insert(1);
		linkedList.insert(2);
		linkedList.insert(19);
		linkedList.insert(4);
		
		Node node=linkedList.insert(9);
		node.next.next.next.next.next=node.next;
		System.out.println(isCyclePresent(node));
		//linkedList.show();
	}
	
}
