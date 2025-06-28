package leetcode;

public class LeetCode309 {

    public static void main(String[] args) {
       int [] prices = {1,2,4};
       System.out.println(maxProfit(prices));
    }
        public static  int maxProfit(int[] prices) {
                if (prices == null || prices.length < 1) {
                    return 0;
                }

            int [] buy= new int[prices.length+1];
            int [] sell= new int[prices.length+1];

            buy[1]=-prices[0];
            for(int i=2;i<=prices.length;i++)
            {
                buy[i]=Math.max(buy[i-1],sell[i-2]-prices[i-1]);
                sell[i]=Math.max(sell[i-1],buy[i-1]+prices[i-1]);
            }
            return sell[prices.length];


        }
}
