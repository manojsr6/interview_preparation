import java.util.Stack;

public class next_great_element {


    // time complexity O(N2) and space complexity O(1)
    public static void printNext(int []arr, int n)
    {
        int next= -1;
        for(int index= 0; index<n;index++)
        {
            next = -1;
            for(int j= index+1;j<n;j++ )
            {
                if(arr[j]> arr[index])
                {
                    next= arr[j];
                    break;
                }

            }
            System.out.println(arr[index]+" ----- >"+ next);
        }

    }

    public static void using_stack(int []arr, int n)
    {
        Stack<Integer> xp= new Stack<Integer>();

        xp.push(arr[0]);

        for(int i= 1; i< n;i++)
        {
            if(!xp.isEmpty())
            {
                if(xp.peek()< arr[i])
                {
                    while(!xp.isEmpty() && xp.peek()<arr[i])
                    {
                        System.out.println(xp.peek()+"--->"+arr[i]);
                        xp.pop();
                    }
                }
                else
                {
                    xp.push(arr[i]);
                }
            }
            xp.push(arr[i]);
        }
        while(!xp.isEmpty())
        {
            System.out.println(xp.pop()+"--->"+"-1");
        }
    }

    public static void main(String args[])
    {
        int arr[]={11,13,21,3};
        int n= arr.length;
        using_stack(arr, n);
    }
}
