public class BinarySearchTree {
    public static void main(String[] args) {
        int arr[] = {10, 7, 14, 20, 1, 5, 8};
        BinaryTree bt = new BinaryTree();
        for (int i = 0; i < arr.length; i++) {
            bt.insertBST(arr[i]);
        }
        bt.printLevelOrder();
    }
}
