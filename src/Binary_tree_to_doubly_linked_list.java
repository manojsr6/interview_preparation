/* Conversion of Binary Search Tree into a link list using inorder traversal */
public class Binary_tree_to_doubly_linked_list {
    Binary_Node head;
    static Binary_Node prev= null;
    public void convert(Binary_Node root)
    {
        if(root == null)
            return;
        convert(root.left);
        if(prev == null) {
            this.head= root;
        }
        else
        {
            root.left= prev;
            prev.right= root;
        }
        prev= root;
        convert(root.right);
    }

    public void printDoublyLinkedList(Binary_Node head)
    {
        Binary_Node curr= head;
        while(curr != null)
        {
            System.out.print(curr.data + " ");
            curr= curr.right;
        }
    }

    public Binary_Node insert(Binary_Node root, int key)
    {
        if(root == null)
            return new Binary_Node(key);
        if(root.data > key)
            root.left= insert(root.left, key);
        else
            root.right= insert(root.right, key);
        return root;
    }



    public static void main(String args[])
    {
        Binary_tree_to_doubly_linked_list tree= new Binary_tree_to_doubly_linked_list();
        Find_the_triplelet triple= new Find_the_triplelet();
        vertical_order_traversal vot= new vertical_order_traversal();
        Level_order_traversal lot= new Level_order_traversal();
        Top_View top_view= new Top_View();
        Binary_Node root = new Binary_Node(1);
        root.left = new Binary_Node(2);
        root.right = new Binary_Node(3);
        root.left.left = new Binary_Node(4);
        root.left.right = new Binary_Node(5);
        root.right.left = new Binary_Node(6);
        root.right.right = new Binary_Node(7);
        root.right.left.right = new Binary_Node(8);
        root.right.right.right = new Binary_Node(9);
        System.out.println("Vertical Order traversal is");
        vot.printVerticalOrder(root);
        System.out.println("\n Level Order traversal is");
        lot.level_order_traversal(root);
        top_view.printTopView(root);
//        Binary_Node root= null;
//        root = tree.insert(root, 6);
//        root = tree.insert(root, -13);
//        root = tree.insert(root, 14);
//        root = tree.insert(root, -8);
//        root = tree.insert(root, 15);
//        root = tree.insert(root, 13);
//        root = tree.insert(root, 7);

//        tree.convert(root);
//
//        System.out.println("BST converted into Doubly Linked List");
//        tree.printDoublyLinkedList(tree.head);
//        triple.triple_fun(tree.head);
    }
}
