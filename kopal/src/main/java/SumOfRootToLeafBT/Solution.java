package SumOfRootToLeafBT;

/*
 * Given a binary tree, each node has value 0 or 1.
 * Each root-to-leaf path represents a binary number starting with the most significant bit.
 * For example, if the path is 0 -> 1 -> 1 -> 0 -> 1, then this could represent 01101 in binary, which is 13.
 *For all leaves in the tree, consider the numbers represented by the path from the root to that leaf.
 *Return the sum of these numbers.*/
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class Solution {
    static int addition = 0;

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(0);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(1);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(1);
        System.out.println(sumRootToLeaf(root));
    }

    public static int sumRootToLeaf(TreeNode root) {
        sumRootToLeafUtil(root, "", 0);
        return addition;
    }

    private static void sumRootToLeafUtil(TreeNode node, String bin, int sum) {
        if (node.left == null && node.right == null) {
            bin += node.val;
            addition += convertBinaryToDecimal(bin);
        } else {
            bin += node.val;
            if (node.left != null)
                sumRootToLeafUtil(node.left, bin, sum);
            if (node.right != null)
                sumRootToLeafUtil(node.right, bin, sum);
        }
    }

    private static int convertBinaryToDecimal(String bin) {
        int l = bin.length();
        int dec = 0;
        for (int i = 0; i < l; i++) {
            dec += (bin.charAt(i) == '0' ? 0 : 1) * Math.pow(2, l - 1 - i);
        }
        return dec;
    }
}
