package slidingwindow;

import java.util.HashSet;
import java.util.Set;

/*Given an array of integers Arr of size N and a number K.
 Return the maximum sum of a subarray of size K.

Example:

Input:
N = 4, K = 2
Arr = [100, 200, 300, 400]
Output:
700
Explanation:
Arr3  + Arr4 =700,
which is maximum. . */
public class SlidingWindowArray {
    public static void main(String[] args) {
        int [] arr={100,200,300,400};
        int k=2;//window size
        int n=arr.length;
        long maximumSumSlidingWindow=maximumSumSlidingWindow(arr,k,n);
        System.out.println("maximumSumSlidingWindow: "+maximumSumSlidingWindow);
        arr= new int[]{1, 5, 4, 2, 9, 9, 9};
        k=3;
        n=arr.length;
        System.out.println("maximumDistinctSumSlidingWindow: "+maximumDistinctSumSlidingWindow(arr,k,n));
    }

    private static int maximumSumSlidingWindow(int[] arr, int k, int n) {
        int maxSum=Integer.MIN_VALUE;
        int sum=0;
        int i=0,j=0;
        while(j<n)
        {
            sum=sum+arr[j];
            if(j-i+1==k)
            {
                maxSum=Math.max(maxSum,sum);
                sum=sum-arr[i];
                i++;
            }
            j++;
        }
        return maxSum;
    }

    private static int maximumDistinctSumSlidingWindow(int[] arr, int k, int n) {
        int maxSum=Integer.MIN_VALUE;
        int sum=0;
        int i=0,j=0;
        Set set= new HashSet();
        while(j<n)
        {
            while(set.contains(arr[j]))
            {
                sum=sum-arr[i];
                set.remove(arr[i]);
                i++;
            }
            set.add(arr[j]);
            sum=sum+arr[j];
            if(j-i+1==k)
            {
                maxSum=Math.max(maxSum,sum);
                set.remove(arr[i]);
                sum=sum-arr[i];
                i++;
            }
            j++;
        }
        return maxSum;
    }
}
