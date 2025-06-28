package dp;

/*Coin change problem maximum number of ways given a value N ,
 if we want to make a change for N cents , and we have infinite supply of each ps s={s1,s2,s3.....sn} valued coins
 how many ways can we make the change ? The order of coins doesn't matter
 expected output: N=4, s={1,2,3} , output: {1,1,1,1},{2,2},{1,1,2},{1,3} so the output would be 4*/
public class CoinChangeDP {

    public static void main(String[] args) {
        int n=5;
        int []s={1,2,5};
        System.out.println("Number of ways to make coin change: " + coinChangeTopDownApproach(s,n));
    }

    /*Basically its an unbounded knapsack problem and using that we would solve it*/
public static int coinChangeTopDownApproach(int[] s, int n) {

    int[][] dp = new int [s.length+1][n+1];
    /*initializing the 1st row and 1st column to 0 in a matrix*/
    for(int i=0;i<s.length+1;i++)
    {
        for(int j=0;j<n+1;j++){
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

    for(int i=1;i<=s.length;i++)
    {
        for(int j=1;j<=n;j++) {
            if (s[i-1]<=j)
            {
                dp[i][j]= dp[i][j-s[i-1]]+ dp[i-1][j];
            }
            else
            {
                dp[i][j]= dp[i-1][j];
            }
            }
    }
    return dp[s.length][n];
}
}