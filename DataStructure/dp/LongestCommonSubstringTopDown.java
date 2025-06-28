package dp;

/*Longest Common Substring(Dynamic Programming)
Given two strings ‘X’ and ‘Y’, find the length of the longest common substring.
Examples:

Input : X = “GeeksforGeeks”, y = “GeeksQuiz”
Output : 5
The longest common substring is “Geeks” and is of length 5.*/
public class LongestCommonSubstringTopDown {
    static int [][] dp;
    public static void main(String[] args) {

        String s1="abcdefg";
        String s2="abgef";
        int lengthOfLongestCommonSubstring= longestCommonSubstring(s1,s2,s1.length(),s2.length());
        System.out.println("Length of Longest Common Substring: "+lengthOfLongestCommonSubstring);
    }

    public static int longestCommonSubstring(String s1,String s2, int m,int n)
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
        int maxLength=0;
        for(int i=1;i<m+1;i++) {
            for (int j = 1; j < n+1; j++) {
                if (s1.charAt(i-1) == s2.charAt(j-1)) {
                     dp[i][j] = dp[i-1][j-1] + 1;
                     maxLength=Math.max(dp[i][j],maxLength);
                } else {
                     dp[i][j] = 0;
                }
            }
        }

        return maxLength;
    }
}
