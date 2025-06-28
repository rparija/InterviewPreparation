package leetcode;

public class LeetCode26 {

    public static void main(String[] args) {
        int [] nums={1,1,2};
        System.out.println(removeDuplicates(nums));
    }
    public static int removeDuplicates(int[] nums) {
        int [] arr= new int[nums.length];
        arr[0]=nums[0];
        int j=0;
        int count=1;
        for(int i=1;i<nums.length;i++)
        {
            if(nums[i]>arr[j])
            {
                j++;
                count++;
                arr[j]=nums[i];
            }

        }
        for(int i=0;i<nums.length;i++)
        {
            nums[i]=arr[i];
        }

        return count;
    }
}
