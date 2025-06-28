package slidingwindow;

import java.util.HashMap;
import java.util.Map;

/* Given two strings s1 and s2, return true if s2 contains a permutation of s1, or false otherwise.

In other words, return true if one of s1's permutations is the substring of s2.



Example 1:

Input: s1 = "ab", s2 = "eidbaooo"
Output: true
Explanation: s2 contains one permutation of s1 ("ba").
Example 2:

Input: s1 = "ab", s2 = "eidboaoo"
Output: false */
public class SlidingWindowPermutationInString {
    public static void main(String[] args) {
        String s1="ab";
        String s2="eidboaoo";
        boolean maximumSlidingWindow=checkInclusion(s1,s2);
        System.out.println("maximumSlidingWindow: "+maximumSlidingWindow);
    }

    public static boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            char c = s1.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int i = 0;
        int count = map.size();
        boolean isPresent = false;

        for (int j = 0; j < s2.length(); j++) {
            char c = s2.charAt(j);

            if (map.containsKey(c)) {
                int b = map.get(c);
                b--;
                map.put(c, b);
                if (b == 0) {
                    count--;
                }
            }

            // Use a while loop to adjust the window size
            while (j - i + 1 > s1.length()) {
                char leftChar = s2.charAt(i);
                if (map.containsKey(leftChar)) {
                    int b = map.get(leftChar);
                    b++;
                    map.put(leftChar, b);
                    if (b == 1) {
                        count++;
                    }
                }
                i++;
            }

            if (count == 0) {
                isPresent = true;
                break;
            }
        }

        return isPresent;
    }
}
