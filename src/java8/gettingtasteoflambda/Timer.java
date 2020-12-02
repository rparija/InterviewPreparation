package java8.gettingtasteoflambda;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Timer {

	public static void main(String[] args) {
		int b=96;
		System.out.println(b>>4);
		System.out.println(b>>>4);
		
		String s1="abc";
		String s2="abc";
		System.out.println(s1==s2);
		
		
		List<String>  names=Arrays.asList("Raul","Rich","Raul","Ronald");
		
		Map<String,char[]> map= new HashMap<>();
		for (String string : names) {
			if(string.startsWith("Ra"))
			{
			
				map.put(string,string.toCharArray());
			
			}
		}
		HashMap<Character,Integer> hashMap= new HashMap<Character,Integer>();
		for (char[] c : map.values()) {
			
			for(char car: c )
			{
				int count=0;
				if(!hashMap.containsKey(car))
				{	
				hashMap.put(car,count++);
				}

			}
		}
			
	}
}
