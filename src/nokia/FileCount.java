package nokia;

import java.io.File;

public class FileCount {

	public static int countFiles(File file, int count)
	{
		File [] list=file.listFiles();
		for(File f:list)
		{
			if(f.isFile())
			{
				count++;
			}else
			{
				count=countFiles(f,count);
			}
		}
		return count;
	}
	
	public static void main(String[] args) {
		File file = new File("C:\\Users\\rparija\\Desktop\\imp docs\\assignment3\\configBackUp");
		int count=0;
		System.out.println(countFiles(file,count));
	}
}
