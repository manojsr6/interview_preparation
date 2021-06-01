public class Longest_increasing_subsequence {
    public int increasing_subsequence(int arr[], int n)
    {
        int result[]= new int[n];
        for(int i= 0; i<n; i++)
        {
            result[i]= 1;
        }
        for(int i= 1; i<n; i++)
        {
            for(int j= 0; j<i; j++)
            {
                if(arr[j] < arr[i])
                    result[i]= Math.max(result[j]+1, result[i]);
            }
        }
        return result[n-1];
    }

    public static void main(String args[])
    {
        Longest_increasing_subsequence obj= new Longest_increasing_subsequence();
        int arr[]= {3, 10, 2, 1, 20};
        System.out.println(obj.increasing_subsequence(arr, arr.length));
    }
}
