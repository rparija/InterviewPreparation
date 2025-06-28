package arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class FindTripletSumWhichIsCloseToTargetSum {

	public static void main(String[] args) {
		int [] array = {2,-3,4,-2};
		
		int targetSum=1;
		Map<ArrayList,Integer> targetSumMap = new HashMap<ArrayList,Integer>();
		
		for (int i = 0; i < array.length; i++) {
			for(int j=i; j<array.length;j++)
			{
				int tripletSum=array[i]+array[j+1]+array[j+2];
				tripletSum=tripletSum-targetSum;
				ArrayList list= new ArrayList<>();
				list.add(0,array[i]);
				list.add(1,array[i+1]);
				list.add(2,array[i+2]);
				targetSumMap.put(list, tripletSum);
			}
		}
		
	/*	for (int i : targetSumMap.values()) {
			if(i>)
			{
				
			}
		}*/
	}
}
