package dp;

import java.util.Arrays;

/*Given an array arr[] of non-negative integers and a value sum,
the task is to check if there is a subset of the given array whose sum is equal
 to the given sum.
 */
public class KnapsackSubsetSumDifference {
    public static void main(String[] args) {
        int [] arr = {1,5,11,5};
        int sum = Arrays.stream(arr).sum();
        int findSubsetSumDifference=findSubsetSumDifference(arr,sum);
        System.out.println("findSubsetSumDifference: "+findSubsetSumDifference);
    }
    public static int findSubsetSumDifference(int [] arr, int sum)
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
                }else
                {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
/* the logic here is we need to iterate through the last row of the matrix
* and if the value is true then we need to calculate the minimum difference
* sum of the array is sum, now assuming 2 subsets of array s1 and s1
* s1+s2= sum or s2= sum-s1(this is one subset and the other subset is s1)
* so we can say the value to be (sum-s1)-s1 will be the difference so sum-2s1
* that's the logic here*/
        int minDiff=Integer.MAX_VALUE;
        for (int i=0;i<(sum/2)+1;i++)
        {
            if(dp[arr.length][i])
            {
                minDiff=Math.min(minDiff,Math.abs(sum-2*i));
            }
        }

       return minDiff;
    }
}
