package zycus;
class MyClass {

    static int solve(int m, int n) {
      
      Integer [] array = new Integer[n+1];
      array[0]=0;
      array[1]=0;
      if(n>=2)
      array[2]=0;
      int sum=0;

      if(n>=3)
      {
      array[3]=1;
      sum=1;
      }
      for(int i=m;i<array.length;i++)
      {
          if(i>3)
          array[i]=sum;
          sum=sum+array[i];
      }
      return sum;
    }

    public static void main(String[] args) {
    	System.out.println(solve(4,8));
	}
}