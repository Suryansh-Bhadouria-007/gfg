package MirrorTrees;

// Java program to convert binary tree into its mirror

/* Class containing left and right child of current
node and key value*/


class BinaryTree2 {
    Node root;

    void mirror() {
        root = mirror(root);
    }

    Node mirror(Node node) {
        if (node == null)
            return node;

        /* do the subtrees */
        Node left = mirror(node.left);
        Node right = mirror(node.right);

        /* swap the left and right pointers */
        node.left = right;
        node.right = left;

        return node;
    }

    void inOrder() {
        inOrder(root);
    }

    /* Helper function to test mirror(). Given a binary
    search tree, print out its data elements in
    increasing sorted order.*/
    void inOrder(Node node) {
        if (node == null)
            return;

        inOrder(node.left);
        System.out.print(node.data + " ");

        inOrder(node.right);
    }

    /* testing for example nodes */
    public static void main(String args[]) {
        /* creating a binary tree and entering the nodes */
        BinaryTree2 tree = new BinaryTree2();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);

        /* print inorder traversal of the input tree */
        System.out.println("Inorder traversal of input tree is :");
        tree.inOrder();
        System.out.println("");

        /* convert tree to its mirror */
        tree.mirror();

        /* print inorder traversal of the minor tree */
        System.out.println("Inorder traversal of binary tree is : ");
        tree.inOrder();

    }
}
