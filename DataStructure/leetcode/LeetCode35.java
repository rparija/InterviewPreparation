package leetcode;

public class LeetCode35 {
    public static void main(String[] args) {
        int [] nums={3,5,7,9,10};
        int target=8;
        System.out.println(searchInsert(nums,target));
        System.out.println(searchInsertOpt(nums,target));
        StringBuilder sb= new StringBuilder();
        int reverseInt=Integer.parseInt(sb.toString());
    }

    public static int searchInsert(int[] nums, int target) {
        int median=nums.length/2;
        if(nums[median]==target)
        {
            return median;
        }
        int lastIndex=0;
        if(nums[median]<target)
        {
            for(int i=median;i<nums.length;i++)
            {
                if(nums[i]==target)
                {
                    return i;
                }
                if(nums[i]<target)
                {
                    lastIndex=i;
                    if(i==nums.length-1)
                    {
                        lastIndex=lastIndex+1;
                    }
                }
                if(nums[i]>target)
                {
                    lastIndex=i;
                    return lastIndex;
                }
            }
        }

        if(nums[median]>target)
        {
            for(int i=median;i>=0;i--)
            {
                if(nums[i]==target)
                {
                    return i;
                }
                if(nums[i]>target)
                {
                    lastIndex=i;
                }
            }
        }
        return lastIndex;
    }
    public static int searchInsertOpt(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int lastIndex = 0;

        while (left <= right) {
            int median = left + (right - left) / 2;

            if (nums[median] == target) {
                return median;
            } else if (nums[median] < target) {
                left = median + 1;
                lastIndex = left;
            } else {
                right = median - 1;
                lastIndex = median;
            }
        }

        return lastIndex;
    }

}
