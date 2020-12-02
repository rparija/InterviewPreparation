package practice;

public class MergeSort {

	public static void main(String[] args) {
		Integer[] array= {21,31,3,9,7,1};
		
	sortArrayUsingMergeSort(array);
	
	for (int i : array) {
		System.out.print(i + ",");
	}
	}

	private static void sortArrayUsingMergeSort(Integer[] array) {
		
		if(array.length==1)
		{
			return;
		}
		int median=Math.abs(array.length/2);
		
		Integer [] leftArray= new Integer[median];
		Integer [] rightArray= new Integer[array.length-median];
		
		for(int i=0;i<leftArray.length;i++)
		{
			leftArray[i]=array[i];
		}
		
		for(int i=0;i<rightArray.length;i++)
		{
			rightArray[i]=array[median++];
		}
		
		sortArrayUsingMergeSort(leftArray);
		sortArrayUsingMergeSort(rightArray);
		sortAndMergeArray(array,leftArray,rightArray);
		
	}

	private static void sortAndMergeArray(Integer[] array, Integer[] leftArray, Integer[] rightArray) {
		
		int i = 0,j = 0,k=0;
		while(i<leftArray.length && j<rightArray.length)
		{
			if(leftArray[i]>rightArray[j])
			{
				array[k]=rightArray[j];
				j++;
				k++;
			}else
			{
				array[k]=leftArray[i];
				i++;
				k++;
			}
		}
		
		while(i<leftArray.length)
		{
			array[k]=leftArray[i];
			i++;
			k++;
		}
		while(j<rightArray.length)
		{
			array[k]=rightArray[i];
			j++;
			k++;
		}
		
	}
}
