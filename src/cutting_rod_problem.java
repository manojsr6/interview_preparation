public class cutting_rod_problem {

    public int maximize_profit(int profit[], int n)
    {
        if(n==0)
            return 0;
        int max_value= Integer.MIN_VALUE;

        for(int i= 0; i<n; i++)
        {
            max_value= Math.max(max_value, profit[i]+ maximize_profit(profit, n-i-1));
        }
        return max_value;
    }

    public int maximize_profit_dp(int profit[], int n)
    {
        int val[]= new int[n+1];
        val[0]= 0;

        for(int i= 1; i<=n; i++ )
        {
            int max_val = Integer.MIN_VALUE;
            for(int j= 0; j<i;j++)
            {
                max_val= Math.max(max_val, profit[j]+ val[i-j-1]);
            }
            val[i]= max_val;
        }
        return val[n];
    }

    public static void main(String args[])
    {
        cutting_rod_problem obj= new cutting_rod_problem();
        int arr[] = new int[] {1, 5, 8, 9, 10, 17, 17, 20};
        int size = arr.length;
        System.out.println("Maximum Obtainable Value is " +
                obj.maximize_profit_dp(arr, size));
        System.out.println("Maximum Obtainable Value is " +
                obj.maximize_profit(arr, size));
    }
}
