package arrays.Sorting;

public class BubbleSorting {

	public static void main(String[] args) {
		int[] array= {23,31,1,221,12,15,-1,-11};
		
		for (int i = 0; i < array.length; i++) {
			
			for(int j=i;j<array.length;j++)
			{
				if(array[i]>array[j])
				{
					int temp=array[i];
					array[i]=array[j];
					array[j]=temp;
				}
			}
			
		}
		
		for (int i : array) {
			System.out.print(i+",");
		}
	}
}
