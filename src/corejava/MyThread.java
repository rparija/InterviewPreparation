package corejava;

public class MyThread extends Thread{

	public MyThread(String threadName) {
		super(threadName);
	}
	@Override
	public void run() {
		

		for(int i=0;i<15;i++)
		{
			System.out.println(""+Thread.currentThread().getName());
		}
	}
}
