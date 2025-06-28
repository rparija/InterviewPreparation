package slidingwindow;

import java.util.HashMap;
import java.util.Map;

/*Problem Description:https://www.geeksforgeeks.org/problems/longest-k-unique-characters-substring0853/1
Given a string you need to print the size of the longest possible substring that has exactly k unique characters.

Example:
Input:
2
aabacbebebe
3
aaaa
1
Output:
7
4 .
 */
public class SlidingWindowLongestPossibleSubstring {
    public static void main(String[] args) {
        String s="abc";
        int k=2;//window size
        int n=s.length();
        long longestSubstringWithKUniqueChar=longestSubstringWithKUniqueChar(s,k,n);
        System.out.println("longestSubstringWithKUniqueChar: "+longestSubstringWithKUniqueChar);
    }

    /*basically this is a variable sliding window problem where we need to use map to keep the char and their corresponding count
    * once the map size reaches k then we can take that substring and save the count of that , incase the size of map increases
    * then we need to iterate and remove the ith elements from the map till the size of map becomes less than k*/
    private static int longestSubstringWithKUniqueChar(String s, int k, int n) {
        int i=0;int j=0;
        int maxSubstring=0;
        Map<Character,Integer> map = new HashMap<Character,Integer>();
        while(j<n)
        {
            if(map.containsKey(s.charAt(j)))
            {
                map.put(s.charAt(j), (int) (map.get(s.charAt(j))) + 1);
            }
            else
            {
                map.put(s.charAt(j),1);
            }
            if(map.size()<k)
            {
                j++;
                continue;
            }
            if(map.size()==k)
            {
                maxSubstring=Math.max(maxSubstring,j-i+1);
            }
            if(map.size()>k)
            {
                while(map.size()>k)
                {
                    int count=map.get(s.charAt(i));
                    count--;
                    if(count==0)
                    {
                        map.remove(s.charAt(i));
                    }else {
                        map.put(s.charAt(i),count);
                    }
                    i++;
                    if(map.size()==k)
                    {
                        maxSubstring=Math.max(maxSubstring,j-i+1);
                    }
                }
            }
            j++;
        }

        return maxSubstring;
    }

}
