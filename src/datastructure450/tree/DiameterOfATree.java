package datastructure450.tree;

import java.util.Map;

public class DiameterOfATree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);
        root.right.left.left = new TreeNode(7);
        root.right.left.right = new TreeNode(8);

        System.out.println(diameterOfTree(root));
        System.out.println(diameterOfTreeBetterSolution(root));
    }

    // O(n) time complexity and O(n) space complexity (recursive call)
    static int diameter = 0;

    private static int diameterOfTreeBetterSolution(TreeNode root) {
        diameterOfTreeUtil(root);
        return diameter;
    }

    private static int diameterOfTreeUtil(TreeNode root) {
        if (root == null)
            return 0;
        int left = diameterOfTreeUtil(root.left);
        int right = diameterOfTreeUtil(root.right);
        if (left + right + 1 > diameter)
            diameter = left + right + 1;
        return 1 + Math.max(left, right);
    }

    // O(n^2) time complexity and O(h) space complexity (recursive call)
    private static int diameterOfTree(TreeNode root) {
        if (root == null)
            return 0;
        int lHeight = height(root.left);
        int rHeight = height(root.right);

        int lDiameter = diameterOfTree(root.left);
        int rDiameter = diameterOfTree(root.right);
        return Math.max(lHeight + rHeight + 1, Math.max(lDiameter, rDiameter));
    }

    private static int height(TreeNode root) {
        if (root == null)
            return 0;
        return 1 + Math.max(height(root.left), height(root.right));
    }
}
