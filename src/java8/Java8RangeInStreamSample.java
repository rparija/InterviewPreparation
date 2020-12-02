package java8;

import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;


/* Using Lamda functions(predicate and function) and streams effectively & also lazy evaluation of lamda expression*/
public class Java8RangeInStreamSample {

	public static void main(String[] args) {

		List<Integer> list = Arrays.asList(1, 2, 3, 5, 4, 6, 7, 8);
		
		Function<Integer,Predicate<Integer>> isGTFunction= pivot-> number -> number>pivot;
		Predicate<Integer> isGreaterThan= p->p>3;
		Predicate<Integer> isPrime= p->p%2==0;

		Stream<Integer> temp = list.stream()
				.filter(e -> greaterThan(e))
				.filter(Java8RangeInStreamSample::isPrime)
				.map(Java8RangeInStreamSample::doubleIt);
		System.out.println(temp.findFirst());
		
		//using functional predicate
		temp = list.stream()
				.filter(isGTFunction.apply(3))
				.filter(isPrime)
				.map(Java8RangeInStreamSample::doubleIt);
		System.out.println(temp.findFirst());
		
		//using only predicate
		temp = list.stream()
				.filter(isGreaterThan)
				.filter(isPrime)
				.map(Java8RangeInStreamSample::doubleIt);
		System.out.println(temp.findFirst());
		
		int sum=list.stream().mapToInt(Java8RangeInStreamSample::doubleIt).sum();
		System.out.println(sum);
		// you can see how executing in parallel increased the speed of execution and improved performance by n times(n is size of array)
		sum=list.parallelStream().mapToInt(Java8RangeInStreamSample::doubleIt).sum();
		System.out.println(sum);
	}

	private static int sum(int num) {
		int sum=0;
		System.out.println("greaterThan"+num);
		return sum+=num;
	}
	
	private static boolean greaterThan(int num) {
		System.out.println("greaterThan"+num);
		return num > 3;
	}
	private static boolean isPrime(int num) {

		System.out.println("isPrime"+num);

		return num%2 == 0;
	}
	private static int  doubleIt(int num) {
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("doubleIt"+num);

		return num*2;
	}
}
