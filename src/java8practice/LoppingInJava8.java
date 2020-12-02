package java8practice;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class LoppingInJava8 {

	public static void main(String[] args) {

	
		List<Weather> weatherList=Arrays.asList(new Weather(23, "Bhilai", 46, "Partially Cloudy"),
		new Weather(28, "Raipur", 47, "Partially Cloudy"),
		new Weather(22, "Bangalore", 48, " Cloudy"),
		new Weather(30, "Managlore", 49, " Sunny"),
		new Weather(30, "Managlore", 49, " Sunny")
		);
		Set<String> set = new HashSet<>(weatherList.size());
		weatherList.stream().filter(p -> set.add(p.getCityName())).collect(Collectors.toList());
		set.stream().forEach(list->{System.out.println(list);});
		weatherList.stream().filter(list -> 47<list.getHumidity()).forEach(list->{System.out.println(list.getCityName());});
		
	}
	
	public Double invRiseValue(Double invRiseQty)
	{
		for (int i = 0; i < 3; i++) {
			invRiseQty=invRiseQty-1;
		}
		return invRiseQty;
	}

}
