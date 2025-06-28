package dp;


/*Egg Dropping using Recursion
Problem statement: You are given N floor and K eggs. You have to minimize the number of times you have to drop the eggs to find the critical floor where critical floor means the floor beyond which eggs start to break. Assumptions of the problem:

If egg breaks at ith floor then it also breaks at all greater floors.
If egg does not break at ith floor then it does not break at all lower floors.
Unbroken egg can be used again.
Note: You have to find minimum trials required to find the critical floor not the critical floor.

Example:
Input:
    4
    2

    Output:
    Number of trials when number of eggs is 2 and number of floors is 4: 3*/
public class EggDroppingMCMDP {
    static int [][] dp;
    public static void main(String[] args)
    {
        int f=1000;//no of floors
        int e=8;//no of eggs
        initilizeDP(f,e);
        int minimumNumberOfTrialsToFindCriticalFloor =minimumNumberOfTrialsToFindCriticalFloor(f,e);
        System.out.println("minimumNumberOfTrialsToFindCriticalFloor: "+minimumNumberOfTrialsToFindCriticalFloor);
    }

    private static void initilizeDP(int f, int e) {
        dp= new int[f+1][e+1];
        for(int i=0;i<=f;i++)
        {
            for(int j=0;j<=e;j++)
            {
                dp[i][j]=-1;
            }
        }
    }

    private static int minimumNumberOfTrialsToFindCriticalFloor(int f, int e) {
        if(f==0||f==1)
        {
            return f;
        }
        if(e==1)
        {
            return f;
        }
        if(dp[f][e]!=-1)
        {
            return dp[f][e];
        }
        int minTrails=Integer.MAX_VALUE;
        for(int k=1;k<=f;k++)
        {
            int breakNotBreak=1+Math.max(minimumNumberOfTrialsToFindCriticalFloor(k-1,e-1),minimumNumberOfTrialsToFindCriticalFloor(f-k,e));
            minTrails=Math.min(minTrails,breakNotBreak);
        }
        return dp[f][e]=minTrails;
    }

    private static int minimumNumberOfTrialsToFindCriticalFloorOptimized(int f, int e) {
        if(f==0||f==1)
        {
            return f;
        }
        if(e==1)
        {
            return f;
        }
        if(dp[f][e]!=-1)
        {
            return dp[f][e];
        }
        int minTrails=Integer.MAX_VALUE;
        for(int k=1;k<=f;k++)
        {
            int low;
            if(dp[k-1][e-1]!=-1)
            {
                low=dp[k-1][e-1];
            }else
            {
                low=minimumNumberOfTrialsToFindCriticalFloor(k-1,e-1);
                dp[k-1][e-1]=low;
            }
            int high;
            if(dp[f-k][e]!=-1)
            {
                high=dp[f-k][e];
            }else
            {
                high=minimumNumberOfTrialsToFindCriticalFloor(f-k,e);
                dp[f-k][e]=high;
            }
            int breakNotBreak=1+Math.max(low,high);
            minTrails=Math.min(minTrails,breakNotBreak);
        }
        return dp[f][e]=minTrails;
    }
}
