package slidingwindow;

import java.util.*;
import java.util.stream.Collectors;

/*Given an array and a positive integer k, find the first negative integer for each and
 every window(contiguous subarray) of size k.

Example:

Input:
2
5
-8 2 3 -6 10
2
8
12 -1 -7 8 -15 30 16 28
3

Output:
-8 0 -6 -6
-1 -1 -7 -15 -15 0 . */
public class SlidingWindowFirstNegativeNumberArray {
    public static void main(String[] args) {
        int [] arr={12,-1,-7,8,-15,30,16,28};
        int k=3;//window size
        int n=arr.length;
        List<Integer> firstNegativeSlidingWindow=firstNegativeSlidingWindow(arr,k,n);
        firstNegativeSlidingWindow=firstNegativeSlidingWindow.stream().map(e-> e==null?0:e).collect(Collectors.toList());
        System.out.println("firstNegativeSlidingWindow: "+firstNegativeSlidingWindow);
    }

    private static List<Integer> firstNegativeSlidingWindow(int[] arr, int k, int n) {

        int i=0;
        int j=0;
        Queue<Integer> q= new LinkedList<Integer>();
        List<Integer> finalList= new ArrayList<Integer>();
        while(j<n)
        {
            if(arr[j]<0)
            {
                q.add(arr[j]);
            }
            if(j-i+1==k)
            {
                if(q.isEmpty())
                {
                    finalList.add(0);
                }else
                {
                    if(i>0)
                    {
                        q.remove(arr[i - 1]);
                    }
                    finalList.add(q.peek());
                }
                i++;
            }
            j++;
        }
        return finalList;
    }

}
