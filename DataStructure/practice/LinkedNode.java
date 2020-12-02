package practice;

public class LinkedNode {

	int data;
	LinkedNode next;
	
	
	public LinkedNode(int data, LinkedNode next) {
		super();
		this.data = data;
		this.next = next;
	}
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
	public LinkedNode getNext() {
		return next;
	}
	public void setNext(LinkedNode next) {
		this.next = next;
	}
	
	
}
