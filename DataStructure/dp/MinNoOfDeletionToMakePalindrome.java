package dp;


/*
*Minimum number of deletions to make a string palindrome
Given a string of size ‘n’. The task is to remove or delete minimum number of characters from the string so that the resultant string is palindrome.
Examples :

Input : aebcbda
Output : 2
Remove characters 'e' and 'd'
Resultant string will be 'abcba'
which is a palindromic string

PROBLEM STATEMENT LINK:https://www.geeksforgeeks.org/minimum-number-deletions-make-string-palindrome/
*/
public class MinNoOfDeletionToMakePalindrome {
    static int [][] dp;
    public static void main(String[] args) {

        String s1="agbcba";
        StringBuilder stringBuilder= new StringBuilder(s1);
        String s2=stringBuilder.reverse().toString();
        int lengthOfLongestPalindromeSubsequence= longestCommonSubsequence(s1,s2,s1.length(),s2.length());
        System.out.println("Length of Longest Palindrome Subsequence: "+lengthOfLongestPalindromeSubsequence);
        int minNoOfDeletionToMakePalindrome= s1.length()-lengthOfLongestPalindromeSubsequence;
        System.out.println("MinNoOfDeletionToMakePalindrome: "+minNoOfDeletionToMakePalindrome);
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
