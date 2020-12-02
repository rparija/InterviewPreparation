package multithreading.jenkov;

public class FairnessLock {

	boolean isLocked=false;
	String currentThread=null;
	
	public synchronized void  lock() throws InterruptedException
	{
		while(isLocked)
		{
			System.out.println("waiting Thread"+Thread.currentThread().getName());
			this.wait();
		}
		System.out.println("Lock Accquired by "+Thread.currentThread().getName());
		isLocked=true;
		currentThread=Thread.currentThread().getName();
	}
	
	public synchronized void  unLock()
	{
		if(!Thread.currentThread().getName().equals(currentThread))
		{
			throw new IllegalThreadStateException(currentThread+" Thread is already in running state");
		}
		isLocked=false;
		currentThread=null;
		System.out.println("UnLock  "+Thread.currentThread().getName());
		this.notify();
	}
}
