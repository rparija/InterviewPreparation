package practice;

import java.util.HashMap;
import java.util.Stack;

public class MatchingBrackets {

	public static void main(String[] args) {
		
		String s="{[()]}";
		char[] bracketArray=s.toCharArray();
		HashMap<Character,Character> bracketMap= new HashMap<>();
		bracketMap.put('{', '}');
		bracketMap.put('[', ']');
		bracketMap.put('(', ')');
		Stack stack = new Stack<Character>();
		
		for(int i=0;i<bracketArray.length;i++)
		{
			if(!stack.isEmpty() && bracketMap.get(stack.peek())!=null &&bracketArray[i]==bracketMap.get(stack.peek()))
			{
				stack.pop();
			}else {
			stack.push(bracketArray[i]);}
		}
		if(stack.isEmpty())
		{
			System.out.println("brackets are in pair");
		}else
		{
			System.out.println("brackets are not in pair");
		}
	}
}
