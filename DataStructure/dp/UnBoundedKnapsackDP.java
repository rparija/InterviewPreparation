package dp;

// Java program for  UnboundedKnapsack Problem using Dynamic Programming
public class UnBoundedKnapsackDP {

    public static void main(String[] args) {
        int[] weights = {1,50};
        int[] values = {1,30};
        int capacity = 100;
        int maxProfit = unboundedKnapsackTopDownApproach(weights, values, capacity,weights.length);
        System.out.println("Maximum Profit: " + maxProfit);
    }

public static int unboundedKnapsackTopDownApproach(int[] weights, int [] values , int capacity, int n) {

        int [][] dp= new int [n+1][capacity+1];
        /*initializing the 1st row and 1st column to 0 in a matrix*/
    for (int i=0;i<n+1;i++)
    {
        for(int j=0;j<capacity+1;j++)
        {
            if(i==0 || j==0)
            {
                dp[i][j]=0;
            }
        }
    }

    /*filling the matrix*/
    for (int i=1;i<n+1;i++) {
        for (int j = 1; j < capacity + 1; j++)
        {
            if(weights[i-1]<=j)
            {
                dp[i][j]= Math.max(values[i-1]+dp[i][j-weights[i-1]],dp[i-1][j]);
            }
            else
            {
                dp[i][j]=dp[i-1][j];
            }
        }

    }
    return dp[n][capacity];
    }

}