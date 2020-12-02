package corejava;

import java.util.Random;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringExercise {
	

	public static void main(String[] args) {

		String str1 = "Raul";
		String str3 = "Ra";
		String str2 = new String("Raul");
		
		if (str1.equals(str2)) {
			System.out.print(true);
		}
		if (str1==(str2)) {
			System.out.print(true);
		}
		if (str1==str3.concat("ul")) {
			System.out.print(true);
		}
		
		StringTokenizer st= new StringTokenizer("AL;SK");
		while(st.hasMoreTokens())
		{
			String token=st.nextToken();
			System.out.println("token"+token);
		}
		Random random = new Random();
		subStringInAString("RahulRaulRauulRamul","Ra");
	}
	
	public static void subStringInAString(String string, String subString)
	{
		Pattern pattern = Pattern.compile(subString);
		Matcher matcher=pattern.matcher(string);
		
		int countOfMatches=0;
		while(matcher.find())
		{
			countOfMatches++;
		}
		System.out.println("count of substring "+subString+" in "+string+" is "+countOfMatches);
	}
}
