package udemy;

import java.util.Arrays;

/*find if the elements in first array are present in the second array*/
public class Problem1 {

	public static void main(String[] args) {
	
		Character [] array1= {'a','b','c','d'};
		Character [] array2= {'z','e','f','s'};
		
		Integer [] array3= new Integer[256];
		
		for(int i=0;i<array1.length;i++)
		{
			if(array3[array1[i]]==null)
			{
				array3[array1[i]]=1;
			}
		}
		
		Arrays.stream(array3).
						filter(e-> e!=null).
							forEach(System.out::println);
		boolean noCommonValue=false;
		for(int i=0;i<array2.length;i++)
		{
			if(array3[array2[i]]!=null)
			{
				System.out.println(array2[i]+" Value is present at index "+ (int)array2[i] );
				noCommonValue=true;
			}
		}
		if(!noCommonValue)
		{
			System.out.println("No common values between two arrays");
		}
	}
	
}
