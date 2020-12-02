package multithreading.jenkov;

public class FairnessLockingDemo {

	static FairnessLock lock = new FairnessLock();

	public static void doSynchronize(FairnessLock lock) {
		try {
			lock.lock();
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		lock.unLock();
	}

	public static void main(String[] args) throws InterruptedException {

		Thread thread1 = new Thread(() -> doSynchronize(lock), "Thread1");

		lock = new FairnessLock();
		Thread thread2 = new Thread(() -> doSynchronize(lock), "Thread2");
		lock = new FairnessLock();
		Thread thread3 = new Thread(() -> doSynchronize(lock), "Thread3");
		thread1.start();
		thread3.start();
		thread2.start();

	}
}
