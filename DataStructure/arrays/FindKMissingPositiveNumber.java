package arrays;

public class FindKMissingPositiveNumber {

	public static void main(String[] args) {
		int[] arrayOfIntegers = {-2,11,1,-3,3,10,4};//{ 2, 2, 1, 7, -2, 4, 5 };
	
		int[] arrayOfMissingPositiveNumbers = new int[5] ;

		for (int i : arrayOfIntegers) {
			System.out.print(i + ",");
		}
		System.out.println();
		for (int i = 0; i < arrayOfIntegers.length; i++) {
			if (arrayOfIntegers[i] > 0 && arrayOfIntegers[i] <= arrayOfIntegers.length && arrayOfIntegers[i] != i + 1) {
				// swap the index
				int temp = arrayOfIntegers[i];
				arrayOfIntegers[i] = arrayOfIntegers[temp - 1];
				arrayOfIntegers[temp - 1] = temp;
			}
		}
		for (int i : arrayOfIntegers) {
			System.out.print(i + ",");
		}
		int j=0;
		for (int i = 0; i < arrayOfIntegers.length; i++) {
			if (i+1 != arrayOfIntegers[i] && j<arrayOfMissingPositiveNumbers.length) {
				arrayOfMissingPositiveNumbers[j] = i+1;
				j++;
			}
		}
		System.out.println();
		for (int i : arrayOfMissingPositiveNumbers) {
			System.out.print(i>0?i:"");
			System.out.print(",");
		}
	}

}
