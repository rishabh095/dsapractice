package datastructure450.tree;

// https://www.techiedelight.com/inorder-tree-traversal-iterative-recursive/

import java.util.Stack;

public class InOderTraversal {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);
        root.right.left.left = new TreeNode(7);
        root.right.left.right = new TreeNode(8);

        inorderRecursive(root);
        System.out.println();
        inorderIterative(root);
    }

    // O(n) time complexity and O(n) space complexity
    private static void inorderIterative(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || root != null) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop();
                System.out.print(root.val + " ");
                root = root.right;
            }
        }
    }

    // O(n) time complexity and O(h) space complexity (Recursion stack space)
    private static void inorderRecursive(TreeNode root) {
        if (root != null) {
            inorderRecursive(root.left);
            System.out.print(root.val + " ");
            inorderRecursive(root.right);
        }
    }
}
