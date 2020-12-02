package arrays;

import java.util.Hashtable;

public class Anagram {

    static int NO_OF_CHARS = 256; 

	static boolean areAnagram(char[] str1, char[] str2) 
	{ 
		// Create a count array and initialize all values as 0 
		int[] count = new int[NO_OF_CHARS]; 
		int i; 

		// For each character in input strings, increment count in 
		// the corresponding count array 
		for (i = 0; i<str1.length-1 && i<str2.length-1; i++) { 
			count[str1[i]]++; 
			count[str2[i]]--; 
		} 

		// If both strings are of different length. Removing this condition 
		// will make the program fail for strings like "aaca" and "aca" 
		if (str1.length !=str2.length) 
			return false; 

		// See if there is any non-zero value in count array 
		for (i = 0; i < NO_OF_CHARS; i++) 
			if (count[i]!=0) {
				char c=(char) i;
				System.out.println("not an anagram because of: "+c);
				return false; }
		return true; 
	} 

	public static void main(String[] args) {
		String s1="aacva";
		String s2="avcaa";
		System.out.println(areAnagram(s1.toCharArray(),s2.toCharArray()));
		Hashtable<String, String> hashTableMap= new  Hashtable<>();
		hashTableMap.put("s1", "s1");
		//hashTableMap.put("s2", null);
		System.out.println(hashTableMap);
	}
}
