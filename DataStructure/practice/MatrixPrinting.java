package practice;

public class MatrixPrinting {

	public static void main(String[] args) {
		int count=0;
		for(int i=0;i<3;i++)
		{
			for(int j=0;j<=i;j++)
			{
				System.out.print(++count);
			}
			System.out.println();
		}
	}
}

