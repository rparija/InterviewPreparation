package slidingwindow;

import java.util.HashSet;

/*https://leetcode.com/problems/maximum-sum-of-distinct-subarrays-with-length-k/description/
You are given an integer array nums and an integer k. Find the maximum subarray sum of all the subarrays of nums that meet the
following conditions:

The length of the subarray is k, and
All the elements of the subarray are distinct.
Return the maximum subarray sum of all the subarrays that meet the conditions. If no subarray meets the conditions, return 0.

A subarray is a contiguous non-empty sequence of elements within an array.



Example 1:

Input: nums = [1,5,4,2,9,9,9], k = 3
Output: 15*/
public class SlidingWindowSumOfDistinctSubarrayWithLengthK {

    public static void main(String[] args) {
        int[] nums={9,9,9,1,2,3};
        int k=3;
        long maxSubArraySum=maxSubArraySum(nums,k);
        System.out.println("maxSubArraySum:"+maxSubArraySum);
    }

    private static long maxSubArraySum(int[] nums, int k) {
        long sum=0;
        int i=0;
        long maxSum=0;
        int j=0;
        HashSet<Integer> set= new HashSet<>();
        while(j<nums.length)
        {
           if(set.contains(nums[j]))
           {
               sum=sum-nums[i];
               set.remove(nums[i]);
               i++;
               continue;
           }
           set.add(nums[j]);
           sum=sum+nums[j];
           if(j-i+1==k)
           {
               maxSum=Long.max(sum,maxSum);
               sum = sum - nums[i];
               set.remove(nums[i]);
               i++;
           }
           j++;
        }
        return maxSum;
    }
}
