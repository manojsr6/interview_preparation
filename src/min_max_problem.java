import java.util.Stack;

public class min_max_problem {

    public int[] min_max(int[] arr, int n)
    {
        int[] result= new int[n+1];
        // Moving over windows
        for(int k= 1;k<=n;k++)
        {
            int max_min= Integer.MIN_VALUE;
            // Moving on array
            for(int i= 0; i<=n-k; i++)
            {
                int min= arr[i];
                // Moving inside each window
                for(int j= 1;j<k;j++)
                {
                    if (arr[i+j]< min) {
                        min = arr[i + j];
                    }
                }
                if( min > max_min)
                    max_min= min;
            }
            result[k]= max_min;
        }
        return result;
    }

    public int[] min_max_stack(int arr[], int n)
    {
        Stack<Integer> st= new Stack<>();
        int left[]= new int[n+1];
        int right[]= new int[n+1];

        for(int i= 0; i<n; i++)
        {
            left[i]= -1;
            right[i]= n;
        }

        for(int j= 0; j<n;j++)
        {
            while(!st.empty() && arr[st.peek()]>= arr[j])
                st.pop();
            if(!st.empty())
                left[j]= st.peek();
            st.push(j);
            System.out.print(left[j]+ " ");
        }
        System.out.println("");
        for(int j= n-1; j>=0;j--)
        {
            while(!st.empty() && arr[st.peek()]>= arr[j])
                st.pop();
            if(!st.empty())
                right[j]= st.peek();
            st.push(j);
           System.out.print(right[j]+ " ");
        }
        System.out.println("");
        int ans[]= new int[n+1];
        for(int k= 0; k<=n;k++)
        {
            ans[k]= 0;
        }

        for(int i= 0; i<n;i++)
        {
            int len= right[i]-left[i]-1;
            ans[len]= Math.max(ans[len], arr[i]);
        }

        for(int i= n-1;i>=1;i--)
        {
            ans[i]=Math.max(ans[i], ans[i+1]);
        }
        return ans;
    }

    public static  void main(String args[])
    {
        min_max_problem min= new min_max_problem();
        int arr[]= {3, 5, 4, 7, 6, 2};
        int result[]= min.min_max_stack(arr, arr.length);

        for(int index=0; index<result.length;index++)
        {
            System.out.print(result[index]+ " ");
        }
    }
}
