package arrays.Sorting;

public class InsertionSorting {

	public static void main(String[] args) {
		int[] array = { 0,1,0,1,1,0,1};

		for (int i = 0; i < array.length; i++) {
			int temp = array[i];
			if (i < array.length - 1)
				temp = array[i + 1];
			for (int j = i; j >= 0; j--) {
				if (array[j] > temp) {
					array[j + 1] = array[j];
					array[j] = temp;
				}
			}
		}

		for (int i : array) {
			System.out.print(i + ",");
		}
	}
}
