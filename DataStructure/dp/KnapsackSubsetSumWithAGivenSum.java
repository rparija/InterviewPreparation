package dp;

/*Given an array arr[] of non-negative integers and a value sum,
the task is to check if there is a subset of the given array whose sum is equal
 to the given sum. get the count of such subsets
 */
public class KnapsackSubsetSumWithAGivenSum {
    public static void main(String[] args) {
        int [] arr = {2,3,5,8,10};
        int sum=10;
        int countSubsetSum=countSubsetSum(arr,sum);
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
