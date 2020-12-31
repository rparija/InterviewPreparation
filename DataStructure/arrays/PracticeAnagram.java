package arrays;

import java.util.Arrays;

public class PracticeAnagram {

	public static void main(String[] args) {
		String anagram1="RAHUL";
		String anagram2="LUHAR";
		System.out.println("two string are anagram :"+isAnagram(anagram1,anagram2));
	}

	private static boolean isAnagram(String anagram1,String anagram2) {
		int[] array= new int[256];
		char [] anagramArray1=anagram1.toCharArray();
		char [] anagramArray2=anagram2.toCharArray();
		for(char c:anagramArray1)
		{
			if(array[Character.getNumericValue(c)]==0)
			{
				array[Character.getNumericValue(c)]=1;	
			}else
			{
				array[Character.getNumericValue(c)]=0;	
			}
		}
		for(char c:anagramArray2)
		{
			 if(array[Character.getNumericValue(c)]==1)
			{
				array[Character.getNumericValue(c)]=0;
			}else
			{
				array[Character.getNumericValue(c)]=1;	
			}
		}
		for(int i:array)
		{
			if(i==1)
			{
				return false;
			}
		}
		return true;
	}
}
