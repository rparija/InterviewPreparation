package dp;

import java.util.HashMap;
import java.util.Map;

public class ScrambledStringMCMDP {
    Map<String,Boolean> map= new HashMap();
    public static void main(String[] args) {
        String s1="abcdbdacbdac";
        String s2="bdacabcdbdac";
        if(s1.length()!=s2.length())
        {
            System.out.println("isScrambedString :"+false);
        }else
        {
            boolean isScrambedString= isScrambledString(s1,s2);
            System.out.println("isScrambedString :"+isScrambedString);
        }
    }

    private static boolean isScrambledString(String s1, String s2) {
        if(s1.compareTo(s2)==0)
        {
            return true;
        }
        if(s1.length()<=1)
        {
            return false;
        }
        boolean isScrambledString=false;
        int n=s1.length();
        for (int i=1;i<=n-1;i++)
        {
//            if((isScrambledString(s1.substring(i-1,i+1),s2.substring(i-1,i+1)) &&
//                    isScrambledString(s1.substring(i+1,n),s2.substring(i+1,n))
//            || isScrambledString(s1.substring(i-1,i+1),s2.substring(n-(i+1),n)) &&
//                    isScrambledString(s1.substring(i+1,n),s2.substring(i-1,n-(i+1)))))
            if((isScrambledString(s1.substring(0,i),s2.substring(0,i)) &&
                    isScrambledString(s1.substring(i),s2.substring(i)))
                    || (isScrambledString(s1.substring(0,i),s2.substring(n-i)) &&
                    isScrambledString(s1.substring(n-i),s2.substring(0,n-i))))
            {
                isScrambledString=true;
                break;
            }
        }

        return isScrambledString;
    }
}
