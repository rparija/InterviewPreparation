package onetrust;

import java.math.BigInteger;

/*COunt of distinct graphs that can be formed with N vertices*/
public class GraphExponentialPower {

	 static final long mod=(long) 1e9+7;
	 static long powerLL(long x, long n)  
	    { 
	        long result = 1; 
	        while (n > 0)  
	        { 
	            if (n % 2 == 1)  
	            { 
	                result = result * x % mod; 
	            } 
	            n = n / 2; 
	            x = x * x % mod; 
	        } 
	        return result; 
	    } 
	 // Returns modulo exponentiation for 
	    // two numbers  represented as strings.   
	    // It is used by powerStrings()  
	    static long powerStrings(String sa, String sb)  
	    { 
	        // We convert strings to number  
	        long a = 0, b = 0; 
	  
	        // calculating a % MOD  
	        for (int i = 0; i < sa.length(); i++)  
	        { 
	            a = (a * 10 + (sa.charAt(i) - '0')) %  
	                                               mod; 
	        } 
	  
	        // calculating b % (MOD - 1)  
	        for (int i = 0; i < sb.length(); i++)  
	        { 
	            b = (b * 10 + (sb.charAt(i) - '0')) % 
	                                        (mod - 1); 
	        } 
	  
	        // Now a and b are long long int. We  
	        // calculate a^b using modulo exponentiation  
	        return powerLL(a, b); 
	    } 
	public static void main(String[] args) {
		int n=10;
		Long nl= Long.parseLong("97319");
        Long vertice=nl*(nl-1)/2;
		System.out.println(powerStrings("2",vertice.toString()));
		
		
		int vertices=n*(n-1)/2;
		int res=1;
		System.out.println(vertices);
		for(int i=0;i<vertices;i++)
		{
			res=res*2;
		}
		System.out.println(res%1000000007);
		double result=Math.pow(2, vertices);
		System.out.println(result%1000000007);
	}
}
