package dp;

public class LongestCommonSubsequenceMemoization {
    static int [][] dp;
    public static void main(String[] args) {

        String s1="abcdefg";
        String s2="abgef";
        dp=initializeMatrix(dp,s1.length(),s2.length());
        int lengthOfLongestCommonSubsequence= longestCommonSubsequence(s1,s2,s1.length(),s2.length());
        System.out.println("Length of Longest Common Subsequence: "+lengthOfLongestCommonSubsequence);
    }

    private static int[][] initializeMatrix(int[][] dp,int m,int n) {
        dp= new int[m+1][n+1];
        for(int i=0;i<=m;i++)
        {
            for(int j=0;j<=n;j++)
            {
                dp[i][j]=-1;
            }
        }
        return dp;
    }

    public static int longestCommonSubsequence(String s1,String s2, int m,int n)
    {
        if(m==0 || n==0)
        {
            return 0;
        }
        if(dp[m][n]!=-1)
        {
            return dp[m][n];
        }
        if(s1.charAt(m-1)==s2.charAt(n-1))
        {
            return dp[m][n]=longestCommonSubsequence(s1,s2,m-1,n-1)+1;
        }else
        {
            return dp[m][n]=Math.max(longestCommonSubsequence(s1,s2,m,n-1),
                    longestCommonSubsequence(s1,s2,m-1,n));
        }
    }
}
