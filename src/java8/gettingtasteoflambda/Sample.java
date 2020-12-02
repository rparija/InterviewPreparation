package java8.gettingtasteoflambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.Locale.FilteringMode;
import java.util.function.Consumer;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;
import static java.util.Comparator.*;

//why Lambda
/* Java 8 Lambda is backward compatible. take an example of Runnable interface that is an Interface with just one 
 * abstract method which denotes the Functional interface feature of Java 8 , so this MyRunnable interface works with
 * anonymous class as well as Lambda expressions so that makes it backward compatible*/

//Lambdas under the hood
/*In the Java7 world when we have the anonymous inner class at that time inner classes were created during the time 
 * compilation $ classes, but when we use lambda at that time the compiler does not change the code for lambda into 
 * anonymous classes but it actually uses invoke dynamics feature with the help of which there are no inner classes
 *  created which causes Java 8 lambda to use less Disk space compared to Java 7 
 * */
public class Sample {

	public static void main(String[] args) {
	
		Thread thread2 = new Thread(()-> System.out.println("Java 8 Lambda expressions"));
		thread2.start();
		
		/*journey  from external iterators to Internal iterators*/
		
		List<Integer> numbers= Arrays.asList(1,2,3,4,5,6,7,8,9);
		//Traditional for loop with which everybody is more familiar
		for(int i=0 ;i<numbers.size();i++)
		{
			System.out.println(i);
		}
		//This also does the same job and you don't have to worry about the size and exit conditions
		for(Integer i: numbers)
		{
			System.out.println(i);

		}
		
	   /*Now lets talk about the internal Iterators*/
		
	   /* firstly lets talk about the Consumers where you can pass Consumers as the anonymous inner class
		* again to avoid the disk space overhead we need to get rid of the unnecessary/obvious code.
		* so we are iterating through the list of Integers so there are no chances that it will have something 
		* other than integer so we can get rid of the type and also the new Consumer object and accept method declaration*/
		
		numbers.forEach(new Consumer<Integer>() {
			public void accept(Integer value)
			{
				System.out.println(value);
			}
		});
		
		numbers.forEach(e-> System.out.print(e));

		/*So now the above code will get changed into Lambda and is written like below 
		 * and Java8 is Type inference only for Lambda expressions (means you don't have to externally give the 
		 * Type name the compiler is smart enough to understand that list of integers will have only integers)*/
		numbers.forEach((value)->System.out.println(value));
		
		/* now incase of just one parameter in Lambda expressions it is not compulsary to pass that parameter
		 * also the first thing would be to remove the parenthesis */
		numbers.forEach(value->System.out.println(value));
		
		/* we wanted to write like this but this is not the way numbers.forEach(System.out.println);
		 * instead we can write like the system.out object instance is calling the println method*/
		numbers.forEach(System.out::println);
		
		/*Lamda's are cute but we generally make it look ugly by writing multiple lines code inside lambda
		 * in case you want to write any business logic please write it in a separate method and call it in the 
		 * lambda expression http://blog.agiledeveloper.com/2015/06/lambdas-are-glue-code.html*/
		
		/* */
		numbers.stream()
	//	.map(e -> String.valueOf(e)) This is the standard way of calling Lambda....String class static method valueOf
		.map(String::valueOf) // so we can call a static method as well using this Lambda , this is method reference to a static method
		.forEach(System.out::println); // method reference to an instance method 
		
		numbers.stream()
		.map(String::valueOf)  //static method valueOf
		.map(String::toString) // instance method toString
		.forEach(System.out::println);
		
		/*Reduce method usage for sum and concat
		 * Method references different options
		 * map , filter follows swim lanes but reduce cut the swim lanes and cut across (swims across)*/
		
		numbers.stream()
				.filter(e->e%2==0)
				.map(e->e*2)
				.reduce(0,Integer::sum);
		numbers.stream()	
				.filter(e->e%2!=0)
				.mapToInt(e-> e*e)
				.sum();
		System.out.println(
				numbers.stream()
				.reduce(0,(total,e) -> total=e+total));
		
		System.out.println(
				numbers.stream()
		.reduce(0,(total,e)-> Integer.sum(e, total)));
		
		System.out.println(
				numbers.stream()
				.reduce(0,Integer::sum));
		
		System.out.println(
				numbers.stream()
		.map(String::valueOf)
		.reduce("",(carry,e) -> carry.concat(e)));
		
		numbers.stream()
				.map(String::valueOf)
				.reduce("",(e,value)->e.concat(value));
		/*The order of the parameter matters allot as if we switch the parameters it will print 
		 * in reverse order*/
		System.out.println(
				numbers.stream()
				.map(String::valueOf)
				.reduce("",(e,carry) -> carry.concat(e)));
		
		System.out.println(
				numbers.stream()
				.map(String::valueOf)
				.reduce("",String::concat));
				
			/* given the values, double the even numbers and total*/
		System.out.println(
				numbers.stream()
		.filter(i-> i%2==0)
		.map(i->i*2)
		.reduce(0,Integer::sum));
		
		System.out.println(
				numbers.stream()
				.filter(i-> i%2==0)
				.mapToInt(i->i*2)
				.sum());
		
		System.out.println(
				numbers.stream()
				.filter(Sample::isEven)
				.mapToInt(Sample::doubleIt)
				.sum());
		
		/* Streams and Reduce*/
		/*streams as abstraction they are not like collections they just provide the set of functions
		 * which operate on the collection (Streams group functions together) 
		 * Java 8 Stream has many operations which can be pipe lined together to get desired result. ... 
		 * The operations which return another stream as a result are called intermediate operations and 
		 * the operations which return non-stream values like primitive or object or collection or return nothing are 
		 * called terminal operations.*/
		/*Double the even values and put them into the list*/
		
		/*Wrong way to do this, here we are sharing the doubleofEven list between various stream elements
		 * mutability is ok , sharing is ok but shared mutability is devils work*/
		numbers=Arrays.asList(1,2,3,4,1,2,3,4);
		List<Integer> doubleOfEven= new ArrayList<>();
		numbers.stream()
				.filter(Sample::isEven)
				.map(Sample::doubleIt)
				.forEach(e->doubleOfEven.add(e));
		
		System.out.println(doubleOfEven);
		
		/*for using collect we need to import static java.util.stream.Collectors.*;
		 * now by using the below collect we can avoid shared mutability as collect is thread safe and can be
		 * used in streams*/ 
		List<Integer> doubleOfEven2= numbers.stream()
											.filter(e->e%2==0)
											.map(e->e*2)
											.collect(toList());
		System.out.println(doubleOfEven2);

		// collect can be used with parallel streams as well
		doubleOfEven2= numbers.parallelStream()
				.filter(e->e%2==0)
				.map(e->e*2)
				.collect(toList());
		System.out.println(doubleOfEven2);
		
		//converting into a set to avoid duplicates
		Set<Integer> doubleOfEven3= numbers.stream()
				.filter(e->e%2==0)
				.map(e->e*2)
				.collect(toSet());
		System.out.println(doubleOfEven3);
		
		/*using map with Streams*/
		
		List<Person> objectList= Arrays.asList(
				new Person(29,"Raul"),
				new Person(28,"Akshitha"),
				new Person(27,"Raul"),
				new Person(30,"Atulya"),
				new Person(29,"Atulya"),
				new Person(30,"Ashiq")
				);
		System.out.println(
		objectList.stream()
					.collect(toMap(person-> person.getName()+"-"+person.getAge(), person->person)));
		
		System.out.println(objectList.stream()
				  .collect(toMap(
						  person-> person.getName()+"_"+person.getAge(),
						  person->person)));
		System.out.println("exercise "+
		objectList.stream()
					.collect(groupingBy(Person::getName, mapping(Person::getAge,toList()))));
		
		/*grouping by name, given a list of people , create a map where their name is the 
		 * key and value is all the people with that name*/
		
		System.out.println(objectList.stream()
							.collect(groupingBy(Person::getAge)));
		
		/*grouping by name, given a list of people , create a map where their name is the 
		 * key and value is all the ages of people with that name*/
		
		System.out.println(objectList.stream()
									.collect(groupingBy(Person::getName,
											mapping(Person::getAge,toList()))));	
		//Collector(Function, Collector(Function,Collector))
		
		System.out.println("Name count:"+objectList.stream()
				.collect(groupingBy(Person::getName,counting())));
		
		objectList.stream()
					.collect(groupingBy(Person::getAge,mapping(Person::getName, toList())));
		/*so in the above code the counting method returns a long so if you want to have it as int then
		 * we need Collector(Function, Collector(Function,Collector))*/
		
		System.out.println("Name count values in Int:"+objectList.stream()
							.collect(groupingBy(Person::getName,collectingAndThen(counting(), Long::intValue))));
		
		/*maxBy minBy*/
		System.out.println("maxBy:"+objectList.stream()
		.collect(maxBy(comparing(Person::getAge))));
		
		System.out.println("minBy:"+objectList.stream()
		.collect(minBy(comparing(Person::getAge))));

		/*the above operation maxBy and minBy returns the Person object, but if i want just the person name
		 * in that case we need to perform the collect first and then the function to get the person name
		 * below code will be used for that where person.map returns an optional so we had to use orElse*/
		String result=objectList.stream()
				  .collect(
				  collectingAndThen(maxBy(comparing(Person::getAge)),
						  person -> person.map(Person::getName).orElse("")));
		System.out.println("collectingAndThen: "+result);
		
		
		List<String>  names=Arrays.asList("Raul","Riich","Raual","Ronald");
		
		System.out.println("starting with RA"+names.stream()
				  .filter(e-> e.startsWith("Ra"))
				  .collect(groupingBy(e->e,
						  mapping(Sample::Count,toList())
						   )));
		System.out.println(
		names.stream().
			  filter(e-> e.startsWith("Ra"))
			  .flatMapToInt(String::chars)
			  .mapToObj(i -> Character.valueOf((char) i))
		              .collect(toSet()));
		/*filtering is introduced in Java 11 so its not available here*/
		/*objectList.stream()
					.collect(groupingBy(Person::getAge, 
							mapping(Person::getName, filtering(name-> name.length>4,toList()))));*/
		
		numbers= Arrays.asList(1,2,3,5,4,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20);
		
		System.out.println();
		//given n ordered list find the double of the first even number greater than 3
		/*Streams are absolutely LAZY (call daddy example)
		 * any function which returns stream are LAZY (Intermediate functions are LAZY)
		 * terminal operations like sum, find first ,reduce, collect find any are not lazy*/
		System.out.println(
		numbers.stream()
			   .filter(Sample::greaterThan)
			   .filter(Sample::isEven)
			   .map(Sample::doubleIt)
			   .findFirst());
		Integer [] a= {1,2,3};
		Arrays.stream(a).forEach(System.out::println);
		numbers= Arrays.asList(1,2,3,5,4,1,2,3,4,5);
		/*characteristics of a stream: sized, ordered, distinct, sorted*/
		
		//sized, ordered, non distinct , unsorted 
		numbers.stream()
		.filter(Sample::isEven)
		.forEach(System.out::println)
		;

		//sized, ordered, non distinct , sorted
		numbers.stream()
				.filter(Sample::isEven)
				.sorted()
				.forEach(System.out::println)
				;
		
		//sized, ordered, distinct , unsorted
		numbers.stream()
				.filter(Sample::isEven)
				.distinct()
				.forEach(System.out::println)
				;
	
		/*Infinite Streams*/
	
		/* start with 100, create a series
		 * 100,101,102,103.......till infinite*/
		// it is extremely LAZY so it won't evaluate anything and just returns a stream
		System.out.println(Stream.iterate(100,e->e+1)); 
		
		/*Given a number k and a count n , find the double of n
		 * even numbers starting with k, where square root of each number is >20*/
		int k=121;
		int n=51;
		System.out.println(compute(k,n));
		
		/* how to evaluate if a function is Lazy or not?
		 * the return type of lazy functions will be stream
		 * */
		
		
		/*Collect*/
		List<Integer> ageList=objectList.stream()
				  .map(Person::getAge)
				  .collect(toList());
		ageList.add(99);
		System.out.println(ageList);
		
		/*so in the above example ageList is not immutable, so to achieve immutability here we can use
		 * toUnmodifiableList is not available so was giving compile error */ 
		
		/*ageList=objectList.stream()
				  .map(Person::getAge)
				  .collect(Collections::unmodifiableList);*/
		//ageList.add(99);
		//System.out.println(ageList);
		
		//create comma separated names in upperCase of people older than 25
		System.out.println(objectList.stream()
							.filter(person->person.getAge()>25)
							.map(Person::getName)
							.map(String::toUpperCase)
							.collect(joining(", ")));
		/*partitioning by even age and odd age*/
		System.out.println(objectList.stream()
							.collect(partitioningBy(person -> person.getAge() %2==0)));
		
		/*Flat Map
		 * if you have one to one function, use map to go from 
		 * Stream<T> to Stream<R>
		 * if you have one to many function, use map to go from 
		 * Stream<T> to Stream<Collection<R>>
		 * if you have one to many function, use flatMap to go from 
		 * STream<T> to Stream<R>
		 * */
		numbers=Arrays.asList(1,2,3);
		System.out.println(
		numbers.stream()
				.map(e-> Arrays.asList(Arrays.asList(e+1),Arrays.asList(e-1)))
				.collect(toList()));
		/*so the above map print 2D list but we want 1D list i.e. a single list for the list of list
		 * we can achieve this using flatMap in java8, just one thing is flatMap always takes stream as the input
		 * that's why we called stream method below before assigning it to the flatMap*/
		System.out.println(
				numbers.stream()
						.flatMap(e-> Arrays.asList(Arrays.asList(e+1),Arrays.asList(e-1)).stream())
						.collect(toList()));
		
		/*so toSet after a map won't change anything here as this is a list of list
		 * but in case of flatMap the set will remove the duplicates and give us the desired output*/
		System.out.println(
				numbers.stream()
						.map(e-> Arrays.asList(Arrays.asList(e+1),Arrays.asList(e-1)))
						.collect(toSet()));
		
		System.out.println(
				numbers.stream()
				.flatMap(e-> Arrays.asList(Arrays.asList(e+1),Arrays.asList(e-1)).stream())
				.collect(toSet())
				);
		
		/*I was tring below to print the characters of all the names grouped by age from Person class
		 * since flatMapping is introduced in java9 so we don't have it here in java8*/
	/*	System.out.println(
		objectList.stream()
					.collect(groupingBy(Person::getAge,
							flatMapping(
									person->Stream.of(person.getName().split("")), toList()))));*/
		
		
		/*Topics which we covered*/
		//reduce - sum, max, min, reduce , collect
		//collect(Collector)
		//Collectors
		//toList ,toSet ,toMap
		//toUnModifiableList , toUnModifiableSet
		//partitioning
		//groupingBy , groupingBy(Function<t,R>) , groupingBy (Function, Collector)
		//mapping (Function, Collector)
		//CollectingAndThen(Collector,Function)
	}
	
	private static int compute(int k, int n) {
		/*int result=0;
		 int index=k;
		 while(count<n) {
		 if(index%2==0 && Math.sqrt(index)>20)
		 {
			 result+=index*2;
			 count++;
		 }
		 index++;
		 }
		return result;*/
		
		return Stream.iterate(k, e->e+1)   //unbounded , lazy
			  .filter(Sample::isEven)		//unbounded , lazy
			  .filter(e->Math.sqrt(e)>20)	//unbounded , lazy
			  .mapToInt(Sample::doubleIt)	//unbounded , lazy	
			  .limit(n)						//bounded(sized) , lazy(limit wait until n values go through)
			  .sum()						//
			  ;
	}

	public static boolean greaterThan(Integer num)
	{
		if(num>3)
		{
			return true;
		}
		return false;
	}
	
	public static boolean isEven(Integer num)
	{
		if(num%2==0)
		{
			return true;
		}
		return false;
	}
	public static int doubleIt(Integer num)
	{
		
		return num*2;
	}
	public static long Count(String value)
	{
		return value.chars().distinct().count();
	}
}
