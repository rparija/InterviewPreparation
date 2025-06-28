package leetcode;

public class LeetCode172 {
    public static void main(String[] args) {
        System.out.println(trailingZeroes(30));
    }
    public static int trailingZeroes(int n) {
        if(n==0)
        {
            return 0;
        }
        long factorial = 1;
        for (int i = 2; i <= n; i++) {
            factorial *= i;
        }
        System.out.println(factorial);
        int count=0;
        while(factorial%10==0)
        {
            factorial=factorial/10;
            count++;
        }
        return count;
    }
}
