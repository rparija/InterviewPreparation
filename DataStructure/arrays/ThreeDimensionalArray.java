package arrays;

public class ThreeDimensionalArray {

	public static void main(String[] args) {

		int[][][] threeDArray = { { { 1, 2, 3, 4 } }, { { 4, 5, 6, 7 }, { 8, 9, 10, 11 }

				}, { { 12, 13, 14 }, { 15, 16, 17, 18 } }

		};

		for (int[][] twoDarray : threeDArray) {
			for (int[] oneDArray : twoDarray) {
				for (int value : oneDArray) {
					System.out.print("  " + value);
				}
				System.out.println();
			}
			System.out.println();
		}
	}
}
