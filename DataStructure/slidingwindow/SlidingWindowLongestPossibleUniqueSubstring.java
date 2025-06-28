package slidingwindow;

import java.util.HashMap;
import java.util.Map;

/*Problem Description: https://leetcode.com/problems/longest...

Given a string s, find the length of the longest substring without repeating characters.


Example:
Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring
 */
public class SlidingWindowLongestPossibleUniqueSubstring {
    public static void main(String[] args) {
        String s="pwwkew";
        int n=s.length();
        long longestSubstringWithUniqueChar=longestSubstringWithUniqueChar(s,n);
        System.out.println("longestSubstringWithKUniqueChar: "+longestSubstringWithUniqueChar);
    }

    /*basically this is a variable sliding window problem where we need to use map to keep the char and their corresponding count
    * once the count of any key in map reaches more than 1 then we can take that substring and save the count of that ,
    *  and remove the ith elements from the map till the size of map becomes less than k*/
    private static int longestSubstringWithUniqueChar(String s, int n) {
        int i=0;int j=0;
        int maxSubstring=0;
        Map<Character,Integer> map = new HashMap<Character,Integer>();
        while(j<n)
        {
           map.compute(s.charAt(j),(key,value)-> value==null?1:value+1);
            if(map.size()>j-i+1)
            {
                j++;
                continue;
            }
            if(map.size()==j-i+1)
            {
                maxSubstring=Math.max(maxSubstring,j-i+1);
            }
            if(map.size()<j-i+1)
            {
                while(map.size()<j-i+1)
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
                    if(map.size()==j-i+1)
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
