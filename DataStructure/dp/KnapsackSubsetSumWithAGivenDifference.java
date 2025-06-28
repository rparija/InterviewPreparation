package dp;

import java.util.Arrays;

/*Given an array arr[] of non-negative integers and a diff,
the task is to check number of that array can be divided so that each the difference
between the two subsets is equal to diff.
 */
public class KnapsackSubsetSumWithAGivenDifference {
    public static void main(String[] args) {
        int [] arr = {1,1,2,3};
        int diff=1;
        int sum= Arrays.stream(arr).sum();
        /*s1-s2=diff
        * s1+s2=sum (sum of array)
        * when we add the above two equations
        * s1=(diff+sum)/2*/
        int s1=(diff+sum)/2;
        int countSubsetSum=countSubsetSum(arr,s1);
        System.out.println("countSubsetSum: "+countSubsetSum);
    }


    public static int countSubsetSum(int [] arr,int sum) {

        int [][] dp= new int[arr.length+1][sum+1];
        /*first initialize the 0th row and columns
         * 0th column with 1 and 0th row with 0*/
        for(int i=0;i<arr.length+1;i++)
        {
            for(int j=0;j<sum+1;j++)
            {
                if(i==0)
                {
                    dp[i][j]=0;
                }
                if(j==0)
                {
                    dp[i][j]=1;
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
                    dp[i][j]=dp[i-1][j-arr[i-1]] + dp[i-1][j];
                }
                else
                {
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        return dp[arr.length][sum];
    }

}
