package corejava;

import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class CollectionsPractice {

	public static void main(String[] args) {
		
		Set<String> set= new HashSet();
		set.add("Raul");
		set.add(null);
		System.out.println(set.contains(null));
		System.out.println(set);
		
		Map<String,String> hashTable= new Hashtable<>();
		/*Hashtable doesn't allows null keys as well as null values*/
		//hashTable.put("null", null);
		
		hashTable.entrySet().stream()
		.forEach((k)->
		{
			System.out.println(k.getKey().concat(":").concat(k.getValue().toString()));
		}
		);
		
		/*Map Demo java8 funtional interfaces*/
		Map<String,Integer> treeMap= new TreeMap();
		treeMap.put("ipad", 10);
		treeMap.put("ipad", 100);
		treeMap.put("ghome", 10);
		treeMap.entrySet().stream()
		.forEach((k)->
		{
			System.out.println(k.getKey().concat(":").concat(k.getValue().toString()));
		}
		);
		treeMap = new TreeMap<String,Integer>((s1,s2)-> {
			return s1.compareTo(s2);
		});
		System.out.println("After sorting");
		treeMap.put("ipad", 10);
		treeMap.put("ipad", 100);
		treeMap.put("ghome", 10);
		treeMap.entrySet().stream()
		.forEach((k)->
		{
			System.out.println("After sorting"+k.getKey().concat(":").concat(k.getValue().toString()));
		}
		);
		Map<String,Integer> map= new HashMap();
		
		map.put("ipad", 10);
		map.put("alexa", 10);
		map.put("ghome", 10);
	
		map.entrySet().stream()
					.forEach((k)->
					{
						System.out.println(k.getKey().concat(":").concat(k.getValue().toString()));
					}
	);
		map.compute("ipad", (k,v)->v+1);
		map.entrySet().stream()
		.forEach((k)->
		{
			System.out.println(k.getKey().concat(":").concat(k.getValue().toString()));
		}
		);
		/*if the key passed is not present then it will throw null pointer
		 * like oneplus is not present in the map so it will throw null pointer*/
		//map.compute("oneplus", (k,v)->v+1);
		/*map.entrySet().stream()
		.forEach((k)->
		{
			System.out.println(k.getKey().concat(":").concat(k.getValue().toString()));
		}
		);*/
		map.computeIfAbsent("OnePlus", k->12);
		map.entrySet().stream()
		.forEach((k)->
		{
			System.out.println(k.getKey().concat(":").concat(k.getValue().toString()));
		}
		);
		
		map.computeIfPresent("OnePlus", (k,v)-> v+10);
		map.entrySet().stream()
		.forEach((k)->
		{
			System.out.println(k.getKey().concat(":").concat(k.getValue().toString()));
		}
		);
		
		map.merge("OnePlus", 10, Integer::sum);
		map.entrySet().stream()
		.forEach((k)->
		{
			System.out.println(k.getKey().concat(":").concat(k.getValue().toString()));
		}
		);
		
		int index = 118 & (16-1);
		System.out.println(index);

	}
}
