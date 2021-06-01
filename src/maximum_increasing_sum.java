public class maximum_increasing_sum {
    public int maximum_sum(int arr[], int n)
    {
        int result[]= new int [n];

        for(int index= 0;index<n;index++)
        {
            result[index]= arr[index];
        }

        for(int i= 1; i<n;i++)
        {
            for(int j= 0; j<i;j++)
            {
                if(arr[j] < arr[i])
                {
                    result[i]= Math.max(result[j]+arr[i], result[i]);
                }
            }
        }
        int max= 0;
        for(int k= 0; k<n;k++)
        {
            max= Math.max(max, result[k]);
        }
        return max;
    }
    public static void main(String args[])
    {
        maximum_increasing_sum obj= new maximum_increasing_sum();
        int arr[]= {3, 10, 2, 1, 20};
        System.out.println(obj.maximum_sum(arr, arr.length));
    }
}
