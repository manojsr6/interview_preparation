public class ReverseArray {
    public static void main(String args[])
    {
        int arr[]= {1,2,3,4,5};
        int n= arr.length;
        int start= 0;
        int end= n-1;
        int temp =0;
        while(start < end)
        {
            temp= arr[start];
            arr[start]= arr[end];
            arr[end]= temp;
            start++;
            end--;
        }
        for(int i= 0; i< arr.length;i++)
        {
            System.out.print(arr[i]+" ");
        }
    }
}
