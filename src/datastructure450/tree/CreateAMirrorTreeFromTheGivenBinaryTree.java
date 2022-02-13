package datastructure450.tree;

// https://www.geeksforgeeks.org/create-a-mirror-tree-from-the-given-binary-tree/

import java.util.LinkedList;
import java.util.Queue;

public class CreateAMirrorTreeFromTheGivenBinaryTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);
        root.right.left.left = new TreeNode(7);
        root.right.left.right = new TreeNode(8);

        levelOrderTraversal(root);
        System.out.println();
        TreeNode mirror = createMirror(root);
        levelOrderTraversal(mirror);
        createMirrorInPlace(root);
        System.out.println();
        levelOrderTraversal(root);

    }

    // O(n) time complexity and O(n) space complexity
    private static void createMirrorInPlace(TreeNode root) {
        if (root == null)
            return;
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        if (root.left != null)
            createMirrorInPlace(root.left);
        if (root.right != null)
            createMirrorInPlace(root.right);
    }

    // O(n) time complexity and O(n) space complexity
    private static TreeNode createMirror(TreeNode root) {
        if (root == null)
            return null;
        TreeNode node = new TreeNode(root.val);
        node.left = createMirror(root.right);
        node.right = createMirror(root.left);
        return node;
    }

    private static void levelOrderTraversal(TreeNode root) {
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
}
