package datastructure450.tree;

import java.util.LinkedList;
import java.util.Queue;

public class LeftViewOfATree {
    static int maxLevel;

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);
        root.right.left.left = new TreeNode(7);
        root.right.left.right = new TreeNode(8);

        maxLevel = 0;
        leftViewRecursive(root, 1);
        System.out.println();
        leftViewIterative(root);
    }

    // O(n) time complexity and O(n) space complexity
    private static void leftViewIterative(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                root = queue.poll();
                if (i == 0)
                    System.out.print(root.val + " ");
                if (root.left != null)
                    queue.add(root.left);
                if (root.right != null)
                    queue.add(root.right);
            }
        }
    }

    // O(n) time complexity and O(h) space complexity (recursion call)
    private static void leftViewRecursive(TreeNode root, int level) {
        if (root == null)
            return;
        if (maxLevel < level) {
            System.out.print(root.val + " ");
            maxLevel = level;
        }
        leftViewRecursive(root.left, level + 1);
        leftViewRecursive(root.right, level + 1);
    }
}
