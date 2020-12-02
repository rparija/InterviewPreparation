package arrays.Sorting;

public class MergeSorting {

	public static void main(String[] args) {

		Integer [] array = { 3, 19, 9, 1, 4, 2, 12 };
		for (int i : array) {
			System.out.print(i + ",");
		}
		mergeSort(array);
		System.out.println("after sorting");
		for (int i : array) {
			System.out.print(i + ",");
		}

	}

	public static void mergeSort(Integer [] array) {

		int n = array.length;
		if (n < 2) {
			return;
		}
		int midPoint = Math.abs(n / 2);
		Integer[] leftArray = new Integer[midPoint];
		Integer[] rightArray = new Integer[n - midPoint];

		for (int i = 0; i < midPoint; i++) {
			leftArray[i] = array[i];
		}

		for (int i = midPoint, j = 0; i < n; i++, j++) {
			rightArray[j] = array[i];
		}
		
		mergeSort(leftArray);
		mergeSort(rightArray);
		mergeArrayAndSort(leftArray,rightArray,array);
	}

	private static void mergeArrayAndSort(Integer[] leftArray, Integer[] rightArray, Integer[] array) {

		int i = 0,j=0,k=0;
		
		while(i<leftArray.length && j<rightArray.length)
		{
			
			if(leftArray[i]<rightArray[j])
			{
				array[k]=leftArray[i];
				k++;
				i++;
			}else
			{
				array[k]=rightArray[j];
				k++;
				j++;
				
			}
		}
	
		while (j<rightArray.length)
		{
			array[k]=rightArray[j];
			k++;
			j++;
			
		}
		while(i<leftArray.length)
		{
			array[k]=leftArray[i];
			k++;
			i++;
		}
		
		
	}
}
