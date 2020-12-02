import java.util.Random;
import java.util.UUID;

import java8practice.LoppingInJava8;
import java8practice.Weather;
import pojo.Student;

public class Test {

	static LoppingInJava8 loppingInJava8 = new LoppingInJava8();
	public static void main(String[] args) {

		String mytext = "12/20/2012 16:00:00 Missing_20";
		mytext = mytext.replaceAll("( )+", " ");
	/*	for (int i = 0; i < 10; i++) {
			// System.out.println("Milli:"+System.currentTimeMillis());
			StringBuilder requestId = new StringBuilder("GX56");
			requestId.append(String.valueOf(System.nanoTime()));
			Random randomNumberGenerator = new Random();
			System.out.println("Random:" + requestId.append(randomNumberGenerator.nextInt(1000000000)));
		}

		long timestamp = System.currentTimeMillis();
		String requestDetailId = ("1").concat(":")
				.concat("24000000000000000000000000000000000000000000000000000").concat(":").concat(String.valueOf(timestamp));
		if (requestDetailId.length() >= 50) {
			requestDetailId = requestDetailId.substring(0, 49);
		}
		System.out.println(requestDetailId.length()+","+requestDetailId);
		
		String uuid = UUID.randomUUID().toString();
		System.out.println(uuid);*/

		Double invRiseQty=whileLoopTest();
		 String finalShipmentDCLocation = "edc";// expected value is EDC
		boolean isFinalShipmentDCLocation = false;
		if ("eDC OH Available".toUpperCase().contains((finalShipmentDCLocation).toUpperCase()))
		{
		isFinalShipmentDCLocation = true;
		}
		System.out.println(isFinalShipmentDCLocation);
		
		Weather weather = new Weather(20, "Bang", 10, "");
		Student weather1 = new Student(20, "Bang");

		String locationId="2400";
		String reserLocationId="2400";
		if(!weather.getCityName().equals(weather1.getName()))
		{
			System.out.println("true");
		}
	}

	public static Double whileLoopTest()
	{
		Double invRiseQty=3D;
		  while (invRiseQty > 0)
	        {
	           System.out.println("step A: invRiseQty"+invRiseQty);
	           if (true)
	            {
	                if (true)
	                {
	                    

	                    invRiseQty = loppingInJava8.invRiseValue(invRiseQty);
	     	           System.out.println("step B: invRiseQty"+invRiseQty);

	                }
	            }
	            else
	            {
	                break;

	            }
	        }
          System.out.println("step final: invRiseQty"+invRiseQty);

		  return invRiseQty;
	}	
}
