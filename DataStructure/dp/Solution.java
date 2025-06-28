package dp;
/*leetcode 322*/
class Solution {

    public static void main(String[] args) {
        int [] coins={1,2,5};
        int coin=coinChange(coins,11);
        System.out.println(coin);
    }
    public static int coinChange(int[] coins, int amount) {
        int [][] dp= new int [coins.length+1][amount+1];

        //initialize the matrix
        for(int i=0;i<coins.length+1;i++)
        {
            for(int j=0;j<amount+1;j++)
            {   
                if(j==0)
                {
                    dp[i][j]=0;
                }
                if(i==0)
                {
                    dp[i][j]=Integer.MAX_VALUE-1;
                }
            }
        }

        int i=1;
        //populate the i=1 row in the matrix
            for(int j=0;j<amount+1;j++)
            {   
                if(j%coins[0]==0)
                {
                    dp[i][j]=j/coins[0];
                }
                else
                {
                    dp[i][j]=Integer.MAX_VALUE-1;
                }
            }

        //fill in the matrix
            for(i=1;i<coins.length+1;i++)
        {
            for(int j=1;j<amount+1;j++)
            {   
                if(coins[i-1]<=j)
                {
                    dp[i][j]=(dp[i][j-coins[i-1]]+dp[i-1][j]);
                }
                else
                {
                    dp[i][j]=dp[i-1][j];
                }
            }
        }

    return dp[coins.length][amount];
    }
}