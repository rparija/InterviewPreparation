package dp;

/*
Palindrome Partitioning using Recursion
Given a string, a partitioning of the string is a palindrome partitioning if every substring of the partition is a palindrome.
Example:
  “aba|b|bbabb|a|b|aba” is a palindrome partitioning of “ababbbabbababa”.

PROBLEM STATEMENT LINK:https://www.geeksforgeeks.org/palindr...
* */
public class PalindromePartitioningMCMMemoization {

    static int [][] dp;
    public static void main(String[] args) {
        String s="aab";
        char[] arr= s.toCharArray();
        int n=s.length();
        int i=0;
        initializeMatrix(arr,n);
        int minPalindromePartition= minPalindromePartition(arr,i,n-1);
        System.out.println(minPalindromePartition!=0?"Its not a Palindrome":"Its a Palindrome");
    }

    private static void initializeMatrix(char[] arr, int n) {
        dp= new int[n][n];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                dp[i][j]=-1;
            }

        }
    }

    private static int minPalindromePartition(char[] arr, int i, int j) {
        if(isPalindrome(arr,i,j) || i>j)
        {
            return 0;
        }
        if(dp[i][j]!=-1)
        {
            return dp[i][j];
        }
        int min=Integer.MAX_VALUE;

        for(int k=i;k<=j-1;k++)
        {
            int tempValue= 1+ minPalindromePartition(arr,i,k) +
                    minPalindromePartition(arr, k+1,j);
            min=Math.min(tempValue,min);
        }
        dp[i][j]=min;
        return min;
    }

    public static boolean isPalindrome(char[] arr, int i, int j)
    {
        while(i<=j)
        {
            if(arr[i]!=arr[j])
            {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }


}
