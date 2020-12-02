package multithreading;

/*Thread.join are used to keep the main thread waiting for the other thread to 
 * complete its operation till the child thread execution is completed*/
public class ThreadCreationWays {

	public static void main(String[] args) throws InterruptedException {
		
		Runnable runnable = new Runnable() {

			@Override
			public void run() {
				for (int i = 0; i < 10; i++) {
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println("Thread created using Annonymous "
							+ "InnerClass" );

				}

			}
		};

		Runnable runnableLambda = () -> {
			for (int i = 0; i < 10; i++) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("Thread created using Lambda "
						+ "InnerClass" );

			}

		};
		Thread thread1 = new Thread(runnableLambda, "Thread2");
		/*this will allow the main thread to complete without waiting for thread1 
		 * to complete since we have made thread1 as deamon thread*/
		thread1.setDaemon(true);

		thread1.start();
		thread1.join();
		//Thread.sleep(5000);

		System.out.println("Exiting Main Thread");
	}
}
