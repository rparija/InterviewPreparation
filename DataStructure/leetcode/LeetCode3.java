package leetcode;

import java.util.HashSet;
import java.util.Set;

public class LeetCode3 {

    public static void main(String[] args) {
        String s="abcabcbb";
        System.out.println(longestSubstringWithUniqueChar(s));
        s="pwwkew";
        System.out.println(longestSubstringWithUniqueChar(s));
        s="au";
        System.out.println(longestSubstringWithUniqueChar(s));
    }
    public static int longestSubstringWithUniqueChar(String s) {
        int n=s.length();
        int longestSubstringWithUniqueChar=0;
        Set<Character> set = new HashSet<>();
        int j=0;
        int maxSize=0;
        if(n==1)
        {
            return 1;
        }
        for (int i=0;i<s.length();i++)
        {
            Character c= s.charAt(i);
            if(set.contains(c))
            {
                while(set.contains(c))
                {
                    set.remove(s.charAt(j));
                    j++;
                }
                set.add(c);
            }else {
                set.add(c);
                maxSize=Math.max(maxSize,set.size());
            }
        }
        return maxSize;
    }
}
