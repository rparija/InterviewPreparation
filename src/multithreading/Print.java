package multithreading;

public class Print {

	ValueClass vc= new ValueClass();
	
	public synchronized void tick(boolean running,int count) throws InterruptedException
	{
		if(!running)
		{
			this.notify();
			return;
		}
		if(count%2!=0)
		System.out.println("tick"+Thread.currentThread().getName()+"count"+count);
		this.notify();
		this.wait();
	}
	
	public synchronized void tock(boolean running, int count) throws InterruptedException
	{
		if(!running)
		{
			this.notify();
			return;
		}
		if(count%2==0)
		System.out.println("tock"+Thread.currentThread().getName()+"count"+count);
		this.notify();
		this.wait();
	}
}
