package leetcode;

import java.util.*;

public class LeetCode2384 {

    public static void main(String[] args) {
        String s="444947137";
        System.out.println(largestPalindromic(s));
        s = "00009";
        System.out.println(largestPalindromic(s));
        s = "90009";
        System.out.println(largestPalindromic(s));
        s="00001105";
        System.out.println(largestPalindromic(s));
    }

    public static String largestPalindromic(String num) {
        TreeMap<Integer, Integer> map = new TreeMap<>(Collections.reverseOrder());
        StringBuilder sb = new StringBuilder();
        StringBuilder result = new StringBuilder();

        // Count frequencies
        for (int i = 0; i < num.length(); i++) {
            map.merge(Character.getNumericValue(num.charAt(i)), 1, Integer::sum);
        }

        ArrayList<Integer> evenList = new ArrayList<>();
        int maxOddValue = -1;
        int finalSizeOfArray = 0;

        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            if(e.getKey()==0 && sb.length()==0)
            {
                continue;
            }
            if (e.getValue() % 2 == 0) {
                int count = e.getValue() / 2;
                finalSizeOfArray += e.getValue();
                for (int i = 0; i < count; i++) {
                    sb.append(e.getKey());
                    evenList.add(e.getKey());
                }
            } else {
                int count = e.getValue() / 2;
                for (int i = 0; i < count; i++) {
                    sb.append(e.getKey());
                    evenList.add(e.getKey());
                }
                maxOddValue = Math.max(maxOddValue, e.getKey());
            }
        }

        // ✅ Added fix: if sb is empty and maxOddValue is valid, return only the center digit
        if (sb.length() == 0 && maxOddValue != -1) {
            return String.valueOf(maxOddValue);
        }

        String res = sb.toString();
        result = new StringBuilder(res);
        if (maxOddValue != -1) {
            result.append(maxOddValue);
        }
        result.append(sb.reverse());
        return result.toString();
    }

}
