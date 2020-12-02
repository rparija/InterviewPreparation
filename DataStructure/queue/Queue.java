package queue;

public class Queue {

	static int front = 0;
	static int rear = 0;
	static int size = 0;
	static int capacity = 0;

	static Integer[] queue = new Integer[4];

	public Queue(int capacity) {
		this.capacity = capacity;
		queue = new Integer[capacity];
	}

	public static void dequeue() {
		if (isEmpty()) {
			System.out.println("queue is empty");
			return;
		}
		front = (front + 1) % capacity;		
		queue[front] = null;
		size--;
	}

	public static void enqueue(int data) {

		if(isFull())
		{
			System.out.println("Queue is full");
			return;
		}
		
		rear = (rear + 1) % (capacity);
		queue[rear] = data;
		size++;

	}

	public static boolean isEmpty() {
		return size == 0;
	}

	public static boolean isFull() {
		return size == capacity;
	}

	public static void show() {
		for (Integer integer : queue) {
			System.out.print(integer+ ",");
		}
		System.out.println();
	}

	public static int getRear() {
		return rear;
	}

	public static int getFront() {
		return front;
	}

	public static void main(String[] args) {

		Queue queue = new Queue(5);
		dequeue();
		enqueue(10);
		enqueue(20);
		enqueue(30);
		enqueue(40);
		enqueue(50);
		show();
		enqueue(50);
		show();
		dequeue();
		dequeue();
		dequeue();
		show();
		enqueue(60);
		show();
		System.out.println("getRear:"+getRear());
		System.out.println("getFront:"+getFront());	}
}
