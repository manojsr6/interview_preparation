public class maximizing_cut_problem {

    public int max(int x, int y, int z)
    {
        if(x > y && x > z)
            return x;
        else if(y > x && y > z)
            return y;
        else
            return z;

    }

    public int maximizeCutUtil(int n, int dp[], int x, int y, int z)
    {
        if(n < 0)
            return Integer.MIN_VALUE;
        if(n == 0)
            return 0;
        if(dp[n] != -1)
            return dp[n];
        return dp[n]= 1 + max(maximizeCutUtil(n-x, dp, x, y, z), maximizeCutUtil(n-y, dp, x, y, z), maximizeCutUtil(n-z, dp, x, y, z));
    }
    public int maximizeCut(int n, int x, int y, int z)
    {
        int dp[]= new int[n+1];

        for(int index= 0; index <= n;index++)
        {
            dp[index]= -1;
        }
        dp[0]= 0;
        dp[n]= 1+ max(maximizeCutUtil(n-x, dp, x, y, x),maximizeCutUtil(n-y, dp, x, y, x),maximizeCutUtil(n-z, dp, x, y, x));
        if(dp[n] < 0)
            return 0;
        return dp[n];
    }

    public static void main(String[] args)
    {
        maximizing_cut_problem obj= new maximizing_cut_problem();
        int l = 11, p = 5, q = 5, r = 1;

        // Calling Function
        int ans = obj.maximizeCut(l, p, q, r);
        System.out.println(ans);
    }


    
}
