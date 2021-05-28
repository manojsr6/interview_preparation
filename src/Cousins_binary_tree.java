import java.util.LinkedList;
import java.util.Queue;

public class Cousins_binary_tree {
    public static int getLevel(Binary_Node root, Binary_Node search_node, int level)
    {
        if(root == null)
            return 0;
        if(root == search_node)
            return level;
        int x= getLevel(root.left, search_node, level+1);
        if(x != 0)
            return x;
        return getLevel(root.right, search_node, level+1);
    }

    public static void printGivenLevel(Binary_Node root, Binary_Node search_node, int level)
    {
        if(root == null || level < 2)
        {
            return ;
        }
        if(level == 2)
        {
            if(root.left == search_node || root.right == search_node)
            {
                return;
            }
            if(root.left != null)
                System.out.print(root.left.data+" ");
            if(root.right != null)
                System.out.print(root.right.data+" ");
        }
        else if(level > 2)
        {
            printGivenLevel(root.left, search_node, level-1);
            printGivenLevel(root.right, search_node, level-1);
        }
    }

    public static void printCousin(Binary_Node root, Binary_Node search_node)
    {
        int level= getLevel(root, search_node, 1);
         printGivenLevel(root, search_node, level);
    }

    public static void printCousinIterative(Binary_Node root, Binary_Node search_node)
    {
        Queue<Binary_Node> queue= new LinkedList<Binary_Node>();
        boolean find= false;

        queue.add(root);

        while(!queue.isEmpty() && !find)
        {
            Binary_Node temp= queue.poll();

            if(temp.left == search_node || temp.right == search_node)
            {
                find= true;
            }
            else
            {
                if(temp.left != null)
                {
                    queue.add(temp.left);
                }
                if(temp.right != null)
                {
                    queue.add(temp.right);
                }
            }

        }

        if(find == true)
        {
            while(!queue.isEmpty())
            {
                Binary_Node temp= queue.poll();
                if(temp.left != null)
                    System.out.print(temp.left.data + " ");
                if(temp.right != null)
                    System.out.print(temp.right.data + " ");
            }
        }
    }

    public static void main(String args[])
    {
        Binary_Node root= new Binary_Node(1);
        root.left = new Binary_Node(2);
        root.right = new Binary_Node(3);
        root.left.left = new Binary_Node(4);
        root.left.right = new Binary_Node(5);
        root.left.right.right = new Binary_Node(15);
        root.right.left = new Binary_Node(6);
        root.right.right = new Binary_Node(7);
        root.right.left.right = new Binary_Node(8);

        System.out.print("\n Recursive Approach: ");
        printCousin(root, root.left.right);

        System.out.print("\n Iterative Approach: ");
        printCousinIterative(root, root.left.right);
    }
}
