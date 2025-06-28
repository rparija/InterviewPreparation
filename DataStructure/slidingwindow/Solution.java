package slidingwindow;

class Solution {
    public static void main(String[] args) {
        int [] nums={1,2,3,4,5};
        int minSubArrayLen=minSubArrayLen(11,nums);
        System.out.println(minSubArrayLen);
    }
    public static int minSubArrayLen(int target, int[] nums) {
         int i=0;
        int j=0;
        int sum=0;
        int mn=Integer.MAX_VALUE;
        while(j<nums.length){
            sum+=nums[j];
            while(sum>=target){
                sum-=nums[i];
                mn=Math.min(j-i+1,mn);
                i++;
            }
            j++;
        }
        if(mn==Integer.MAX_VALUE){
            return 0;
        }
        return mn;
    }
}