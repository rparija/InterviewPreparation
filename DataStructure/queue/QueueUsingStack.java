package queue;

import java.util.Stack;


/*Implement a queue using a stack*/
public class QueueUsingStack {

	static Stack <Integer> s1= new Stack<Integer> ();
	static Stack <Integer> s2= new Stack<Integer> ();
	
	public  static Stack<Integer> push(int i)
	{
		if(s1.isEmpty())
		{
			s1.push(i);
		}else
		{
			while(!s1.isEmpty())
			{
				s2.push(s1.pop());
			}
			s2.push(i);
			while(!s2.isEmpty())
			{
				s1.push(s2.pop());
			}
		}
		return s1;
	}
	public  static Integer pop()
	{
		if(s1.isEmpty())
		{
			System.out.println("Queue is empty");
			return 0;
		}
		return s1.pop();
	}
	
	public static Integer peek()
	{
		return s1.peek();
	}
	
	public static void print()
	{
		s1.stream().forEach(System.out::print);
		System.out.println();
	}
	public static void main(String[] args) {
		
		
		push(10);
		print();
		push(20);
		print();
		push(30);
		print();
		System.out.println(peek());
		pop();
		print();
		System.out.println(peek());
		pop();
		print();
	}
}
