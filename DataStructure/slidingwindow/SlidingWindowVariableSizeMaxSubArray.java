package slidingwindow;

import java.util.HashMap;
import java.util.Map;

/*Problem Description:

Given an array containing N positive integers and an integer K.
Your task is to find the length of the longest Sub-Array with
 sum of the elements equal to the given value K.

For Input:
1
7 5
4 1 1 1 2 3 5
your output is:
4 .
 */
public class SlidingWindowVariableSizeMaxSubArray {
    public static void main(String[] args) {
        int [] arr={10,5,2,7,1,-10};
        int k=15;
        int n=arr.length;
        long maximumSumSlidingWindowVariableSize=maximumSumSlidingWindowVariableSize(arr,k,n);
        System.out.println("maximumSumSlidingWindowVariableSize: "+maximumSumSlidingWindowVariableSize);
        int maximumSumSlidingWindowVariableSizeHashMap=maximumSumSlidingWindowVariableSizeHashMap(arr,k,n);
        System.out.println("maximumSumSlidingWindowVariableSizeHashMap: "+maximumSumSlidingWindowVariableSizeHashMap);
    }

    private static int maximumSumSlidingWindowVariableSizeHashMap(int[] arr, int k, int n) {
        int sum=0;
        int max_val=Integer.MIN_VALUE;
        Map<Integer,Integer> map= new HashMap();
        for(int i=0;i<n;i++)
        {
            sum+=arr[i];
            if(sum==k)
            {
                max_val=i+1;
            }
            if(map.containsKey(sum-k))
            {
                max_val=Math.max(max_val,i-map.get(sum-k));
            }
            if(!map.containsKey(sum))
            {
                map.put(sum,i);
            }
        }
        return max_val;
    }

    private static int maximumSumSlidingWindowVariableSize(int[] arr, int k, int n) {
        int maxSumSize=Integer.MIN_VALUE;
        int sum=0;
        int i=0,j=0;
        while(j<n)
        {
            sum+=arr[j];
            if(sum<k)
            {
                j++;
            }
            if(sum==k)
            {
                maxSumSize=Math.max(maxSumSize,j-i+1);//j-i+1 is the size of subarray whose sum is k
                j++;
                sum+=arr[j];
            }
            if(sum>k)
                {
                    while (sum>k)
                    {
                        if(arr[i]<0)
                        {
                            sum+=arr[i];
                        }else
                        {
                            sum -= arr[i];
                        }
                        i++;
                    }
                    if(sum==k)
                        maxSumSize=Math.max(maxSumSize,j-i+1);
                    j++;
                }

        }
        return maxSumSize;
    }

}
