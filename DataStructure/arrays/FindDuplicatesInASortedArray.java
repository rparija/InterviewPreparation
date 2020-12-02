package arrays;

import java.util.Arrays;

/*find duplicates without using any extra space*/
public class FindDuplicatesInASortedArray {

	public static void main(String[] args) {
		/*int[] array= {1,1,2,2,3,3,4,4};
		
		int index=1;
		for(int i=0;i<array.length-1;i++)
		{
			if(array[i]!=array[i+1])
			{
				
				array[index++]=array[i+1];
			}
		}
		Arrays.stream(array).forEach(System.out::println);*/
		
		
		int [] array =  {10,12,12,13,13,14};
		int index=1;

		for (int i=0; i<array.length-1;i++)
		{
			if(array[i]!=array[i+1])
			{
				array[index++] =array[i+1];
			}
		}
		Arrays.stream(array).forEach(System.out::println);
	}
}
