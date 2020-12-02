package arrays;


import arrays.Sorting.MergeSorting;

public class BinarySearch {

	public static void main(String[] args) {

		Integer[] array = { 2, 3, 14, 4, 13, 21, 12, 1 };
		MergeSorting.mergeSort(array);
		int number = 3;

		for (int i : array) {
			System.out.print(i + ",");
		}
		findNumberInArray(array, 0, array.length - 1, number);
	}

	private static void findNumberInArray(Integer[] array, int startIndex, int endIndex, int number) {

		
		int numberFound=binarySearch(array,startIndex,endIndex,number);
		if(numberFound==-1)
		{
			System.out.println(number +"is not present in this array");

		}else
		{
			System.out.println(number +"is present at Index"+numberFound);

		}
		
	}

	private static int binarySearch(Integer[] array, int startIndex, int endIndex, int number) {

		int midIndex=(startIndex+endIndex)/2;
		if(array[midIndex]==number)
		{
			return midIndex;

		}		
		if(startIndex==endIndex)
		{
			return -1;
		}
		if(array[midIndex]> number)
		{
			endIndex=midIndex-1;
			return binarySearch(array,startIndex,endIndex,number);
		}
		if(array[midIndex]< number)
		{
			startIndex=midIndex+1;
			return binarySearch(array,startIndex,endIndex,number);

		}		
		return -1;
		
	}
	
	
	
	
}
