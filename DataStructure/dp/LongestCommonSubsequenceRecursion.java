package dp;

public class LongestCommonSubsequenceRecursion {
    public static void main(String[] args) {

        String s1="abcdefg";
        String s2="abgef";
        int lengthOfLongestCommonSubsequence= longestCommonSubsequence(s1,s2,s1.length(),s2.length());
        System.out.println("Length of Longest Common Subsequence: "+lengthOfLongestCommonSubsequence);
    }

    public static int longestCommonSubsequence(String s1,String s2, int m,int n)
    {
        if(m==0 || n==0)
        {
            return 0;
        }
        if(s1.charAt(m-1)==s2.charAt(n-1))
        {
            return longestCommonSubsequence(s1,s2,m-1,n-1)+1;
        }else
        {
            return Math.max(longestCommonSubsequence(s1,s2,m,n-1),
                    longestCommonSubsequence(s1,s2,m-1,n));
        }
    }
}
