package datastructure450.tree;

// https://practice.geeksforgeeks.org/problems/check-for-balanced-tree/1

public class CheckForBalancedTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        //root.left.left.left = new TreeNode(7);
        /*root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);
        root.right.left.left = new TreeNode(7);
        root.right.left.right = new TreeNode(8);*/
        isBalanced(root);
    }

    // O(n) time complexity and O(h) space complexity for recursion call
    private static void isBalanced(TreeNode root) {
        int height = isBalancedUtil(root);
        if (height != -1)
            System.out.println("Balanced");
        else
            System.out.println("Not Balanced");
    }

    private static int isBalancedUtil(TreeNode root) {
        if (root == null)
            return 0;
        int leftHeight = isBalancedUtil(root.left);
        if (leftHeight == -1)
            return -1;
        int rightHeight = isBalancedUtil(root.right);
        if (rightHeight == -1)
            return -1;
        if (Math.abs(leftHeight - rightHeight) > 1)
            return -1;
        return Math.max(leftHeight, rightHeight) + 1;
    }
}
