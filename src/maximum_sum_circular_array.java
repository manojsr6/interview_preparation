public class maximum_sum_circular_array {

    public static int maximumSubsequence(int []a, int start, int end, int n)
    {
            int []dp= new int[n];
            int maxSum= 0;

            for(int index= start; index<end+1;index++)
            {
                dp[index]= a[index];
                if(maxSum < a[index])
                {
                    maxSum= a[index];
                }
            }

            for(int i= start+2; i<(end+1);i++)
            {
                for(int j= 0; j<i-1;j++)
                {
                    if(dp[i] < dp[j]+a[i])
                        dp[i]= dp[j]+a[i];
                    if(maxSum < dp[i])
                        maxSum= dp[i];
                }
            }
            return maxSum;
    }
    public static void main(String args[])
    {
        int array[]= {4,1,5,3,2};
        System.out.print(Math.max(maximumSubsequence(array, 0, array.length-2, array.length), maximumSubsequence(array, 1, array.length-1, array.length)));
    }
}
