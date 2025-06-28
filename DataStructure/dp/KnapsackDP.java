package dp;

// Java program for 0/1 Knapsack Problem using Dynamic Programming
public class KnapsackDP {

    // Function to solve the 0/1 Knapsack Problem
    public static int knapsack(int[] weights, int[] values, int capacity) {
        int n = weights.length;
        int[][] dp = new int[n + 1][capacity + 1];

        // Build the DP table
        for (int i = 1; i <= n; i++) {
            for (int w = 1; w <= capacity; w++) {
                if (weights[i - 1] <= w) {
                    dp[i][w] = Math.max(values[i - 1] + dp[i - 1][w - weights[i - 1]], dp[i - 1][w]);
                } else {
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }

        return dp[n][capacity];
    }

    public static int knapsackRecursion(int [] weights, int [] values, int capacity,
                                        int n)
    {
        if(weights.length==0 || values.length ==0 || capacity==0 || n==0)
        {
            return 0;
        }
        if(weights[n-1]<=capacity)
        {
            return Math.max(values[n-1]+knapsackRecursion(weights,values,capacity-weights[n-1],n-1),
                    knapsackRecursion(weights,values,capacity,n-1));
        }else {
            return knapsackRecursion(weights,values,capacity,n-1);
        }

    }
    public static void main(String[] args) {
        int[] weights = {1, 2, 3};
        int[] values = {10, 20, 40};
        int capacity = 5;

        int maxProfit = knapsack(weights, values, capacity);
        System.out.println("Maximum Profit: " + maxProfit);
        maxProfit = knapsackRecursion(weights, values, capacity,weights.length);
        System.out.println("Maximum Profit: " + maxProfit);
        maxProfit = knapsackTopDownApproach(weights, values, capacity,weights.length);
        System.out.println("Maximum Profit: " + maxProfit);
    }

public static int knapsackTopDownApproach(int[] weights, int [] values , int capacity, int n)
{
    int [] [] dp = new int [n+1] [capacity+1];

    /*initializing the 1st row and 1st column to 0 in a matrix*/
    for(int i=0;i<n+1;i++)
    {
        for (int j=0;j<capacity+1;j++)
        {
            if(i==0||j==0)
            {
                dp[i][j]=0;
            }
        }
    }
    /*filling the matrix*/
    for(int i=1;i<n+1;i++)
    {
        for (int j=1;j<capacity+1;j++)
        {
            if(weights[i-1]<=j)
            {
                dp[i][j]=Math.max(values[i-1]+dp[i-1][j-weights[i-1]],dp[i-1][j]);
            }else
            {
                dp[i][j]=dp[i-1][j];
            }
        }
    }

    return dp[n][capacity];
}
}