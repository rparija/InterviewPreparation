// Java program to implement
// the above approach
class GFG{

	static int gcd(int first, int second)
    {
        if(second==0)
        {
            return first;
        }
        return gcd(second,first%second);
    }
    static long answer(int[] arr){
       // Write your code here
      int maxGCD=0;
      for(int i=0;i<arr.length-1;i++)
      {
          int val= gcd(arr[i],arr[i+1]);
          if(val>maxGCD)
          {
              maxGCD=val;
          }
      }
      return maxGCD;
    }

// Driver Code
public static void main(String[] args)
{
int arr[] = {2,3,4,6,8};
int K = 2;
int N = arr.length;
System.out.println(answer(arr));
}
}

// This code is contributed by Chitranayal
