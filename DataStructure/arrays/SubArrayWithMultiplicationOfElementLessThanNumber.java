package arrays;

import java.util.ArrayList;
import java.util.List;

public class SubArrayWithMultiplicationOfElementLessThanNumber {

	
	
	public static void main(String[] args) {
		int []array= {4,2,5,3,6};
		int number=45;
		int multiplicationFactor=1;
		int start=0;
		List<List<Integer>> subArray = new ArrayList<>();
		List <Integer>arrayList = null;
		for (int i = 0; i < array.length; i++) {
			 arrayList= new ArrayList<>();

			for(int j =i; j< array.length;j++)
			{
				multiplicationFactor=multiplicationFactor*array[j];

				if(multiplicationFactor>number)
				{
					multiplicationFactor=1;
					break;
				}
				else
				{
				arrayList.add(0,array[j]);
				subArray.add(new ArrayList<>(arrayList));
				}
			}
		}
		//subArray.stream().forEach(s-> s.forEach(sint-> System.out.println(sint)));
		for (List<Integer>  object : subArray) {
			for (int object2 : object) {
				System.out.print(object2);
			}
			System.out.println();
		}
	}
}
