package leetcode;

class LeetCode7 {
    public static void main(String[] args) {
        System.out.println(reverse(901000));
    }
    public static int reverse(int x) {
        StringBuilder sb = new StringBuilder();
        if(x<0)
        {
            sb.append("-");
            x=Math.abs(x);
        }
        while(x!=0 && x%10==0)
        {
            x=x/10;
        }
        while(x>0)
        {
            int temp=x%10;
            if((temp==0 && sb.toString().length()>=1)|| temp>0)
            {
                sb.append(temp);
            }
            x=x/10;
        }
        int result=0;
        try {
            result = Integer.parseInt(sb.toString());
        }catch(Exception ex)
        {
            return result;
        }
        return result;
    }
}