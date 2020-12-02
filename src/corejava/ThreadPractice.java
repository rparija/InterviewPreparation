package corejava;

public class ThreadPractice {

	public static void main(String[] args) {
		MyThread thread1 = new MyThread("Thread1");
		System.out.println(thread1.toString());
		Thread thread2 = new Thread(new MyRunnable(), "Thread2");
		System.out.println(thread2.toString());
		thread1.start();
		try {
			thread1.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		thread2.start();

		Thread thread3 = new Thread(new Runnable() {

			@Override
			public void run() {
				for (int i = 0; i < 5; i++) {
					System.out.println("" + Thread.currentThread().getName());
				}

			}

		},"Thread3");
		thread3.start();
		
		Thread thread4 = new Thread(()-> System.out.println());
		thread4 = new Thread(()-> {
			for (int i = 0; i < 5; i++) {
				System.out.println("" + Thread.currentThread().getName());
			}});

		}
	}

