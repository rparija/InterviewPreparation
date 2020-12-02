package onetrust;

public class ArrayMinimumTrailing {

	public static void main(String[] args) {

		Integer[] array = { 7,9,5,6,3,2 };

		int low = array[0];
		int diff = -1;
		for (int i = 1; i < array.length - 1; i++) {
			if (low > array[i]) {
				low = array[i];
			} else {
				if (diff < (array[i] - low)) {
					diff = array[i] - low;
				}
			}
		}
		System.out.println(diff);
	}
}
