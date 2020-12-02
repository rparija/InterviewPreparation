package stack;
import java.util.*;

public class Stack {

	static Integer stack[] = new Integer[3];
	static int top = 0;

	public Stack() {
		stack = new Integer[2];
	}

	public static void push(int data) {
		if (top == size()) {
			expandStack();
			System.out.println("Stack is full");
		}
		stack[top] = data;
		top++;
	}

	public static void pop() {
		if (isEmpty()) {
			System.out.println("Stack is empty");
			return;
		}
		int data = 0;
		top--;
		data = stack[top];
		stack[top] = null;
		contractStack();
	}

	public static void show() {
		for (Integer i : stack) {
			System.out.print(i + ",");
		}
		System.out.println();
	}

	public static boolean isEmpty() {
		if (top == 0) {
			return true;
		}
		return false;
	}

	public static int size() {
		int size = 0;
		for (Integer i : stack) {
			size++;
		}
		return size;
	}

	public static int getMin() {
		int min = stack[0];
		for (Integer i : stack) {
			if (i != null && i < min) {
				min = i;
			}
		}
		return min;
	}

	public static int top() {
		if (!isEmpty()) {
			return stack[top - 1];
		}
		return stack[top - 1];
	}

	public static void expandStack() {

		Integer[] newStack = new Integer[top * 2];
		System.arraycopy(stack, 0, newStack, 0, top);
		stack = newStack;
	}

	public static void contractStack() {

		if (top == size() / 2) {
			Integer[] newStack = new Integer[top];
			System.arraycopy(stack, 0, newStack, 0, top);
			stack = newStack;

		}
	}
	
	public static boolean validateStackSequences(Integer[] pushed,Integer[] popped)
	{
		java.util.Stack<Integer> stack = new java.util.Stack<Integer>();
		int i=0, n=pushed.length;
		
		for(Integer data:pushed)
		{
			stack.push(data);
			while(!stack.isEmpty() && popped[i]==stack.peek())
			{
				stack.pop();
				i++;
			}
		}
		return i==n;
		
	}

	public static boolean validateBrackets(String s)
	{
		 Map<Character,Character> bracketMaps= new HashMap<Character,Character>();
	        bracketMaps.put('(',')');
	        bracketMaps.put('{','}');
	        bracketMaps.put('[',']');
		char [] brackets=s.toCharArray();
		java.util.Stack<Character> stack= new java.util.Stack<>();
		for(char c:brackets)
		{
			if(bracketMaps.containsKey(c))
			{
				stack.push(c);	
			}else
			{
				if(!stack.isEmpty()  && bracketMaps.get(stack.peek()).equals(c))
				{
					stack.pop();
				}else
				{
					return false;
				}
			}
			
		}
		if(stack.isEmpty())
			return true;
		
		return false;
	}
	
	public static void main(String[] args) {

	
		String s="[()]";
		System.out.println("bracket sequence is"+validateBrackets(s));

		
		Integer [] pushed = {1,2,3,4,5};
		Integer [] popped = {4,5,3,2,1};
System.out.println("stack sequence is"+validateStackSequences(pushed,popped));
		push(2);
		push(0); 
		push(3);
		push(0);
		push(0);
		System.out.println("minValue is :" + top());
		show();
		System.out.println("minValue is :" + getMin());
		pop();
		System.out.println("minValue is :" + getMin());
		pop();
		System.out.println("minValue is :" + getMin());
		pop();
		System.out.println(size());
		System.out.println(isEmpty());
		pop();
		pop();
		show();
		pop();
		pop();
		show();
		System.out.println(size());
		System.out.println(isEmpty());
	}
}
