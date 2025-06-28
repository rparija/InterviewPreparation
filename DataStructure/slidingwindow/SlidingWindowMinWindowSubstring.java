package slidingwindow;

import java.util.HashMap;
import java.util.Map;

/*Problem Description: https://leetcode.com/problems/minimum-window-substring/description/

Given two strings s and t, return the minimum window in s which will contain
all the characters in t. If there is no such window in s that covers all characters
 in t, return the empty string "".

Note that If there is such a window, it is guaranteed that there will always be
only one unique minimum window in s.



Example 1:

Input: s = "ADOBECODEBANC", t = "ABC"
Output: "BANC"
Example 2:

Input: s = "a", t = "a"
Output: "a"
 */
public class SlidingWindowMinWindowSubstring {
    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        String minWindowSubstring=minWindowSubstring(s,t);
        System.out.println("minWindowSubstring: "+minWindowSubstring);
    }

    /*basically this is a variable sliding window problem where we need to use map to keep the char and their corresponding count
    * once the count of any key in map reaches more than 1 then we can take that substring and save the count of that ,
    *  and remove the ith elements from the map till the size of map becomes less than k*/
    public static String minWindowSubstring(String s, String t)
    {
        int i=0;
        int j=0;
        Map<Character,Integer> map = new HashMap<Character,Integer>();
        int minVal=Integer.MAX_VALUE;
        for(int k=0;k<t.length();k++)
        {
            if(map.containsKey(t.charAt(k)))
            {
                map.put(t.charAt(k),(int)(map.get(t.charAt(k))+1));
            }else
            {
                map.put(t.charAt(k),1);

            }

        }
        int count=map.size();
        String ans="";
        while(j<s.length())
        {
            if(map.containsKey(s.charAt(j)))
            {
                int c=map.get(s.charAt(j));
                c--;
                map.put(s.charAt(j),c);
                if(c==0)
                {
                    count--;
                }
            }

            if(count==0)
            {

                while(count==0)
                {
                    if(minVal>j-i+1) {
                        minVal = Math.min(minVal, j - i + 1);
                        ans = s.substring(i, j + 1);
                    }
                    if(map.containsKey(s.charAt(i)))
                    {
                        int d=map.get(s.charAt(i));
                        d++;
                        map.put(s.charAt(i),d);
                        if(d>0)
                        {
                            count++;
                        }
                    }
                    i++;
                }
            }
            j++;
        }

        return ans;
    }
}
