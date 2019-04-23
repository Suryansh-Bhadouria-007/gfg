package hackerearth.DirectoryDeletion;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
* You are given a directory tree of N directories/folders.
* Each directory is represented by a particular id which ranges from 1 to N.
* The id of the root directory is 1, then it has some child directories,
* those directories may contain some other ones and it goes on.
* Now you are given a list of directory id's to delete,
* you need to find the minimum number of directories that need to be deleted
* so that all the directories in the given list get deleted.

Note that if you delete a particular directory, all its child directories will also get deleted.
*
* */


public class Solution {
    static class Node {
        int id;
        List<Node> children;
        boolean marked;
        Node parent;

        public Node(int id, List<Node> children, boolean marked, Node parent) {
            this.id = id;
            this.children = children;
            this.marked = marked;
            this.parent = parent;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());
        Node root = new Node(1, new ArrayList<Node>(), false, null);
        String parentString[] = sc.nextLine().split(" ");
        for (int i = 2; i <= N; i++) {
            Integer parentId = Integer.parseInt(parentString[i - 1]);
            int id = i;
            Node parent = findNode(root, parentId);
            Node node = new Node(id, new ArrayList<Node>(), false, parent);
            parent.children.add(node);
        }
        int M = Integer.parseInt(sc.nextLine());
        String[] toBeDeleted = sc.nextLine().split(" ");
        for (int i = 0; i < M; i++) {
            Node deleted = findNode(root, Integer.parseInt(toBeDeleted[i]));
            deleted.marked = true;
        }
        getToBeDeletedCount(root);
        System.out.println(count);
    }

    private static Node findNode(Node root, Integer id) {
        Node current = root;
        if (current.id == id)
            return current;
        else {
            for (int i = 0; i < current.children.size(); i++) {
                Node n = findNode(current.children.get(i), id);
                if (n != null)
                    return n;
            }
        }
        return null;
    }

    static int count;

    private static void getToBeDeletedCount(Node node) {
        if (node == null)
            return;
        else if (node.marked)
            count++;
        else {
            for (int i = 0; i < node.children.size(); i++) {
                getToBeDeletedCount(node.children.get(i));
            }
        }
    }
}
