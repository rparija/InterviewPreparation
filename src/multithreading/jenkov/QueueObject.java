package multithreading.jenkov;

public class QueueObject {

	  private boolean isNotified = false;
	  String threadName=null;
	
	  public QueueObject(String threadName) {
		  this.threadName=Thread.currentThread().getName();
	}
	  public synchronized void doWait() throws InterruptedException {
	    while(!isNotified){
			System.out.println("waiting Thread " + Thread.currentThread().getName());
	        this.wait();
	    }
	    this.isNotified = false;
	  }

	  public synchronized void doNotify() {
	    this.isNotified = true;
		System.out.println("Notify called by  Thread " + Thread.currentThread().getName());
	    this.notify();
	  }

	  public boolean equals(Object o) {
	    return this == o;
	  }
	}
