public class matrix_rotation {

    // method 1
    public static void rotate90degree(int a[][])
    {
        int N= a.length;
        for(int i= 0; i< N/2;i++)
        {
            for(int j= i;j<N-i-1;j++)
            {
                int temp= a[j][N-i-1];
                a[j][N-i-1]= a[i][j];
                a[i][j]= a[N-j-1][i];
                a[N-j-1][i]= a[N-i-1][N-j-1];
                a[N-i-1][N-j-1]= temp;
            }
        }
    }

    //method 2 - Rotating matrix around the main diagonal and swapping last column and first column elements.
    public static void rotate90degree_method2(int a[][])
    {
        int N= a.length;
        //first rotation
        for(int i= 0; i<N;i++)
        {
            for(int j= 0; j<i;j++)
            {
                int temp= a[i][j];
                a[i][j]= a[j][i];
                a[j][i]= temp;
            }
        }
        // second rotation
        for(int i= 0; i<N/2;i++)
        {
            for(int j= 0; j<N;j++)
            {
                int temp= a[j][i];
                a[j][i]= a[j][N-i-1];
                a[j][N-i-1]= temp;
            }
        }

    }
    public static void displayMatrix(int a[][])
    {
        for (int i = 0; i < a.length; i++)
        {
            for (int j = 0; j < a[i].length; j++)
                System.out.print( a[i][j] + " ");
            System.out.println();
        }
    }
    public static void main (String[] args)
    {
        int arr[][] = { { 1, 2, 3},
                { 4,5,6},
                { 7, 8, 9}};
        int arr1[][] = { { 1, 2, 3},
                { 4,5,6},
                { 7, 8, 9}};
        rotate90degree(arr);
        rotate90degree_method2(arr1);
        System.out.println("Using Method 1");
        displayMatrix(arr);
        System.out.println("Using Method 2");
        displayMatrix(arr1);
    }
}
