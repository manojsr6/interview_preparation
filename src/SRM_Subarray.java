public class SRM_Subarray {
    int left;
    int right;
    int max_sum;
    int current_sum;
    int max_left;
    int max_right;
    int max_up;
    int max_down;
    int k_max_up;
    int k_max_down;

    // Default constructor
    public SRM_Subarray()
    {
        this.left= 0;
        this.right= 0;
        this.max_sum= 0;
        this.current_sum= 0;
        this.max_left= 0;
        this.max_right= 0;
        this.max_up= 0;
        this.max_down= 0;
        this.k_max_down= 0;
        this.k_max_up= 0;
    }

    @Override
    public String toString() {
        return "Result [maxSum=" + max_sum + ", leftBound=" + max_left
                + ", rightBound=" + max_right + ", upBound=" + max_up
                + ", lowBound=" + max_down + "]";
    }

    public void reset_array(int a[], int m) {
        for(int i= 0; i< m;i++ )
        {
            a[i]= 0;
        }
    }

    public void kandane_algorithm(int inter_array[], int m)
    {
        int max_sum=0;
        int current_sum= 0;
        int max_up= -1;
        int max_down= -1;
        for(int i= 0; i < m ; i++)
        {
            current_sum= Math.max(current_sum+inter_array[i], inter_array[i]);
            if (current_sum < 0)
            {
                max_up= i+1;
            }
            if(max_sum < current_sum)
            {
                max_sum= current_sum;
                max_down= i;
            }
        }
        this.current_sum= max_sum;
        this.k_max_up= max_up;
        this.k_max_down= max_down;
    }


    public void srm_function(int arr[][], int m , int n)
    {
        int inter_array[]=new int[m];
        for(int l = 0; l< n; l++)
        {
            this.reset_array(inter_array, m);
            // copy summing up the elements to existing array
            for(int r= l; r<n;r++)
            {
                for(int i= 0 ; i<m;i++)
                    inter_array[i]+= arr[i][r];

                //kandane_algo
                kandane_algorithm(inter_array, inter_array.length);

                // set maximum sum, max_left, max_right, max_up, max_down
                if(this.current_sum > this.max_sum)
                {
                    this.max_sum= this.current_sum;
                    this.max_left= l;
                    this.max_right= r;
                    this.max_up= this.k_max_up;
                    this.max_down= this.k_max_down;
                }
            }
        }
    }
    public static void main(String args[])
    {
        SRM_Subarray obj= new SRM_Subarray();
        int arr[][]= {{2, -1, -3, -4, 5},
                      {0,  6,  3,  4, 1},
                      {2, -2, -1,  4, -5},
                      {-3,  3,  1,  0,  3}};
        obj.srm_function(arr, 4, 5);
        System.out.println(obj.toString());
    }
}
