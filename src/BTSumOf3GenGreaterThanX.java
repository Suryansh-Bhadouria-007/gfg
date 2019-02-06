import java.util.Stack;

public class BTSumOf3GenGreaterThanX {
    public static void main(String args[]) {
        /* creating a binary tree and entering the nodes */
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(12);
        tree.root.left = new Node(10);
        tree.root.right = new Node(30);
        tree.root.right.left = new Node(25);
        tree.root.right.right = new Node(40);
        tree.printLevelOrder();
//        printNodes(70, tree.root, new Stack<>());
    }

    static void printNodes(int x, Node node, Stack<Integer> nodes) {
        if (node == null) {
            return;
        }
        if (x - node.data < 0) {
            nodes.push(node.data);
            for (Integer n : nodes) {
                System.out.println(n);
            }
            return;
        }
        if (nodes.size() >= 3) {
            nodes.pop();
        }
        nodes.push(node.data);
        if (node.left == null && node.right == null) {
            nodes.pop();
        }
        if (node.left != null)
            printNodes(x - node.data, node.left, nodes);
        if (node.right != null)
            printNodes(x - node.data, node.right, nodes);

    }
}
