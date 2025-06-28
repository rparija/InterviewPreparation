package leetcode;

import java.util.Arrays;
import java.util.List;

public class LeetCode139 {
    public static void main(String[] args) {
        String s ="leetcode";
        List<String> wordDict= Arrays.asList("leet","code");
        System.out.println(wordBreak(s,wordDict));
    }
        public static boolean wordBreak(String s, List<String> wordDict) {
            boolean[] dp = new boolean[s.length() + 1];
            dp[0] = true;

            for (int i = 0; i <= s.length(); i++) {
                if(!dp[i])
                    continue;
               for(String word:wordDict)
               {
                   int l=word.length();
                   if(i+l<=s.length() &&  s.substring(i,i+l).equals(word))
                   {
                       dp[i+l]=true;
                   }
               }
            }
            return dp[s.length()];
        }
}