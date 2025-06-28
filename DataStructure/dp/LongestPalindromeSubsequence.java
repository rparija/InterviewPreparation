package dp;


/*
* Longest Palindromic Subsequence
Given a sequence, find the length of the longest palindromic subsequence in it.
Example :
Input:"bbbab"
Output:4

PROBLEM STATEMENT LINK:https://www.geeksforgeeks.org/longest-palindromic-subsequence-dp-12/
*/
public class LongestPalindromeSubsequence {
    static int [][] dp;
    public static void main(String[] args) {

        String s1="agbcba";
        StringBuilder stringBuilder= new StringBuilder(s1);
        String s2=stringBuilder.reverse().toString();
        int lengthOfLongestPalindromeSubsequence= longestPalindromeSubsequence(s1,s2,s1.length(),s2.length());
        System.out.println("Length of Longest Palindrome Subsequence: "+lengthOfLongestPalindromeSubsequence);
    }

    public static int longestPalindromeSubsequence(String s1,String s2, int m,int n)
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
