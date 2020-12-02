package arrays;

import java.util.HashSet;

import javax.print.attribute.HashAttributeSet;

public class SubPairWithSumEqualToK {

	public static void main(String[] args) {
		
		Integer [] array= {2,3,4,1,10,-5};
		int k=5;
		
		HashSet<Integer> s= new HashSet();
		for(int i=0;i<array.length;i++)
		{
			int temp=k-array[i];
			
			if(s.contains(temp))
			{
				System.out.println("pair with sum"+k+" is"+temp +","+array[i]);
			}
			s.add(array[i]);
		}
	}
	
}
