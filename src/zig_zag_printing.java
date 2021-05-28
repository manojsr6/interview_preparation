import java.util.Arrays;

public class zig_zag_printing {
    public void zig_zag_printing(String s, int n)
    {
        String[] arr= new String[n];
        Arrays.fill(arr, "");
        int row= 0;
        int direction= -1;

        for(int index= 0; index<s.length();index++ )
        {
                arr[row]+= s.charAt(index);
                if(row== 0 || row == n-1)
                {
                    direction *=-1;
                }
                row += direction;
        }

        for(int index=0; index<n;index++) {
            System.out.println(arr[index]);
        }
    }

    public  static void main(String args[])
    {
        zig_zag_printing zig= new zig_zag_printing();
        zig.zig_zag_printing("PAYPALISHIRING", 3);
    }
}
