package dp;

/*Given an array arr[] of non-negative integers and a value sum,
the task is to check if there is a subset of the given array whose sum is equal
 to the given sum.
 */
public class KnapsackSubsetSum {
    public static void main(String[] args) {
        int [] arr = {3, 34, 4, 12, 5, 2};
        int sum = 9;
        boolean isSubsetSum=isSubsetSum(arr,sum);
        System.out.println("isSubsetSum: "+isSubsetSum);
    }
    public static boolean isSubsetSum(int [] arr,int sum)
    {
        boolean [][] dp= new boolean[arr.length+1][sum+1];
        /*first initialize the 0th row and columns
        * 0th column with true and 0th row with false*/
       for(int i=0;i<arr.length+1;i++)
       {
           for(int j=0;j<sum+1;j++)
           {
               if(i==0)
               {
                   dp[i][j]=false;
               }
               if(j==0)
               {
                   dp[i][j]=true;
               }
           }
       }

         /*filling the matrix*/
        for(int i=1;i<arr.length+1;i++)
        {
            for(int j=1;j<sum+1;j++)
            {
                if(arr[i-1]<=j)
                {
                    dp[i][j] = dp [i-1] [j-arr[i-1]] || dp[i-1][j];
                    //dp[i-1][j-weights[i-1]],dp[i-1][j])
                }else
                {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
       return dp[arr.length][sum];
    }
}
