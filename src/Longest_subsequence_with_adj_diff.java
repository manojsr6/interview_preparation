public class Longest_subsequence_with_adj_diff {

    public int longest_subsequence(int arr[], int n)
    {
        int result[]= new int [n];

        for(int i= 0; i<n;i++)
        {
            result[i]= 1;
        }

        for(int i= 1; i<n;i++)
        {
            for(int j=0; j<i; j++)
            {
                int diff= arr[j]-arr[i];
                if(Math.abs(diff) == 1)
                {
                    result[i]= Math.max(result[j]+1, result[i]);
                }
            }
        }
        return result[n-1];
    }

    public static void main(String args[])
    {
        Longest_subsequence_with_adj_diff obj= new Longest_subsequence_with_adj_diff();
        int arr[]= {5, 9, 6, 11, 7, 2, 8};
        System.out.println(obj.longest_subsequence(arr, arr.length));
    }
}
