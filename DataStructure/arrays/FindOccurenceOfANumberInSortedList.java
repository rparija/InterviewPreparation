package arrays;

public class FindOccurenceOfANumberInSortedList {

	// we would use Binary sort to find the first occurence and the last occurence
	// of number and then will calculate the number of occurences using the first
	// and last occurence index

	//this problem can also be used for finding the first and last index
	public static void main(String[] args) {

		int[] sortedArray = { 1, 1, 3, 3, 5, 5, 5, 5, 5, 9, 9, 11 };
		int num = 11;
		int firstIndex = binarySearch(sortedArray, num, true);
		int lastIndex = binarySearch(sortedArray, num, false);
		System.out.println("total number of occurence of " + num + " is " + ((lastIndex - firstIndex)+1));
	}

	private static int binarySearch(int[] sortedArray, int num, boolean firstIndex) {
		int startIndex = 0;
		int endIndex = sortedArray.length - 1;
		int result = -1;
		while (startIndex <= endIndex) {
			int median = Math.abs((startIndex + endIndex) / 2);

			if (sortedArray[median] == num) {
				result = median;
				if (firstIndex) {
					endIndex = median - 1;
				} else {
					startIndex = median + 1;
				}
			} else if (sortedArray[median] > num) {
				endIndex = median - 1;
			} else if (sortedArray[median] < num) {
				startIndex = median + 1;
			}

		}
		return result;
	}
}
