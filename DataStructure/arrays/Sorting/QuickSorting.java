package arrays.Sorting;

public class QuickSorting {

	public static void main(String[] args) {

		Integer [] array = { 3, 19, 9, 1, 4, 2, 12 };
		for (int i : array) {
			System.out.print(i + ",");
		}
		quickSort(array,0,array.length);
		System.out.println("after sorting");
		for (int i : array) {
			System.out.print(i + ",");
		}

	}

	private static void quickSort(Integer[] array, int start, int end) {
		
	int pivotIndex=partition(array,start,end);	
	if(pivotIndex!=0)
	{
	quickSort(array,start,pivotIndex-1);
	quickSort(array,pivotIndex,end);
	}
	}

	private static int partition(Integer[] array, int start, int end) {

		if(start == end)
		{
			return 0;
		}
		int pivot=array[end-1];
		int pivotIndex=0;
		for (int i = 0; i < end; i++) {
			if(pivot>=array[i])
			{
				swap(array,pivotIndex,i);
				pivotIndex++;
			}
		}
		for (int i : array) {
			System.out.print(i + ",");
		}
		System.out.println(pivotIndex);
		return pivotIndex;
	}

	private static void swap(Integer[] array, int pivotIndex, int i) {
		int temp=array[i];
		array[i]=array[pivotIndex];
		array[pivotIndex]=temp;
	}
	

}
