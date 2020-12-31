package corejava;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.time.Instant;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FileHandlingMultithreading {
 public static void main(String[] args) {
	 
	 ExecutorService es= Executors.newFixedThreadPool(20);
		File file =  new File("C:\\Users\\rparija\\Desktop\\imp docs\\assignment3\\FilesForMultiThreading");
		Instant start = Instant.now();
	 Set<Callable<Set<String>>> callableTask= new HashSet<>();
		for(File fileLocation:file.listFiles())
			
		{
			callableTask.add(new Callable<Set<String>>() {

				@Override
				public Set<String> call() throws Exception {
					System.out.println("entered "+ Thread.currentThread().getName());
			        Set<String> set= new LinkedHashSet<>();

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
				        
				        for(String s1:set)
				        {
				        	System.out.println(s1);
				        }
				        /*for (String a : arrOfStr) 
				            System.out.println(a);*/
					}
					return set;
				}});
		}
		
		try {
			List<Future<Set<String>>> future=es.invokeAll(callableTask);
			for(Future<Set<String>> f:future)
			{
				for(String s: f.get())
				{
					System.out.println(s);
				}
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		es.shutdown();
		Instant end = Instant.now();
		System.out.println("Completed in"+Duration.between(start, end));

}
}
