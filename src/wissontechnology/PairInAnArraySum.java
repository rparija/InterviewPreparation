package wissontechnology;

import java.util.HashSet;
import java.util.Set;

/*pair in a array whose sum is 5*/
public class PairInAnArraySum {

	public static void main(String[] args) {
		int [] array= {2,3,4,1};
		int sum=5;
		Set<Integer> uniqueSum= new HashSet<Integer>();
		for(int i:array)
		{
			if(uniqueSum.contains(sum-i))
			{
				System.out.println("pairs are "+(sum-i)+","+i+" having sum:"+sum);
			}
			uniqueSum.add(i);
		}
	}
	
}
