package arrays;

import java.util.Arrays;

public class ReverseAnArray {

	public static void main(String[] args) {

		int[] array = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12 };
		reverseTheArrayPractice(array);
		for (int i : array) {
			System.out.print(i + ",");
		}
		System.out.println();
		if (array.length > 0)
			for (int i = 0; i < array.length / 2; i++) {
				if (array[i] != array[(array.length - 1 - i)]) {
					int temp = array[i];
					array[i] = array[array.length - 1 - i];
					array[array.length - 1 - i] = temp;
				} else {
					break;
				}
			}
		for (int i : array) {
			System.out.print(i + ",");
		}
	}

	private static int[] reverseTheArrayPractice(int[] array) {

		for (int i = 0; i < Math.abs(array.length/2); i++) {
			int temp=array[i];
			array[i]=array[array.length-1-i];
			array[array.length-1-i]=temp;
		}
		Arrays.stream(array).forEach(a->System.out.print(a+","));
		return array;

	}

	public int[] swap(int[] array) {

		for (int i = 0; i < Math.abs(array.length/2); i++) {
			int temp=array[i];
			array[i]=array[array.length-1-i];
			array[array.length-1-i]=temp;
		}
		Arrays.stream(array).forEach(System.out::print);
		return array;

	}
}
