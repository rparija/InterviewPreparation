package multithreading;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class CompletableFutureExample {

	public static void main(String[] args) {
		Executor executor = Executors.newFixedThreadPool(10);
	
		CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
		    try {
		        TimeUnit.SECONDS.sleep(10);
		        for(int i=0;i<10;i++)
		        {
		        	System.out.println(i);
		        }
		        System.out.println("future thread");
		    } catch (InterruptedException e) {
		        throw new IllegalStateException(e);
		    }
		    return "Result of the asynchronous computation";
		}, executor);
		
		
			if(future!=null)
			{
				//System.out.println(future.complete(null));
			System.out.println("main Thread exiting");
			}
			
			ExecutorService executorServiceThreadPool = Executors.newFixedThreadPool(5);
			Future f=executorServiceThreadPool.submit(()->System.out.println("ThreadPool Thread1 "));
		
	}
}
