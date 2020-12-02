package arrays.Sorting;

public class SelectionSorting {

	public static void main(String[] args) {
		int[] array= {23,31,1,221,12,15,-1,-11};
		
	for (int i = 0; i < array.length; i++) {
		int minimumElementIndex=i;
		
		for(int j=i;j<array.length;j++)
		{
			if(array[minimumElementIndex]>array[j])
			{
				minimumElementIndex=j;
			}
			
		}
		int temp=array[i];
		array[i]=array[minimumElementIndex];
		array[minimumElementIndex]=temp;
		
		
	}
		
		for (int i : array) {
			System.out.print(i+",");
		}
	}
}
