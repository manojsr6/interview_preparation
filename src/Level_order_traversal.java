import java.util.LinkedList;
import java.util.Queue;

public class Level_order_traversal {
    public void level_order_traversal(Binary_Node root)
    {
        if(root == null)
            return;
        Queue<Binary_Node> pqueue= new LinkedList<Binary_Node>();

        pqueue.add(root);

        while(!pqueue.isEmpty())
        {
            Binary_Node temp= pqueue.poll();

            System.out.print(temp.data+" ");
            if(temp.left != null)
                pqueue.add(temp.left);
            if(temp.right != null)
                pqueue.add(temp.right);
        }
    }
}
