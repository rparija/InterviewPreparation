package arrays;

import java.util.HashSet;

public class PracticeSubPairWithSumEqualToK {

	public static void main(String[] args) {
		int k=5;
		int[] array= {4,2,3,1};
		HashSet<Integer> set= new HashSet<Integer>(); 
		for(int i=0;i<array.length;i++)
		{
			if(set.contains(k-array[i]))
			{
				System.out.println("pair with sum "+k+" is"+(k-array[i]) +","+array[i]);
			}
			set.add(array[i]);
		}
	}
}
