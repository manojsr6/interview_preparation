public class Largest_sum_continous_subarray{

    public int largest_sum_continous_array(int arr[], int n)
    {
        int max_sum= Integer.MIN_VALUE;
        int current_sum= 0;

        for(int index= 0; index< n; index++) {
            current_sum= Math.max(current_sum+arr[index], arr[index]);
            max_sum= Math.max(max_sum, current_sum);
        }
        return max_sum;
    }
    public static void main(String args[]) {

    Largest_sum_continous_subarray obj= new Largest_sum_continous_subarray();
    int arr[] = {1,2,3,-2,5};
    System.out.println(obj.largest_sum_continous_array(arr, arr.length));
    }
}
