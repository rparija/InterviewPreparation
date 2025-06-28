package leetcode;

public class LeetCode72 {
    public static void main(String[] args) {
        String word1="horse";
        String word2="ros";
        minDistance(word1,word2);
    }
   public static int minDistance(String word1, String word2) {
            int length=findLongestCommonSubsequence(word1,word2,word1.length(),
                    word2.length());
             System.out.println(length);
            // int deletionCount=word1.length()-length;
            // int insertionCount=word2.length()-length;
            return length;
        }
        public static int findLongestCommonSubsequence(String word1, String word2,
                                                       int m, int n)
        {
            int [][] dp= new int[m+1][n+1];
            for(int i=0;i<m+1;i++)
            {
                for(int j=0;j<n+1;j++)
                {
                    if(i==0)
                    {
                        dp[i][j]=j;
                    }
                    if(j==0)
                    {
                        dp[i][j]=i;
                    }

                }

            }

            for(int i=1;i<m+1;i++)
            {
                for(int j=1;j<n+1;j++)
                {
                    if(word1.charAt(i-1)==word2.charAt(j-1))
                    {
                        dp[i][j]=dp[i-1][j-1];
                    }else
                    {
                        dp[i][j]= 1+(Math.min(dp[i-1][j],
                                Math.min(dp[i-1][j-1],dp[i][j-1])));
                    }

                }
            }
            return dp[m][n];
        }
    }

