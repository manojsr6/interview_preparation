public class LCS {

    // Recursive method exponential time complexity;
    public static int lcs(char[] a, char[] b, int a_index, int b_index)
    {
        if(a_index <= 0 || b_index <= 0)
        {
            return 0;
        }
        if(a[a_index-1] == b[b_index-1])
        {
            return 1 + lcs(a, b, a_index-1, b_index-1);
        }
        else
        {
            return Math.max(lcs(a, b, a_index, b_index-1), lcs(a,b, a_index-1, b_index));
        }
    }

    // Added caching technique almost others are similar
    public static int lcs1(char[] a, char[] b, int a_index, int b_index, int[][]dp)
    {
        if(a_index <= 0 || b_index <= 0)
        {
            return 0;
        }
        if(dp[a_index-1][b_index-1] != 0)
            return dp[a_index][b_index];
        if(a[a_index-1] == b[b_index-1])
        {
            return 1 + lcs1(a, b, a_index-1, b_index-1, dp);
        }
        else
        {
            return dp[a_index][b_index]= Math.max(lcs1(a, b, a_index, b_index-1,dp), lcs1(a,b, a_index-1, b_index, dp));
        }
    }
    public static int lcs2(char[] a, char[] b, int a_index, int b_index)
    {
        int rest[][]= new int[a_index+1][b_index+1];

        for(int i= 0;i<=a_index;i++)
        {
            for(int j=0;j<=b_index;j++)
            {
                if(i == 0 || j== 0)
                    rest[i][j]= 0;
                else if(a[i-1] == b[j-1])
                    rest[i][j]= rest[i-1][j-1] + 1;
                else
                    rest[i][j]= Math.max(rest[i-1][j], rest[i][j-1]);
            }
        }
        return rest[a_index][b_index];
    }

    public static int longest_common_substring_recursive(char []a, char[]b, int a_index, int b_index, int count)
    {

        if( a_index == 0 || b_index == 0)
            return count;
        int lcount1= count;
        if(a[a_index-1] == b[b_index-1])
        {
            lcount1= longest_common_substring_recursive(a,b, a_index-1, b_index-1, count+1);
        }
        int lcount2= longest_common_substring_recursive(a,b, a_index-1, b_index, 0);
        int lcount3= longest_common_substring_recursive(a,b, a_index, b_index-1, 0);

        return Math.max(lcount1, Math.max(lcount2, lcount3));
    }
    // DP without recursion- using tabular format.
    public static int longest_common_substring(char []a, char[]b, int a_index, int b_index)
    {
        int [][]L= new int[a_index+1][b_index+1];
        int result= 0;

        for(int i= 0; i<=a_index; i++)
        {
            for(int j= 0;j<=b_index;j++)
            {
                if(i== 0 || j==0)
                    L[i][j]= 0;
                else if(a[i-1] == b[j-1])
                {
                    L[i][j]= L[i-1][j-1]+1;
                    result= Math.max(result,L[i][j]);
                }
                else {
                    L[i][j] = 0;
                }
            }
        }
        return result;
    }
    public static void main(String[] args) {
        String a= "JAVAAID";
        String b= "JAVAID";
        char a1[]= a.toCharArray();
        char b1[]= b.toCharArray();
        int [][]dp= new int[a1.length][b1.length];
        System.out.println("Case 1: "+lcs(a1, b1, a1.length, b1.length));
        System.out.println("Case 2: "+lcs1(a1, b1, a1.length, b1.length, dp));
        System.out.println("Case 3: "+lcs2(a1, b1, a1.length, b1.length));
        System.out.println("Longest Common Subsequence-recursive : "+longest_common_substring_recursive(a1, b1, a1.length, b1.length, 0));
        System.out.println("Longest Common Subsequence: "+longest_common_substring(a1, b1, a1.length, b1.length));
    }
}
