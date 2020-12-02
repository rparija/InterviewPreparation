package corejava;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

	/*
	 * Complete the 'fizzBuzz' function below.
	 *
	 * The function accepts INTEGER n as parameter.
	 */

	public static void fizzBuzz(int n) {
		// Write your code here
		for (int i = n; i > 0; i--) {
			if (i % 5 == 0 && i % 3 == 0) {
				System.out.println("FizzBuzz");
			} else if (i % 3 == 0 && i % 3 != 0) {
				System.out.println("Fizz");
			} else if (i % 5 == 0 && i % 3 == 0) {
				System.out.println("Buzz");
			} else {
				System.out.println(i);
			}
		}
	}

	public static void main(String[] args) {
	fizzBuzz(12);
	String s="1/3/2012 16:00:00	26.96";
	if(s.contains("Missing"))
	{
	s.split(" ");
	}
	String [] sarray=s.split("	");
	sarray=sarray[1].split(" ");
	System.out.println(sarray);
}
}
