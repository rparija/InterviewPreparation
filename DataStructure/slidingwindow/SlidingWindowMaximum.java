package slidingwindow;

import java.util.*;

/* 239. Sliding Window Maximum
You are given an array of integers nums, there is a sliding window of size k
which is moving from the very left of the array to the very right.
You can only see the k numbers in the window. Each time the sliding window
moves right by one position.

Return the max sliding window.
        Example 1:

Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
Output: [3,3,5,5,6,7]
Explanation:
Window position                Max
---------------               -----
        [1  3  -1] -3  5  3  6  7       3
        1 [3  -1  -3] 5  3  6  7       3
        1  3 [-1  -3  5] 3  6  7       5
        1  3  -1 [-3  5  3] 6  7       5
        1  3  -1  -3 [5  3  6] 7       6
        1  3  -1  -3  5 [3  6  7]      7
Example 2:

Input: nums = [1], k = 1
Output: [1]

Constraints:

        1 <= nums.length <= 105
        -104 <= nums[i] <= 104
        1 <= k <= nums.length */
public class SlidingWindowMaximum {
    public static void main(String[] args) {
        int [] arr={1,3,-1,-3,5,3,6,7};
        int k=3;//window size
        int n=arr.length;
        List<Integer> maximumSlidingWindow=maximumSlidingWindow(arr,k,n);
        int [] finalList=maximumSlidingWindow.stream().mapToInt(e->e).toArray();
        System.out.println("maximumSumSlidingWindow: "+maximumSlidingWindow);
        maximumSlidingWindow=maximumSlidingWindowOptimized(arr,k,n);
    }

    private static List<Integer> maximumSlidingWindow(int[] arr, int k, int n) {

        int i=0;
        int j=0;
        PriorityQueue<Integer> maxHeap= new PriorityQueue<Integer>(Collections.reverseOrder());
        List<Integer> finalList= new ArrayList<>();
        while(j<n)
        {
            maxHeap.add(arr[j]);
            if(j-i+1==k)
            {
                if(i>0)
                {
                    maxHeap.remove(arr[i-1]);
                }
                finalList.add(maxHeap.peek());
                i++;
            }
            j++;
        }
        return finalList;
    }

    private static List<Integer> maximumSlidingWindowOptimized(int[] arr, int k, int n) {
        List<Integer> result = new ArrayList<>();
        Deque<Integer> dq = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            // Remove indices out of the current window
            while (!dq.isEmpty() && dq.peekFirst() <= i - k) {
                dq.pollFirst();
            }
            // Remove smaller values from the back
            while (!dq.isEmpty() && arr[dq.peekLast()] < arr[i]) {
                dq.pollLast();
            }
            dq.offerLast(i);
            // Add to result when window is full
            if (i >= k - 1) {
                result.add(arr[dq.peekFirst()]);
            }
        }
        return result;
    }

}
