public class knapsack_problem {
    public int maximize_profit(int weight[], int profit[], int capacity, int n)
    {
        if(n == 0 || capacity == 0)
            return 0;
        if(weight[n] > capacity)
            return maximize_profit(weight, profit, capacity, n-1);
        else
            return Math.max(profit[n]+ maximize_profit(weight, profit, capacity-weight[n], n-1), maximize_profit(weight, profit, capacity, n-1));
    }

    public int maximize_profit_tabular(int weight[], int profit[], int capacity, int n)
    {
        int k[][]= new int [n+1][capacity+1];

        for(int i=0; i<=n;i++)
        {
            for(int j= 0 ; j<=capacity;j++)
            {
                if(i == 0 || j == 0)
                {
                    k[i][j]= 0;
                }
                else if(weight[i-1] <= j)
                {
                    k[i][j]= Math.max(k[i-1][j], k[i-1][j-weight[i-1]]+profit[i-1]);
                }
                else
                {
                    k[i][j]= k[i-1][j];
                }
            }
        }
        return k[n][capacity];
    }

    public static void main(String args[])
    {
        knapsack_problem obj = new knapsack_problem();
        int val[] = new int[] { 60, 100, 120 };
        int wt[] = new int[] { 10, 20, 30 };
        int W = 50;
        int n = val.length;
        System.out.println("Recursive:"+obj.maximize_profit(wt, val,W, n-1));
        System.out.println("Dynamic Programming:"+ obj.maximize_profit_tabular(wt, val,W, n));
    }


}
