package multithreading.jenkov;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorServiceDemo {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		
		ExecutorService executorService= Executors.newSingleThreadExecutor();
		executorService.execute(()->System.out.println("Thread1"));
		executorService.execute(()->System.out.println("Thread2"));
		executorService.execute(()->System.out.println("Thread3"));
		
		executorService.shutdown();
		/*passing Runnable to the submit method*/
		ExecutorService executorServiceThreadPool = Executors.newFixedThreadPool(5);
		Future future=executorServiceThreadPool.submit(()->System.out.println("ThreadPool Thread1 "));
		System.out.println(future.get());
		future=executorServiceThreadPool.submit(()->System.out.println("ThreadPool Thread2 "));
		System.out.println(future.get());
		executorServiceThreadPool.shutdown();
		
		/*passing callable to the submit method*/
		ExecutorService executorServiceScheduledThreadPool = Executors.newScheduledThreadPool(5);
		List<Future<String>> list= new ArrayList<Future<String>>();
		for(int i=0;i<10;i++)
		{
		Future futureCallable=executorServiceScheduledThreadPool.submit(new Callable() {
			
			public Object call()
			{
				
				return "Callable  executed task"+Thread.currentThread().getName();
			}
		});
		list.add(futureCallable);
		}
		for(Future fut:list)
		{
			System.out.println(fut.get());
		}
		executorServiceScheduledThreadPool.shutdown();
		
		/*invokeAny and invokeAll*/
		
		Set<Callable<String>> set= new HashSet();
		set.add(new Callable() {
			public Object call()
			{
				return "Callable task 1 executed";
			}
		});
		set.add(new Callable() {
			public Object call()
			{
				return "Callable task 2 executed";
			}
		});
		set.add(new Callable() {
			public Object call()
			{
				return "Callable task 3 executed";
			}
		});
		
		ExecutorService executorServiceScheduledThreadPoolInvoke = Executors.newScheduledThreadPool(5);
		String invokeAnyResult=executorServiceScheduledThreadPoolInvoke.invokeAny(set);
		System.out.println(invokeAnyResult);
		executorServiceScheduledThreadPoolInvoke.shutdown();
		
		ExecutorService executorServiceScheduledThreadPoolInvokeAll = Executors.newScheduledThreadPool(5);
		List<Future<String>> futureInvokeAll=executorServiceScheduledThreadPoolInvokeAll.invokeAll(set);
		futureInvokeAll.stream()
		.map(e->{
			try {
				return e.get();
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (ExecutionException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			return invokeAnyResult;
		})						
		.forEach(System.out::println);
		executorServiceScheduledThreadPoolInvokeAll.shutdown();
		
		
	}
	
}
