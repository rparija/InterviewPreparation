package leetcode;

import java.util.Arrays;

public class LeetCode151 {

    public static void main(String[] args) {
        String s = "the sky is blue";
        String reversedString = reverseWords(s);
        System.out.println("Reversed String: " + reversedString);
        s = "  hello world  ";
        reversedString = reverseWords(s);
        System.out.println("Reversed String: " + reversedString);
        s="a good   example";
        reversedString = reverseWords(s);
        System.out.println("Reversed String: " + reversedString);
    }

    private static String reverseWords(String s) {
        String finalString="";
        String [] words=s.split(" ");
        //words= (String[]) Arrays.stream(words).map(String::trim).toArray();
        for(int i=words.length-1;i>=0;i--)
        {
            if(!words[i].isEmpty()) {
                finalString = finalString.concat(words[i]).concat(i == 0 ? "" : " ");
            }
        }
        return finalString.trim();
    }
}
