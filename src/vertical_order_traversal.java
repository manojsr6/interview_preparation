import java.util.Map;
import java.util.TreeMap;
import java.util.Vector;

public class vertical_order_traversal {

    public void getVerticalOrder(Binary_Node root, int hd, TreeMap<Integer, Vector<Integer>> m)
    {
        if(root == null)
            return;
        Vector<Integer> v= m.get(hd);

        if(v == null)
        {
            v= new Vector<Integer>();
            v.add(root.data);
        }
        else
            v.add(root.data);
        m.put(hd, v);

        getVerticalOrder(root.left, hd-1, m);
        getVerticalOrder(root.right, hd+1, m);
    }

    public void printVerticalOrder(Binary_Node root)
    {
        TreeMap<Integer, Vector<Integer>> m= new TreeMap<Integer, Vector<Integer>>();
        int hd= 0;
        getVerticalOrder(root, hd, m);

        for(Map.Entry<Integer, Vector<Integer>> entry: m.entrySet())
        {
            System.out.print(entry.getValue());
        }
    }
}
