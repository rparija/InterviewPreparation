package java8.gettingtasteoflambda;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;
import java.util.stream.*;

//Parallel Stream and Completable future
public class ParallelStreamPractice {

	public static int doubleIt(int i) {
		System.out.println("Thread name :" + Thread.currentThread().getName() + "value of i :" + i);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i * 2;
	}

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		// stream and parallel stream
		long time = System.currentTimeMillis();
		List<Integer> values = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		System.out.println(values.stream().parallel().filter(val -> val % 2 == 0)
				.mapToInt(ParallelStreamPractice::doubleIt).sum());
		long completionTime = System.currentTimeMillis();
		System.out.println((completionTime - time) / 1000F);

		/* Completeable furture */
		/*
		 * CompletableFuture<String> future = new CompletableFuture<>();
		 * //future.complete("Future's result"); future.runAsync(() -> { try {
		 * Thread.sleep(1000); } catch (InterruptedException e) { // TODO Auto-generated
		 * catch block e.printStackTrace(); }
		 * System.out.println("I will run in a separate Thread with Thread name :"
		 * +Thread.currentThread().getName());
		 * 
		 * } ); future.get();
		 */
		ForkJoinPool pool = new ForkJoinPool(10);
		CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) { // TODO Auto-generated catch block throw new
				throw new IllegalStateException(e);
			}
			return "Result of the asynchornous computation" + Thread.currentThread().getName();
		}, pool);

		CompletableFuture<String> future2 = future1.thenApply(name -> {
			return name.toUpperCase();
		});
		/*
		 * future1.complete call will complete the execution and will not wait for the
		 * future1 to complete
		 */
		// future1.complete("future 1 got completed by
		// "+Thread.currentThread().getName());
		String result = future2.get();
		future2.complete("completed");
		System.out.println(result);
		CompletableFuture<String> future3 = future1.thenApply(name -> {
			return name.toUpperCase();
		}).thenApply(name -> name.toLowerCase());
		System.out.println(future3.get());

		CompletableFuture<List<Integer>> future4 = CompletableFuture.supplyAsync(() -> {
			return getIntegerList();
		});
		future4.thenAccept(System.out::print).thenRun(() -> System.out.println("run method call"));

		/*
		 * compose and combine (its equivalent to flatMap,
		 * CompletableFuture<CompletableFuture<Double>>)
		 */
		CompletableFuture<Integer> future5 = future4.thenCompose(ParallelStreamPractice::getSumOfIntegerList);
		int sum = future5.join();
		System.out.println(sum);

		CompletableFuture<Integer> future6 = CompletableFuture.supplyAsync(() -> {
			return 10;
		});

		CompletableFuture<Integer> future7 = CompletableFuture.supplyAsync(() -> {
			return 20;
		});
		CompletableFuture<Integer> future8 = future6.thenCombine(future7, Integer::sum);

		System.out.println(future8.get());

		future8 = future6.thenCombine(future7, (f6, f7) -> {
			return f6 * 3 + f7 * 5;
		});

		System.out.println(future8.get());

		/* allOf and anyOf */

		List<CompletableFuture<Integer>> completableFutureList = getIntegerList().stream()
				.map(ParallelStreamPractice::getCompFut).collect(Collectors.toList());
		CompletableFuture.allOf(completableFutureList.toArray(new CompletableFuture[completableFutureList.size()])).join();
		boolean isDone=CompletableFuture.allOf(completableFutureList.toArray(new CompletableFuture[completableFutureList.size()])).isDone();
		System.out.println(isDone);
	}
   
	public static CompletableFuture<Integer> getCompFut(Integer i) {
		CompletableFuture<Integer> future9 = CompletableFuture.supplyAsync(() -> {
			return i;
		});
		System.out.println("Thread.currentThread().getName()"+Thread.currentThread().getName()+"Value of i is"+i);
		return future9;
	}

	public static List<Integer> getIntegerList() {

		return Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
	}

	public static CompletableFuture<Integer> getSumOfIntegerList(List<Integer> future) {
		CompletableFuture<Integer> f = CompletableFuture.supplyAsync(() -> {
			return future.stream().reduce(Integer::sum).get();
		});
		return f;

	}
}
