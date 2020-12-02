package multithreading;

public class MultiThreadingExample extends Thread {

	static Print p;
	int count=0;
	public MultiThreadingExample(String threadName) {

		super(threadName);
		p = new Print();
	}

	@Override
	public void run ()
	{
		
		String threadName= currentThread().getName();
		try {
			

		/*	
			for (int i = 0; i < 50; i++) {
				count=count+1;
				p.tick(true,count);
				Thread.sleep(50);
				}
			
			p.tick(false,0);
			p.tock(false,0);
				
			*/
		
		if(threadName.equals("Thread1"))
		{
			
			for (int i = 0; i < 5; i++) {
				count=count+1;
				p.tick(true,count);
				Thread.sleep(500);
				
			}
			p.tick(false,0);
				
			 
		}else
		{
			for (int i = 0; i < 5; i++) {
				count=count+1;
				p.tock(true,count);
				Thread.sleep(500);
			}
			p.tock(false,0);
		}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
