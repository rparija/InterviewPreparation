package leetcode;

import java.util.Arrays;

public class LeetCode300 {
    public static void main(String[] args) {
        int [] nums = {10,9,2,5,3,7,101,18};
        System.out.println(lengthOfLIS(nums));
    }
    public static int lengthOfLIS(int[] nums) {
        int m=nums.length;
        int [] dp = new int[m];
        Arrays.fill(dp,-1);
        int result=findLongestIncreasingSubsequence(nums,m-1,dp);
        return result;
    }

    private static int findLongestIncreasingSubsequence(int[] nums, int m, int[] dp) {
        if(m==0)
        {
            return 0;
        }
        if(dp[m]==-1)
        {
            if(nums[m]>nums[m-1])
            {
                dp[m] =findLongestIncreasingSubsequence(nums,m-1,dp)+1;
                return dp[m];
            }else
            {
                dp[m]=findLongestIncreasingSubsequence(nums,
                        m-1,dp);
                return dp[m];
            }
        }
        else
        {
            return dp[m];
        }
    }
}
