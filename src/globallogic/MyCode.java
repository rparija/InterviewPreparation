package globallogic;
// package whatever; // don't place package name!

import java.util.*;
import java.util.Map.Entry;

class MyCode {
	public static void main (String[] args) {
			String test = "hi how are you ?";
      
      Map<Character,Integer> map= new LinkedHashMap<Character,Integer>();
      int count=0;
      for(char c:test.toCharArray())
      {
        count=0;
        if(map.containsKey(c))
        {
          count=map.get(c);
        }
        map.put(c,++count);
      }
      for(Entry<Character,Integer> e: map.entrySet())
      {
        if(e.getValue()>1)
        {
        System.out.println(e.getKey()+" having count :"+e.getValue());
        break;
        }
      }
      // i think this will work, 
      //as linkedhashmap will take care of the insertion order
      map.entrySet().stream().forEach(e->System.out.println( e.getKey()+" having count :"+e.getValue()));
                            
      //can you repeat the question once again.....
     // first repeated character 
      //for example in above case its 'h' got you
      //map will not preserve the iserrtion order right okay i didnt saw you have converted it into linked hashmap 
      
	}
}
