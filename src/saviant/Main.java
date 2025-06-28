package saviant;// Online Java Compiler
// Use this editor to write, compile and run your Java code online
//LRU cache
import java.util.*;
class Main {
   static Map<String,String> map = new LinkedHashMap<String,String>();
    public static void main(String[] args) {
        System.out.println("Try programiz.pro");
        put("location1","bangalore");
        put("location2","bengal");
        put("location3","bombay");
        put("location4","pune");
        put("location5","hyderabad");
        System.out.println(map);
        System.out.println("fetched location4 "+get("location1"));
                System.out.println(map);
        put("location6","chennai");
        System.out.println(map);
    }
    
    public static void put(String key,String value)
    {
        //System.out.println("map size: "+map.size());
        if(map.size()==5)
        {
            String eligibleKeyForRemoval="";
            Optional<String> optionalKey=map.keySet().stream().findFirst();
            eligibleKeyForRemoval=optionalKey.get();
            /*System.out.println("eligibleKeyForRemoval"+eligibleKeyForRemoval);*/
            remove(eligibleKeyForRemoval);
        }
        map.put(key,value);
    }
    
    public static void remove(String key)
    {
        System.out.println("key:"+key);
        map.remove(key);
    }
    public static String get(String key)
    {
        String value= map.get(key);
        remove(key);
        put(key,value);
        return value;
    }
}