package datastructure450.tree;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTraversal {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);
        root.right.left.left = new TreeNode(7);
        root.right.left.right = new TreeNode(8);

        levelOrderRecursive(root);
        System.out.println();
        levelOrderIterative(root);
    }

    // O(n) time complexity and O(n) space complexity
    private static void levelOrderIterative(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            root = queue.poll();
            System.out.print(root.val + " ");
            if (root.left != null)
                queue.add(root.left);
            if (root.right != null)
                queue.add(root.right);
        }
    }

    // O(n^2) time complexity and O(h) space complexity (Recursion stack space)
    private static void levelOrderRecursive(TreeNode root) {
        int height = heightOfTree(root);
        for (int i = 1; i <= height; i++)
            printLevelOrder(root, i);
    }

    private static void printLevelOrder(TreeNode root, int level) {
        if (root == null)
            return;
        if (level == 1)
            System.out.print(root.val + " ");
        if (level > 1) {
            printLevelOrder(root.left, level - 1);
            printLevelOrder(root.right, level - 1);
        }
    }

    private static int heightOfTree(TreeNode root) {
        if (root == null)
            return 0;
        return 1 + Math.max(heightOfTree(root.left) , heightOfTree(root.right));
    }
}
