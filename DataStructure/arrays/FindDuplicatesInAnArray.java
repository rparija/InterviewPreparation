package arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

public class FindDuplicatesInAnArray {

	public static void main(String args[]) {
		int numRay[] = { 1, 2, 3, 3, 4, 5, 4, 5, 6 };

		/*
		 * for (int i = 0; i < numRay.length; i++) { numRay[numRay[i] % numRay.length] =
		 * numRay[numRay[i] % numRay.length] + numRay.length; }
		 * System.out.println("The repeating elements are : "); for (int i = 0; i <
		 * numRay.length; i++) { if (numRay[i] >= numRay.length*2) {
		 * System.out.println(i + " "); } } numRay = {0, 4, 30, 20, 7, 8, 20, 30, 1};
		 */
		findDuplicate(numRay);
		System.out.println();
		findDuplicatesPractice(numRay);
		System.out.println();
		List list=findDuplicatedWithOutExtraSpace(numRay);
		list.stream().forEach(System.out::println);
	}

	private static void findDuplicatesPractice(int[] numRay) {

		HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
		int count = 0;
		for (int num : numRay) {
			count = 0;
			if (hashMap.containsKey(num)) {
				count = hashMap.get(num);
			}
			hashMap.put(num, ++count);
		}
		hashMap.entrySet().stream().filter(e -> e.getValue() > 1).map(e -> e.getKey()).forEach(System.out::println);
		System.out.println();

	}

	public static void findDuplicate(int[] nums) {

		HashMap<Integer, Integer> map = new HashMap<>();

		for (int i : nums) {
			int count = 0;
			if (map.get(i) == null) {
				map.put(i, count + 1);
			} else {
				count = map.get(i);
				map.put(i, count + 1);
			}
		}

		for (Entry<Integer, Integer> i : map.entrySet()) {
			if (i.getValue() > 1) {
				System.out.println(i.getKey());
			}
		}
		System.out.println();
	}

	static List<Integer> findDuplicatedWithOutExtraSpace(int[] nums) {
		List<Integer> newList = new ArrayList<Integer>(); // creating a new List
		for (int i = 0; i < nums.length; i++) {
			int index = Math.abs(nums[i]); // Taking the absolute value to find index
			if (nums[index - 1] > 0) {
				nums[index - 1] = -nums[index - 1];
			} else {
				// If it is not greater than 0 (i.e) negative then the number is a duplicate
				newList.add(Math.abs(nums[i]));
			}
		}
		return newList;
	}

}
