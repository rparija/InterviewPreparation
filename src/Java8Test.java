import java.util.Arrays;
import java.util.List;
import java.util.Stack;

import static java.util.stream.Collectors.*;

import java.util.ArrayList;

/*Write the following methods that return a lambda expression performing a specified action:
 *  PerformOperation isOdd(): The lambda expression must return true if a number is odd or if it is even.
 *   PerformOperation isPrime(): The lambda expression must return if a number is prime or if it is composite. 
 *   PerformOperation isPalindrome(): The lambda expression must return if a number is a palindrome or if it is not.
 *   1234 -4321*/
public class Java8Test {

	
	public static void main(String[] args) {
		
		List<Integer> listOfInputs= Arrays.asList(1,2,3,4,5,6,7,8,1221,898,314);
		List<Integer> listOfOddNumbers=listOfInputs.stream()
					.filter(Java8Test::isOdd)
					.collect(toList());
		System.out.println("listOfOddNumbers:"+listOfOddNumbers);
		
		List<Integer> listOfPrimeNumbers=listOfInputs.stream()
				.filter(Java8Test::isPrime)
				.collect(toList());
		System.out.println("listOfPrimeNumbers:"+listOfPrimeNumbers);
		
		List<Integer> listOfPalindromeNumbers=listOfInputs.stream()
				.filter(Java8Test::isPalindrome)
				.collect(toList());
		System.out.println("listOfPalindromeNumbers:"+listOfPalindromeNumbers);
	}
	
	public static boolean isOdd( int num)
	{
		return num%2!=0;
	}
	public static boolean isPrime( int num)
	{
		for(int i=2;i%2==0;i++)
		{
			return !(num%i==0);
		}
		return false;
		
	}
	public static boolean isPalindrome( int num)
	{
		String palindromeString=String.valueOf(num);
		
		Stack<Character> charStack= new Stack<>();
		String reversedString="";
		for (char charNum : palindromeString.toCharArray())
		{
			charStack.push(charNum);
		}
		while(!charStack.isEmpty())
		{

			reversedString=reversedString.concat(String.valueOf(charStack.pop()));
		}
		
		return palindromeString.equals(reversedString);
	}
		
}
