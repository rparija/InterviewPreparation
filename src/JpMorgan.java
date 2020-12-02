import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class JpMorgan {
  /**
   * Iterate through each line of input.
   */
  public static void main(String[] args) throws IOException {
    InputStreamReader reader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
    BufferedReader in = new BufferedReader(reader);
    String line;
    
    Integer a=Integer.parseInt(in.readLine());
    Integer b=Integer.parseInt(in.readLine());
   // while ((line = in.readLine()) != null) {
    //  a=Integer.parseInt(line);
    //}
    System.out.println(a);
    System.out.println(b);
    findCombination(a,b);
  }
  
  public static void findCombination(int a, int b)
  {
    boolean isFound=false;
    for(int c=a;c<=b;c++)
    {
      final Set<Integer> set = new HashSet<Integer>();
      final Map<Integer,Integer> map = new HashMap<Integer,Integer>();
      
      final String number= String.valueOf(c);
      if(number.contains("0"))
      {
        continue;
      }
      
      for(int i=0;i<number.length();i++)
      {
        final int digit=number.charAt(i);
        set.add(digit);
        map.put(digit,i);
      }
      if(number.toCharArray().length!=set.size())
      {
        continue;
      }
      final int length= number.length();
      int j=0;
      int k=1;
      
      while(k<=length)
      {
        set.remove((int)number.charAt(j));
        j=(number.charAt(j)+map.get((int) number.charAt(j)))%length;
           k++;
      }
           if(j==0&& set.size()==0)
           {
             System.out.println(number);
             isFound=true;
           }
    }
           if(!isFound)
           {
             System.out.println(-1);
           }
  }
}