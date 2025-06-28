package slidingwindow;

import java.util.*;

/* Given a word pat and a text txt. Return the count of the occurences of anagrams of the word in the text.

Example 1:

Input:
txt = forxxorfxdofr
pat = for
Output: 3
Explanation: for, orf and ofr appears
in the txt, hence answer is 3.
Example 2:

Input:
txt = aabaabaa
pat = aaba
Output: 4
Explanation: aaba is present 4 times
in txt */
public class SlidingWindowAnagram {
    public static void main(String[] args) {
        String s="cbaebabacd";
        String pattern="abc";
        int n=s.length();
        Integer maximumSlidingWindow=slidingWindowAnagram(s,pattern,n);
        System.out.println("maximumSumSlidingWindow: "+maximumSlidingWindow);
        List<Integer> anagramSlidingWindow=slidingWindowAnagramLeetCode(s,pattern,n);
        System.out.println("anagramSlidingWindow: "+anagramSlidingWindow);
    }

    private static Integer slidingWindowAnagram(String s, String pattern, int n) {

        int i=0;
        int j=0;
        Map<Character,Integer> map= new HashMap<Character,Integer>();
        int k=pattern.length();
        while(i<k)
        {
            if(map.containsKey(pattern.charAt(i)))
            {
                map.put(pattern.charAt(i),(int)map.get(pattern.charAt(i))+1);
            }else
            {
                map.put(pattern.charAt(i),1);
            }
            i++;
        }
        i=0;
        int count=0;
        int noOfAnagrams=0;
        while(j<n)
        {
            if((!map.isEmpty()) && map.containsKey(s.charAt(j)))
            {
                map.put(s.charAt(j),(int)map.get(s.charAt(j))-1);
                if((int)map.get(s.charAt(j))>=0)
                    count++;
            }
            if(j-i+1==k)
            {
                if(count==k)
                {
                    noOfAnagrams++;
                }
                if((!map.isEmpty()) && map.containsKey(s.charAt(i)))
                {
                    map.put(s.charAt(i),(int)map.get(s.charAt(i))+1);
                    if((int)map.get(s.charAt(i))>=1)
                        count--;
                }
                i++;
            }
            j++;
        }
        return noOfAnagrams;
    }

    private static List<Integer> slidingWindowAnagramLeetCode(String s, String pattern, int n) {

        List<Integer> anagramIndex= new ArrayList<>();
        int i=0;
        int j=0;
        Map<Character,Integer> map= new HashMap<Character,Integer>();
        int k=pattern.length();
        while(i<k)
        {
            if(map.containsKey(pattern.charAt(i)) && i==1)
            {
                map.put(pattern.charAt(i),(int)map.get(pattern.charAt(i))+1);
            }else
            {
                map.put(pattern.charAt(i),1);
            }
            i++;
        }
        i=0;
        int count=map.size();
        int noOfAnagrams=0;
        while(j<n)
        {
            if((!map.isEmpty()) && map.containsKey(s.charAt(j)))
            {
                map.put(s.charAt(j),(int)map.get(s.charAt(j))-1);
                if((int)map.get(s.charAt(j))==0)
                count--;
            }
            if(j-i+1==k)
            {
                if(count==0)
                {
                    anagramIndex.add(i);
                    noOfAnagrams++;
                }
                if((!map.isEmpty()) && map.containsKey(s.charAt(i)))
                {
                    map.put(s.charAt(i),(int)map.get(s.charAt(i))+1);
                    if((int)map.get(s.charAt(i))==1)
                    count++;
                }
                i++;
            }
            j++;
        }
        return anagramIndex;
    }

}
