// Java program to demonstrate 
// listIterator() method 
// for List interface 
import java.util.*; 
  
public class ListIteratorExample { 
    public static void main(String[] argv) throws Exception 
    { 
        try { 
  
            // Creating object of List<Integer> 
        	List <GX56ReservationRequestMatch> reqMatchList= new ArrayList<>();
        	reqMatchList.add(new GX56ReservationRequestMatch("1", "RP1", "12", 1D, "123"));
        	reqMatchList.add(new GX56ReservationRequestMatch("2", "RP2", "12", 1D, "123"));
        	reqMatchList.add(new GX56ReservationRequestMatch("3", "RP3", "12", 1D, "123"));
        	reqMatchList.add(new GX56ReservationRequestMatch("1", "RP1", "12", 1D, "123"));
        	reqMatchList.add(new GX56ReservationRequestMatch("1", "RP1", "12", 1D, "123"));

        	List<Integer> arrlist = new ArrayList<>(); 
  
            HashMap<String,Double> hashIdQuantityMap= new HashMap<>();
            for (GX56ReservationRequestMatch reqMatch : reqMatchList) {
            	if(hashIdQuantityMap.containsKey(reqMatch.getHashId()))
            	hashIdQuantityMap.put(reqMatch.getHashId(), reqMatch.getQuantity()+hashIdQuantityMap.get(reqMatch.getHashId()));
            	else
                	hashIdQuantityMap.put(reqMatch.getHashId(), reqMatch.getQuantity());

			}
            // adding element to arrlist 
            arrlist.add(1); 
            arrlist.add(3); 
            arrlist.add(6); 
            arrlist.add(9); 
  
            // print arrlist 
            System.out.println("ArrayList: "
                               + arrlist); 
  
            // Creating object of ListIterator<String> 
            // using listIterator() method 
            ListIterator<GX56ReservationRequestMatch> 
                iterator = reqMatchList.listIterator(); 
  
            // Printing the iterated value 
            System.out.println("\nUsing ListIterator:\n"); 
            while (iterator.hasNext()) { 
            	GX56ReservationRequestMatch reqMatch= iterator.next();
            	if(hashIdQuantityMap.containsKey(reqMatch.getHashId()))
            	{
            		reqMatch.setQuantity(hashIdQuantityMap.get(reqMatch.getHashId()));
            		hashIdQuantityMap.remove(reqMatch.getHashId());
            		System.out.println("Value is : "
                            + reqMatch); 
     
            	}
            	else
            	{
            		iterator.remove();
            	}
               
            } 
            System.out.println("reqMatchList"); 

        } 
  
        catch (NullPointerException e) { 
            System.out.println("Exception thrown : " + e); 
        } 
    } 
}