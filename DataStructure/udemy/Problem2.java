package udemy;

import java.util.Arrays;

/*LeetCode 189. Rotate Array*/
public class Problem2 {

	public static void main(String[] args) {
		Integer [] array= {1,2,3,4,5,6,7};
		int k=2;
		k=k%array.length;
		reverseArray(array,0,array.length-1);
		reverseArray(array,0,k-1);
		reverseArray(array,k,array.length-1);
		Arrays.stream(array).forEach(e-> System.out.print(e+ ","));
		
	}
	public static void reverseArray(Integer [] array,int start,int end)
	{
		while(start<end)
		{
			int temp=array[start];
			array[start]=array[end];
			array[end]=temp;
			start++;
			end--;
		}
		
		
	}
}
