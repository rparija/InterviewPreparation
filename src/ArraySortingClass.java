import java.util.Arrays;

public class ArraySortingClass {

	public static void main(String[] args) {
		
		Integer [] array = {4,3,6,2,5,9,1,8};
		
		for(int i=0; i<array.length;i++)
		{
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
		
		Arrays.stream(array).forEach(System.out::println);
	}
	
}
