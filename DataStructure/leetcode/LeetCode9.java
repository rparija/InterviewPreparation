package leetcode;

public class LeetCode9 {

    public static void main(String[] args) {
        int x=1234567899;
        System.out.println(isPalindrome(x));
    }
    public static boolean isPalindrome(int x) {

        int originalInt=x;
        int reverseInt=0;
            while(x>0)
            {
                int temp=x%10;
                if(reverseInt>(Integer.MAX_VALUE-temp)/10)
                {
                    return false;
                }
                reverseInt=reverseInt*10+temp;
                x=x/10;
            }
        return originalInt == reverseInt;
    }
}
