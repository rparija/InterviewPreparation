package corejava;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.time.Instant;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringExercise {
	

	public static void main(String[] args) throws InterruptedException, ExecutionException {

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

		File file =  new File("C:\\Users\\rparija\\Desktop\\imp docs\\assignment3\\FilesForMultiThreading");
		Executor executor = Executors.newFixedThreadPool(20);
		readFileWithoutMultiThreading(file);
		Instant start = Instant.now();
		CompletableFuture<Set<String>> future = CompletableFuture.supplyAsync(() -> {
	        Set<String> set= new LinkedHashSet<>();

			for(File fileLocation:file.listFiles())
			{
				System.out.println("entered "+ Thread.currentThread().getName());

				if(fileLocation.exists())
				{
					String str = "geekss@for@geekss"; 
			        String[] arrOfStr = str.split("@"); 
			        String s="";
			        try {
						FileReader fr= new FileReader(fileLocation);
						BufferedReader reader = new BufferedReader(fr);
						String line=reader.readLine();
						while(line!=null)
						{
							String [] word= line.split(" ");
							for(String s2:word)
							{
								set.add(s2);
							}
							
							line=reader.readLine();
						}
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			        
			      /*  for(String s1:set)
			        {
			        	System.out.println(s1);
			        }*/
			        /*for (String a : arrOfStr) 
			            System.out.println(a);*/
				}
			}
			  return set;
		},executor);
		if(future!=null)
		{
		//String completableFutureResult=future.get();
		
        	System.out.println("completed");
        
		}
		Instant end = Instant.now();
		System.out.println("Completed in"+Duration.between(start, end));
		/*if(file.exists())
		{
			String str = "geekss@for@geekss"; 
	        String[] arrOfStr = str.split("@"); 
	        String s="";
	        try {
				FileReader fr= new FileReader(file);
				BufferedReader reader = new BufferedReader(fr);
				String line=reader.readLine();
				while(line!=null)
				{
					String [] word= line.split(" ");
					for(String s2:word)
					{
						set.add(s2);
					}
					
					line=reader.readLine();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        
	        for(String s1:set)
	        {
	        	System.out.println(s1);
	        }
	  
	        for (String a : arrOfStr) 
	            System.out.println(a);
		}*/
		
        
        
	}
	
	public static void readFileWithoutMultiThreading(File file)
	{

		Instant start = Instant.now();

        Set<String> set= new LinkedHashSet<>();

		for(File fileLocation:file.listFiles())
		{
			System.out.println("entered "+ Thread.currentThread().getName());

			if(fileLocation.exists())
			{
				String str = "geekss@for@geekss"; 
		        String[] arrOfStr = str.split("@"); 
		        String s="";
		        try {
					FileReader fr= new FileReader(fileLocation);
					BufferedReader reader = new BufferedReader(fr);
					String line=reader.readLine();
					while(line!=null)
					{
						String [] word= line.split(" ");
						for(String s2:word)
						{
							set.add(s2);
						}
						
						line=reader.readLine();
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		        
		        /*for(String s1:set)
		        {
		        	System.out.println(s1);
		        }*/
		        /*for (String a : arrOfStr) 
		            System.out.println(a);*/
			}
		}
		Instant end = Instant.now();
		System.out.println("WithoutMultithreading Completed in"+Duration.between(start, end));
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
