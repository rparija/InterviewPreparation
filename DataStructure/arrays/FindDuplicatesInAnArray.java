package arrays;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

public class FindDuplicatesInAnArray {

	
	public static void main(String args[]) { 
        int numRay[] = {0, 4, 30, 20, 7, 8, 20, 30, 1}; 
   
       /* for (int i = 0; i < numRay.length; i++) { 
            numRay[numRay[i] %  numRay.length] = numRay[numRay[i] %  numRay.length] + numRay.length; 
        } 
        System.out.println("The repeating elements are : "); 
        for (int i = 0; i < numRay.length; i++) { 
            if (numRay[i] >= numRay.length*2) { 
                System.out.println(i + " "); 
            } 
        }
        numRay = {0, 4, 30, 20, 7, 8, 20, 30, 1}; */
        findDuplicate(numRay);
        System.out.println();
        findDuplicatesPractice(numRay);
    } 
	
	 private static void findDuplicatesPractice(int[] numRay) {
		 
		 HashMap<Integer,Integer> hashMap= new HashMap<Integer,Integer>();
		 int count=0;		
		 for(int num:numRay)
		 {
			 count=0;
			 if(hashMap.containsKey(num))
			 {
				 count=hashMap.get(num);
			 }
			 hashMap.put(num, ++count);
		 }
		 hashMap.entrySet().stream()
		 					.filter(e-> e.getValue()>1)
		 					.map(e->e.getKey())
		 					.forEach(System.out::println);
	}

	public static void findDuplicate(int[] nums) {
	        
	        HashMap<Integer,Integer> map= new HashMap<>();
	        
	        for (int i: nums)
	        {
	        	int count=0;
	            if(map.get(i) == null)
	            {
	            map.put(i,count+1);
	            }
	            else
	            {
	                count=map.get(i);
	                map.put(i,count+1);
	            }
	        }
	        
	        for (Entry<Integer, Integer> i: map.entrySet())
	        {
	            if(i.getValue()>1)
	            {
	            	System.out.println(i.getKey());
	            }
	        }
	    }
	} 


