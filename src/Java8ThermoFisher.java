import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Java8ThermoFisher {

	
	public static void main(String[] args) {
		List<Integer> values= new ArrayList<>();
		values.add(10);
		values.add(20);
		values.add(30);
		values.add(40);
		values.add(50);
		/*sum of squares of a odd number*/
		
		values.stream()
				.filter(i->i%2!=0)
				.map(i-> i*2)
				.reduce(Integer::sum);
		
		System.out.println(
				values.stream()
				.filter(i-> i%2==0)
				.mapToInt(i->i*2)
				.sum());
		values.stream()
				.filter(e->e%2!=0)
				.map(e->e*e)
				.reduce(Integer::sum);
		Map<String,Object> extended= new HashMap<>();
		extended.put("GCRetry", "0");
        String retryCount = (String) extended.get("GCRetry");
        if(retryCount!=null && !retryCount.isEmpty()) 
        {
        Integer retry=Integer.parseInt(retryCount);
        }
        System.out.println(retryCount);

	}
	public boolean  isOdd(int i)
	{
		return i%2!=0;
	}
	
	public int  doubleIt(int i)
	{
		return i*i;
	}
}
