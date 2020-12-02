package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Function;

import static java.util.stream.Collectors.*;

import javax.swing.plaf.synth.SynthSeparatorUI;

public class SortArrayBasedOnFrequencyOfValue {

	public static void main(String[] args) {
		Integer[] array = { 10, 7, 10, 11, 10, 11, 5, 6 };
		Map<Integer, Long> hashMap=Arrays.stream(array)
			.collect(groupingBy(Function.identity(),counting()));
		System.out.println(hashMap);
	
		LinkedHashMap<Integer, Integer> frequencyMap = new LinkedHashMap<>();
		for (int i = 0; i < array.length; i++) {
			int count = 0;
			if (frequencyMap.containsKey(array[i])) {
				count = frequencyMap.get(array[i]);
			}
			frequencyMap.put(array[i], ++count);
		}

		frequencyMap.entrySet().forEach(s -> System.out.println(s));
		List<Entry<Integer, Integer>> keyList = new ArrayList(frequencyMap.entrySet());
		sortMap(keyList);
		keyList.forEach(s -> System.out.println(s));
		keyList.forEach(entry -> {
			int frequency=entry.getValue();
			while(frequency>0)
			{
				System.out.print(entry.getKey()+",");
				frequency --;
			}
		});
	}

	private static void sortMap(List<Entry<Integer, Integer>> keyList) {

		Collections.sort(keyList, new Comparator<Entry<Integer, Integer>>()
				{

					@Override
					public int compare(Entry<Integer, Integer> o1, Entry<Integer, Integer> o2) {
						
						return o2.getValue().compareTo(o1.getValue());
					}
			
				});
				
	}

}
