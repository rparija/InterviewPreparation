package dp;

/*
Palindrome Partitioning using Recursion
Given a string, a partitioning of the string is a palindrome partitioning if every substring of the partition is a palindrome.
Example:
  “aba|b|bbabb|a|b|aba” is a palindrome partitioning of “ababbbabbababa”.

PROBLEM STATEMENT LINK:https://www.geeksforgeeks.org/palindr...
* */
public class PalindromePartitioningMCMRecursive {

    public static void main(String[] args) {
    String s="nitin";
    char [] arr= s.toCharArray();
    int n=arr.length;
    int i=0;// since its not a matrix multiplication so we can consider 0th index
    int minimumCost=palindromePartitioning(arr,0, n-1);
        System.out.println(minimumCost == 0 ? "It's a Palindrome" : "Not a Palindrome");

    }

    private static int palindromePartitioning(char[] arr, int i, int j) {

        //Base case
        if(isPalindrome(arr,i,j) || i>=j)
        {
            return 0;
        }
        int minimumCost=Integer.MAX_VALUE;
        for(int k=i;k<=j-1;k++)
        {
            int tempResult= palindromePartitioning(arr,i,k)
                    + palindromePartitioning(arr,k+1,j)
                    + 1;
            minimumCost=Math.min(tempResult,minimumCost);
        }
        return minimumCost;
    }

    private static boolean isPalindrome(char[] arr, int i, int j) {

        while(i<j)
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
