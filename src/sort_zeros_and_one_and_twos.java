import javax.swing.*;

public class sort_zeros_and_one_and_twos {
    public static void sort_array(int arr[], int size)
    {
        int count0=0, count1=0, count2=0;
        for(int i= 0; i<size;i++)
        {
            if(arr[i] == 0)
                count0++;
            else if(arr[i] == 1)
                count1++;
            else
                count2++;
        }
        int index=0;
        while(count0>0)
        {
            arr[index++]= 0;
            count0--;
        }
        while(count1>0)
        {
            arr[index++]= 1;
            count1--;
        }
        while(count2>0)
        {
            arr[index++]= 2;
            count2--;
        }
        for(int i= 0; i<size;i++)
        {
            System.out.print(arr[i]+" ");
        }
    }
    public static void main(String args[])
    {
            int arr[]= {1,0,0,1,2,2};
            int size= arr.length;
            sort_array(arr, size);
    }
}
