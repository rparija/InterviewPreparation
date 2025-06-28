package dp;

/*
* Longest Repeating Subsequence
Given a string, print the longest repeating subsequence such that the two subsequence don’t have same string character at same position, i.e., any i’th character in the two subsequences shouldn’t have the same index in the original string.
Example:
Input: str = "aab"
Output: "a"
The two subsequence are 'a'(first) and 'a'
(second). Note that 'b' cannot be considered
as part of subsequence as it would be at same
index in both.

PROBLEM STATEMENT LINK:https://www.geeksforgeeks.org/longest-repeated-subsequence/
*/
public class LongestRepeatingSubsequence {
    static int [][] dp;
    public static void main(String[] args) {

        String s1="AABEBCDD";
        String s2=s1;
        int lengthOfLongestRepeatingSubsequence= longestRepeatingSubsequence(s1,s2,s1.length(),s2.length());
        System.out.println("Length of Longest Common Subsequence: "+lengthOfLongestRepeatingSubsequence);
    }

    public static int longestRepeatingSubsequence(String s1,String s2, int m,int n)
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
                if (s1.charAt(i-1) == s2.charAt(j-1) && i!=j) {
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
