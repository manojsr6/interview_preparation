public class Maximum_and_Minimum {
    public static void main(String args[])
    {
        int maximum= 0;
        int minimum= 0;
        int arr[]={2,3,4,5};
        minimum=arr[0];
        for(int i= 0; i<arr.length;i++)
        {
            if(arr[i]<minimum)
            {
                minimum= arr[i];
            }
            if(arr[i]> maximum)
                maximum= arr[i];
        }
        System.out.println("Maximum: "+maximum);
        System.out.println("Minimum: "+minimum);
    }
}
