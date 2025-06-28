package wayfair;

import java.util.HashSet;
import java.util.Set;

public class DuplicateWithKDistance {
    public static void main(String[] args) {
        int k=3;
        int [] arr={1,2,3,1,4,5};
        boolean duplicateWithKDistance= duplicateWithKDistance(arr,k);
        System.out.println(duplicateWithKDistance);
    }
    /*diff between two indexes of duplicate is less than equal to k*/
    private static boolean duplicateWithKDistance(int[] arr, int k) {
        Set<Integer> set= new HashSet<>();
        for(int i=0;i<arr.length;i++)
        {
            if(set.contains(arr[i]))
            {
                return true;
            }else
            {
                if(i>=k)
                {
                    set.remove(arr[i-k]);
                }
                set.add(arr[i]);
            }
        }
        return false;
    }
}
