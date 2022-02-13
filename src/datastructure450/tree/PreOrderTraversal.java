package datastructure450.tree;

import java.util.Stack;

// https://www.techiedelight.com/preorder-tree-traversal-iterative-recursive/

public class PreOrderTraversal {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);
        root.right.left.left = new TreeNode(7);
        root.right.left.right = new TreeNode(8);

        preorderRecursive(root);
        System.out.println();
        preorderIterative(root);
        System.out.println();
        preorderIterativeBetterSolution(root);
    }

    // O(n) time complexity and O(n) space complexity (only right child's of node)
    private static void preorderIterativeBetterSolution(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            if (root != null) {
                System.out.print(root.val + " ");
                if (root.right != null)
                    stack.push(root.right);
                root = root.left;
            } else
                root = stack.pop();
        }
    }

    // O(n) time complexity and O(n) space complexity
    private static void preorderIterative(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            root = stack.pop();
            System.out.print(root.val + " ");
            if (root.right != null)
                stack.push(root.right);
            if (root.left != null)
                stack.push(root.left);
        }
    }

    // O(n) time complexity and O(h) space complexity (Recursion stack space)
    private static void preorderRecursive(TreeNode root) {
        if (root != null) {
            System.out.print(root.val + " ");
            preorderRecursive(root.left);
            preorderRecursive(root.right);
        }
    }
}
