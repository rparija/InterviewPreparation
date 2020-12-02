package arrays;

import java.util.Stack;

public class ReverseAString {

	public static void main(String[] args) {
		String input = "Abc18@gmail.com";
		System.out.println("Input: " + input);
		char[] charArray = input.toCharArray();
		String specialCharacters = " !#$%&'()*+,-./:;<=>?@[]^_`{|}";
		input = "";
		Stack<Character> stackOfChar = new Stack<Character>();
		for (Character c : charArray) {
			if (!specialCharacters.contains(String.valueOf(c)))
				stackOfChar.push(c);
			else {

				input = input.concat(
						stackOfChar.stream().
						map(e -> String.valueOf(e)).
						reduce("", (e, carry) -> carry.concat(e)));
				input = input.concat(String.valueOf(c));
				stackOfChar = new Stack();

			}
		}
		if (!stackOfChar.isEmpty()) {
			while (!stackOfChar.isEmpty())
				input = input.concat(String.valueOf(stackOfChar.pop()));
		}
		stackOfChar = null;
		charArray = null;
		System.out.println("Output: " + input);
	}
}