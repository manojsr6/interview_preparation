public class SubsetSum {
    public boolean subsetFunction(int arr[], int target)
    {
        int row= arr.length;
        int col= target;
        boolean T[][]= new boolean[row+1][col+1];

        for(int i= 0; i<row; i++)
        {
            T[i][0]= true;
        }

        for(int i= 1; i<=row;i++)
        {
            for(int j= 1; j<=col; j++)
            {
                if(j - arr[i-1] >=0)
                {
                    T[i][j]= T[i-1][j] || T[i-1][j-arr[i-1]];
                }
                else
                {
                    T[i][j]= T[i-1][j];
                }
            }
        }
        return T[row][col];
    }

    // Another variant of same problem
    public boolean partition(int arr[])
    {
        int sum= 0;
        for(int index= 0; index<arr.length;index++)
        {
            sum+=arr[index];
        }
        if(sum%2 != 0)
        {
            return false;
        }
        sum= sum/2;

        boolean T[][]= new boolean[arr.length+1][sum+1];

        for(int i= 0; i<arr.length;i++)
        {
            T[i][0]= true;
        }

        for(int i= 1; i<= arr.length;i++)
        {
            for(int j=1;j<=sum;j++)
            {
                if(j-arr[i-1] >=0)
                    T[i][j]= T[i-1][j] || T[i-1][j-arr[i-1]];
                else
                    T[i][j]= T[i-1][j];
            }
        }
        return T[arr.length][sum];
    }

    public static void main(String args[]) {
        SubsetSum ss = new SubsetSum();
        int arr[] = {1, 3, 5, 5, 2, 1, 1, 6};
        System.out.println(ss.partition(arr));

        int arr1[] = {2, 3, 7, 8};
        System.out.print(ss.subsetFunction(arr1, 11));

    }
}
