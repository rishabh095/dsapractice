package datastructure450.tree;

// https://www.techiedelight.com/postorder-tree-traversal-iterative-recursive/

import java.util.Stack;

public class PostOrderTraversal {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);
        root.right.left.left = new TreeNode(7);
        root.right.left.right = new TreeNode(8);

        postorderRecursive(root);
        System.out.println();
        postorderIterative(root);
    }

    // O(n) time complexity and O(n) space complexity
    private static void postorderIterative(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        Stack<TreeNode> output = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            root = stack.pop();
            output.push(root);
            if (root.left != null)
                stack.push(root.left);
            if (root.right != null)
                stack.push(root.right);
        }
        while (!output.isEmpty())
            System.out.print(output.pop().val + " ");
    }

    // O(n) time complexity and O(h) space complexity (Recursion stack space)
    private static void postorderRecursive(TreeNode root) {
        if (root != null) {
            postorderRecursive(root.left);
            postorderRecursive(root.right);
            System.out.print(root.val + " ");
        }
    }
}
