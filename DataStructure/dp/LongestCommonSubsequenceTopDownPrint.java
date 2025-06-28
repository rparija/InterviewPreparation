package dp;

/*
Printing Longest Common Subsequence
Given two sequences, print the longest subsequence present in both of them.
Example:
LCS for input Sequences “ABCDGH” and “AEDFHR” is “ADH” of length 3.
*/
public class LongestCommonSubsequenceTopDownPrint {
    static int [][] dp;
    public static void main(String[] args) {

        String s1="abcdefg";
        String s2="abgef";
        String longestCommonSubsequence= longestCommonSubsequence(s1,s2,s1.length(),s2.length());
        StringBuilder sb= new StringBuilder(longestCommonSubsequence);
        System.out.println("Longest Common Subsequence: "+sb.reverse());
    }

    public static String longestCommonSubsequence(String s1, String s2, int m, int n)
    {
        dp= new int[m+1][n+1];

        for(int i=0;i<m+1;i++)
        {
            for(int j=0;j<n+1;j++)
            {
                if(m==0 || n==0)
                {
                    dp[i][j]=0;
                }
            }
        }
        for(int i=1;i<m+1;i++)
        {
            for(int j=1;j<n+1;j++)
            {
             if(s1.charAt(i-1)==s2.charAt(j-1))
             {
                 dp[i][j]= dp[i-1][j-1]+1;
             }else
             {
                 dp[i][j]= Math.max(dp[i][j-1],dp[i-1][j]);
             }
            }
        }
        int i=m;
        int j=n;
        String output="";
        while(i!=0 && j!=0)
        {
            if(s1.charAt(i-1)==s2.charAt(j-1))
            {
                output=output.concat(String.valueOf(s1.charAt(i-1)));
                i--;
                j--;
            }else
            {
                if(dp[i-1][j]>dp[i][j-1])
                {
                    i--;
                }else
                {
                    j--;
                }
            }
        }
        return output;

    }
}
