import java.util.HashSet;

public class Find_the_triplelet {
    public void triple_fun(Binary_Node root)
    {
        Binary_Node curr= root;
        Binary_Node curr1= root;
        Binary_Node next= null;

        System.out.println("\n Triplet that sums upto zero in a BST: ");
        while(curr1 != null)
        {
               next= curr1.right;
               int sum= 0 - curr1.data;
                HashSet<Integer> hset= new HashSet<Integer>();
               while(next != null)
               {
                   int diff= sum- next.data;
                   if(hset.contains(diff))
                   {
                       System.out.print(curr1.data+" "+next.data+" "+diff);
                       break;
                   }
                   hset.add(next.data);
                   next= next.right;
               }
               curr1= curr1.right;
        }
    }
}

