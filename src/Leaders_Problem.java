public class Leaders_Problem {
    public static void leaders_problem(int arr[], int n)
    {
        int max= arr[n-1];
        for(int i= n-2; i>=0;i--)
        {
            if(max < arr[i])
            {
                System.out.println(max);
                max= arr[i];
            }
        }
        System.out.println(max);
    }

    public static void main(String args[])
    {
        int arr[] = new int[]{16, 17, 4, 3, 5, 2};
        leaders_problem(arr, arr.length);
    }
}
