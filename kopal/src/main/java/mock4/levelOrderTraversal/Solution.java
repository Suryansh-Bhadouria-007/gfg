package mock4.levelOrderTraversal;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class Solution {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(1);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);
        System.out.println(levelOrder(root));
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null)
            return new ArrayList<>();
        List<List<Integer>> lot = new ArrayList<>();
        Queue<TreeNode> q0 = new ArrayDeque<>();
        Queue<TreeNode> q1 = new ArrayDeque<>();
        q0.add(root);
        List<Integer> localList = new ArrayList<>();
        while (!q0.isEmpty() || !q1.isEmpty()) {
            if (!q0.isEmpty()) {
                while (!q0.isEmpty()) {
                    TreeNode temp = q0.poll();
                    localList.add(temp.val);
                    if (temp != null && temp.left != null) {
                        q1.add(temp.left);
                    }
                    if (temp != null && temp.right != null) {
                        q1.add(temp.right);
                    }
                }
                lot.add(localList);
                localList = new ArrayList<>();
            } else if (!q1.isEmpty()) {
                while (!q1.isEmpty()) {
                    TreeNode temp = q1.poll();
                    localList.add(temp.val);
                    if (temp != null && temp.left != null) {
                        q0.add(temp.left);
                    }
                    if (temp != null && temp.right != null) {
                        q0.add(temp.right);
                    }
                }
                lot.add(localList);
                localList = new ArrayList<>();
            }
        }
        return lot;
    }
}
