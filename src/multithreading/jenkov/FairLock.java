package multithreading.jenkov;

import java.util.*;

public class FairLock {

	boolean isLocked = false;
	String currentThread = null;
	/*this queue will maintain the sequence of the waiting threads*/
	List<QueueObject> waitingThreadQueue = new ArrayList<QueueObject>();

	public void lock() throws InterruptedException {
		QueueObject queue = new QueueObject(Thread.currentThread().getName());
		boolean isCurrentThreadLocked = true;
		synchronized (this) {
			waitingThreadQueue.add(queue);
		}

		while (isCurrentThreadLocked) {
			synchronized (this) {
				if (!isLocked && waitingThreadQueue.get(0).equals(queue)) {
					isCurrentThreadLocked = false;
				}
				if (!isCurrentThreadLocked) {
					System.out.println("Lock Accquired by " + Thread.currentThread().getName());
					isLocked = true;
					currentThread = Thread.currentThread().getName();
					waitingThreadQueue.remove(queue);
					return;
				}
			}

			try {
				queue.doWait();// when notify is called the threads waiting here will go to line 18 while (isCurrentThreadLocked) and start the execution
			} catch (Exception ex) {
				synchronized (this) {
					waitingThreadQueue.remove(queue);
				}
			}
		}
		
	}

	public synchronized void unLock() {
		if (!Thread.currentThread().getName().equals(currentThread)) {
			throw new IllegalThreadStateException(currentThread + " Thread is already in running state");
		}
		isLocked = false;
		currentThread = null;
		System.out.println("UnLock  " + Thread.currentThread().getName());
		if(!waitingThreadQueue.isEmpty())
		waitingThreadQueue.get(0).doNotify();
	}
}
