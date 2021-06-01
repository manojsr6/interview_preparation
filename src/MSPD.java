import java.lang.reflect.Array;
import java.util.Arrays;

// Maximum sum of pairs with specific difference
public class MSPD {
    public int mspd(int arr[], int diff)
    {
        int n= arr.length;
        int T[]= new int[n];
        Arrays.sort(arr);
        T[0]= 0;
        for(int i= 1; i<n;i++)
        {
            if(arr[i]-arr[i-1] < diff)
            {
                if(i >=2)
                    T[i]= Math.max(T[i-1], arr[i]+arr[i-1]+T[i-2]);
                else
                    T[i]= Math.max(T[i-1], arr[i]+arr[i-1]);
            }
            else
            {
                T[i]= T[i-1];
            }
        }
        return T[n-1];
    }
    public static void main(String args[])
    {
        MSPD obj= new MSPD();
        int arr[]= {3, 5, 10, 15, 17, 12, 9};
        int k= 4;
        System.out.println(obj.mspd(arr, k));
    }
}
