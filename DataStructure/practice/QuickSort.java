package practice;

public class QuickSort {

	public static void main(String[] args) {
		Integer[] array= {1,2,6,4,3,5,9};
		
	sortArrayUsingQuickSort(array,0,array.length-1);
	
	for (int i : array) {
		System.out.print(i + ",");
	}
	}

	private static void sortArrayUsingQuickSort(Integer[] array, int left, int right) {
		if(left>=right)
		{
			return;
		}
		int pivot=array[(right+left)/2];
		int pivotIndex=partition(array,left,right,pivot);
		sortArrayUsingQuickSort(array,left,pivotIndex-1);
		sortArrayUsingQuickSort(array,pivotIndex,right);
	}

	private static int partition(Integer[] array, int left, int right, int pivot) {
		
		while(left<=right)
		{
			while(array[left]<pivot)
			{
				left++;
			}
			while(array[right]>pivot)
			{
				right--;
			}
			if(left<=right)
			{
				swap(array,left,right);
				left++;
				right--;

			}
		}
		return left;
	}

	private static void swap(Integer[] array, Integer i, Integer pivot) {
		
		int temp=array[i];
		array[i]=array[pivot];
		array[pivot]=temp;
		
	}

	
}
