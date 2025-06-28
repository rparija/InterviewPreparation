package dp;

/*
* Given two strings s and t, return true if s is a subsequence of t, or false otherwise.

A subsequence of a string is a new string that is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (i.e., "ace" is a subsequence of "abcde" while "aec" is not).

Example 1:
Input: s = "abc", t = "ahbgdc"
Output: true

Example 2:
Input: s = "axc", t = "ahbgdc"
Output: false
* */
public class SubsequencePatternMatching {
    static int [][] dp;
    public static void main(String[] args) {

        String s1="axc";
        String s2="ahbgdc";
        int lengthOfLongestCommonSubsequence= longestCommonSubsequence(s1,s2,s1.length(),s2.length());
        System.out.println("Length of Longest Common Subsequence: "+lengthOfLongestCommonSubsequence);
        System.out.println( "s1 is a subsequence of s2 "+(lengthOfLongestCommonSubsequence==s1.length()));
    }

    public static int longestCommonSubsequence(String s1,String s2, int m,int n)
    {

        dp= new int[m+1][n+1];
        for(int i=0;i<=m;i++)
        {
            for(int j=0;j<=n;j++)
            {
                if(i==0 || j==0)
                    dp[i][j]=0;
            }
        }
        for(int i=1;i<m+1;i++) {
            for (int j = 1; j < n+1; j++) {
                if (s1.charAt(i-1) == s2.charAt(j-1)) {
                     dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                     dp[i][j] = Math.max(dp[i-1][j],
                            dp[i][j-1]);
                }
            }
        }

        return dp[m][n];
    }
}
