import java.util.HashMap;

public class fibboni_series {
    public static int fibb(int n)
    {
        if(n <= 1)
            return n;
        else
            return fibb(n-1)+fibb(n-2);
    }

    public static int fibb_dynamic(int n)
    {
        HashMap<Integer, Integer> m= new HashMap<Integer, Integer>();
        m.put(0, 0);
        m.put(1,1);
        for(int i= 2; i<=n;i++)
        {
            int sum= m.get(i-1)+m.get(i-2);
            m.put(i, sum);
        }
        return m.get(n);
    }

    public static void main(String args[])
    {
        System.out.print(fibb_dynamic(500));
    }
}
