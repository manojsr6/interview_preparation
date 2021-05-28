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

    public static void main(String args[])
    {
        Binary_tree_to_doubly_linked_list tree= new Binary_tree_to_doubly_linked_list();
        Binary_Node root= new Binary_Node(1);
        root.left = new Binary_Node(2);
        root.right = new Binary_Node(3);
        root.left.left = new Binary_Node(4);
        root.left.right = new Binary_Node(5);
        root.left.right.right = new Binary_Node(15);
        root.right.left = new Binary_Node(6);
        root.right.right = new Binary_Node(7);
        root.right.left.right = new Binary_Node(8);

        tree.convert(root);
        tree.printDoublyLinkedList(tree.head);
    }
}
