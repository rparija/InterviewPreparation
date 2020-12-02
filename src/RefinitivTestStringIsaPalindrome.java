import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class RefinitivTestStringIsaPalindrome {

	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(123, 989, 121, 133, 142);
		int sum = inputNumbers(numbers);
		System.out.println("Sum of palindrome numbers " + sum);
	}

	public static int inputNumbers(List<Integer> numbers) /* 989,121,133,142 */
	{
		/*
		 * first convert this integer into a string then i will call tochar methd to get
		 * an array of characters
		 */

		/*
		 * stack i will add the numbers there and once the number is inserted i can
		 * check with the string.
		 */

		int sum = 0;

		for (Integer intNumber : numbers) {

			String number = String.valueOf(intNumber);
			char[] num = number.toCharArray();
			
			Stack<Character> stack = new Stack<Character>();
			for (Character c : num) {
				stack.push(c);
			}
			String palindromNumber = "";
			while (!stack.isEmpty()) {

				palindromNumber = palindromNumber.concat(String.valueOf(stack.pop()));
			}

			if (number.equals(palindromNumber)) {
				System.out.println(number + " is a palindrome");
				sum = sum + Integer.parseInt(number);
			} else {
				System.out.println(number + " is not a palindrome");
			}

		}
		return sum;

	}
}
