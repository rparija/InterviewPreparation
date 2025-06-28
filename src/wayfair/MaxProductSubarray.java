package wayfair;

public class MaxProductSubarray
{
    public static void main(String[] args) {
        int [] arr={2,3,-2,4};
        int maxProdcut=maxProductSubArray(arr);
        System.out.println("maxProduct"+maxProdcut);
        // Example 2: Contains zero
        int[] nums2 = {-2, 0, -1};
        System.out.println("Input: [-2,0,-1], Output: " + maxProductSubArray(nums2)); // Expected: 0 (subarray is [0])

        // Example 3: All negative numbers
        int[] nums3 = {-2, -3, -1};
        System.out.println("Input: [-2,-3,-1], Output: " + maxProductSubArray(nums3)); // Expected: 6 (subarray is [-2,-3])

        // Example 4: Single element
        int[] nums4 = {5};
        System.out.println("Input: [5], Output: " + maxProductSubArray(nums4)); // Expected: 5

        // Example 5: More complex case
        int[] nums5 = {3, -1, 4};
        System.out.println("Input: [3,-1,4], Output: " + maxProductSubArray(nums5)); // Expected: 4

        // Example 6: Leading zeros
        int[] nums6 = {0, 2};
        System.out.println("Input: [0,2], Output: " + maxProductSubArray(nums6)); // Expected: 2

        // Example 7: All positive
        int[] nums7 = {1, 2, 3, 4, 5};
        System.out.println("Input: [1,2,3,4,5], Output: " + maxProductSubArray(nums7)); // Expected: 120
    }

    private static int maxProductSubArray(int[] arr) {

        if(arr.length==1)
        {
            return arr[0];
        }
        int finalProduct;
        int maxProduct;
        int minProduct;
        int tempMaxProduct;
        finalProduct=maxProduct=minProduct=arr[0];
        int i=1;
        while(i<arr.length)
        {
            int tempIndex=arr[i];
            tempMaxProduct=Math.max(tempIndex,Math.max(tempIndex*maxProduct,tempIndex*minProduct));
            minProduct=Math.min(tempIndex, Math.min(tempIndex*maxProduct,tempIndex*minProduct));
            maxProduct=tempMaxProduct;
            finalProduct=Math.max(finalProduct,maxProduct);
            i++;
        }
        return finalProduct;
    }
}
