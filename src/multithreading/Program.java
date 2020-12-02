package multithreading;

public class Program {

	public static void main(String[] args) {
		MultiThreadingExample thread1= new MultiThreadingExample("Thread1");
		MultiThreadingExample thread2= new MultiThreadingExample("Thread2");
		thread1.start();
		thread2.start();
	}
}
