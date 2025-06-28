package dp;

/*
Matrix Chain Multiplication using Recursion
 Given a sequence of matrices, find the most efficient way to multiply these matrices together. The problem is not actually to  perform the multiplications, but merely to decide in which order to perform the multiplications.
Input: arr[] = [2, 1, 3, 4]
Output: 20
Input: arr[] = [1, 2, 3, 4, 3]
Output: 30
Input: arr[] = [3, 4]
Output: 0
PROBLEM STATEMENT LINK:https://www.geeksforgeeks.org/matrix-chain-multiplication-dp-8/
* */
public class MatrixChainMultiplicationMemoization {

    static int [][] dp;
    public static void main(String[] args) {
    int [] arr= {1,2,3,4,3};
    int n=arr.length;
    int i=1;// since we have a i-1 condition so if we keep i=0 then we will get an array out of bound exception
    dp= new int[n][n];
    initializeMatrix(dp,n);
    int minimumCost=matrixChainMultiplication(arr,1, n-1);
    System.out.println("Minimum cost of matrix chain multiplication: "+minimumCost);
    }

    private static void initializeMatrix(int[][] dp,int n) {

        for (int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                dp[i][j]=-1;
            }
        }
    }

    private static int matrixChainMultiplication(int[] arr, int i, int j) {

        //Base case
        if(i>=j)
        {
            return 0;
        }
        if(dp[i][j]!=-1)
        {
            return dp[i][j];
        }
        int minimumCost=Integer.MAX_VALUE;
        for(int k=i;k<=j-1;k++)
        {
            int tempResult= matrixChainMultiplication(arr,i,k)
                    + matrixChainMultiplication(arr,k+1,j)
                    + (arr[i-1]* arr[k]* arr[j]);
            minimumCost=Math.min(tempResult,minimumCost);
            dp[i][j]=minimumCost;
        }
        return minimumCost;
    }
}
