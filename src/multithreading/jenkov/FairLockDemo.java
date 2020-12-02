package multithreading.jenkov;

public class FairLockDemo {

	static FairLock lock = new FairLock();

	public static void doSynchronize(FairLock lock) {
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

		lock = new FairLock();
		Thread thread2 = new Thread(() -> doSynchronize(lock), "Thread2");
		lock = new FairLock();
		Thread thread3 = new Thread(() -> doSynchronize(lock), "Thread3");
		thread1.start();
		thread2.start();
		thread3.start();


	}
}
