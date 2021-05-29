import javax.swing.tree.TreeNode;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class Top_View {
    class Pair{
        int data;
        int level;
        public Pair(int data, int level)
        {
            this.data= data;
            this.level= level;
        }
    }

    public void fillUpViewMap(Binary_Node currentNode, int currlevel, int horizontal, Map viewMap)
    {
        if(currentNode == null){
            return;
        }
        Pair pair= (Pair) viewMap.get(new Integer(horizontal));
        if(pair != null)
        {
            if(currlevel < pair.level)
            {
                Pair new_pair= new Pair(currentNode.data, currlevel);
                viewMap.put(horizontal, new_pair);
            }
        }
        else
        {
            Pair new_pair= new Pair(currentNode.data, currlevel);
            viewMap.put(horizontal, new_pair);
        }
        fillUpViewMap(currentNode.left, currlevel+1, horizontal-1, viewMap);
        fillUpViewMap(currentNode.right, currlevel+1, horizontal+1, viewMap);
    }

    public void printTopView(Binary_Node root)
    {
        Map<Integer, Pair> viewMap= new TreeMap<>();
        fillUpViewMap(root, 0,0, viewMap);
        Iterator<Map.Entry<Integer, Pair>> iterator= viewMap.entrySet().iterator();

        while(iterator.hasNext())
        {
            Map.Entry<Integer, Pair> nodeEntry= iterator.next();
            System.out.print(""+nodeEntry.getValue().data);
        }
    }
}
