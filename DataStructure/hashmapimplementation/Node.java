package hashmapimplementation;

/*a node will have a key a value and a next node and hash as well*/
public class Node {

	Object key;
	Object value;
	Node next;
	int hash;
	public Node() {
		// TODO Auto-generated constructor stub
	}
	public Node(Object key, Object value, Node next, int hash) {
		super();
		this.key = key;
		this.value = value;
		this.next = next;
		this.hash = hash;
	}
	public Object getKey() {
		return key;
	}
	public void setKey(Object key) {
		this.key = key;
	}
	public Object getValue() {
		return value;
	}
	public void setValue(Object value) {
		this.value = value;
	}
	public Node getNext() {
		return next;
	}
	public void setNext(Node next) {
		this.next = next;
	}
	public int getHash() {
		return hash;
	}
	public void setHash(int hash) {
		this.hash = hash;
	}
	
	
}
