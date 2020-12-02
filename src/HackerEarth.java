import java.math.*; 
class HackerEarth {
       /* int val  = 10;
        public static void main(String[] args) {
            HackerEarth obj = new HackerEarth();
            System.out.println(obj.val);
        }*/
	 
	 
	 public static void main(String[] args) {
		System.out.println(FindBigNum(10));
		 
	}
	 static long FindBigNum(long n) {
		 
		 StringBuilder s= new StringBuilder("");
	        for(int i=1; i<=n; i++)
	        {
	     s=s.append(Integer.toBinaryString(i));
	    // concattedBinaryNumber=concattedBinaryNumber.concat(binary(i));
	        }
	        // Write your code here
	        String concattedBinaryNumber="";
	        for(int i=1; i<=n; i++)
	        {
	     concattedBinaryNumber=concattedBinaryNumber.concat(Integer.toBinaryString(i));
	    // concattedBinaryNumber=concattedBinaryNumber.concat(binary(i));
	        }
	       // System.out.println(concattedBinaryNumber);
	        //System.out.println(Long.parseLong(concattedBinaryNumber,2));
	        //new BigInteger(concattedBinaryNumber,2).longValue();
	       // Long l= Long.parseLong(concattedBinaryNumber,2);
	      /* long l= getMod(concattedBinaryNumber,(int)n,1000000007);
	        //return new BigInteger(concattedBinaryNumber,2).longValue();
		return l;*/
		
		// Long l= Long.parseLong(s.toString());
		 BigInteger b= new BigInteger(s.toString());
		 BigDecimal d= new BigDecimal(b);
		 System.out.println(d);
	     long num=binaryToDecimal(b.longValue()%1000000007);
	       
	       return num;
	       
	    }
	 static long  binaryToDecimal(long n)
	    {
	        long rem=1,decimal=0,j=1;
	        while(n!=0)
	        {
	        //System.out.println(n);
	            rem=n%10;
	            decimal=decimal+rem*j;
	            j=j*2;
	            n=n/10;
	        }
	        return decimal;
	    }

	    static long getMod(String s, int n, int k)
	    {
	        int pwrTwo[]= new int[n];
	        pwrTwo[0]= 1%k;

	        for(int i=1;i<n;i++)
	        {
	            pwrTwo[i]=pwrTwo[i-1]*(2%k);
	            pwrTwo[i]%=k;
	        }

	        long res=0;
	        int i=0;
	        int j=n-1;

	        while(i<n)
	        {
	            if(s.charAt(j) =='1')
	            {
	                res+=(pwrTwo[i]);
	                res%=k;
	            }
	            i++;
	            j--;
	        }
	        System.out.println(res);
	        return res;
	    }
    }