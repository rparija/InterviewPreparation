package arrays;

public class TwoDimensionalArray {

	/**
	 * @param args
	 */
	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int twoDArray[][] = { 	{ 1, 2, 3 },
								{ 4, 5, 6 }, 
								{ 7, 8, 9 }
							};
		
		for(int[] array:twoDArray)
		{
			for(int value:array)
			{
				System.out.print("  "+value);
			}
			System.out.println();
		}

		System.out.println();

		// this is a jagged array
		int assortedtwoDArray[][] = { 	{ 1, 2, 3 },
										{ 4, 5, 6 ,7, 8, 9 }, 
										{ 10, 11, 12 }
									};
		
		for(int [] array:assortedtwoDArray)
		{
			for(int value:array)
			{
				System.out.print("  "+value);
			}
			System.out.println();
		}
	}
}
