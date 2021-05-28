import java.util.PriorityQueue;

// order of merge_k_array using min heap   time comp O(n*k*logk) and space complex O(k)
public class Merge_K_arrays {

    public static void merge_arrays(int a[], int b[], int c[], int n)
    {
        int result[]= new int[n*3];
        PriorityQueue<Integer> pq= new PriorityQueue<Integer>();

        for(int i=0; i<n;i++)
        {
            pq.add(a[i]);
            pq.add(b[i]);
            pq.add(c[i]);
        }
        int index= 0;
        while(!pq.isEmpty())
        {
            result[index]= pq.poll();
            ++index;
        }

        for(int g= 0; g<result.length;g++) {
            System.out.println(result[g]);
        }
    }

    public static void main(String args[])
    {
        int a[]= {1, 5, 6, 8};
        int b[]= {2, 4, 10, 12};
        int c[]=   {3, 7, 9, 11};

        merge_arrays(a, b, c, a.length);
    }
}
