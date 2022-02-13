package datastructure450.tree;

public class SumTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(-2);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(8);
        root.left.right = new TreeNode(-4);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(5);
        inorderRecursive(root);
        sumTree(root);
        System.out.println();
        inorderRecursive(root);

    }

    // O(n) time complexity
    private static int sumTree(TreeNode root) {
        if (root == null)
            return 0;
        int oldVal = root.val;
        root.val = sumTree(root.left) + sumTree(root.right);
        return root.val + oldVal;
    }

    private static void inorderRecursive(TreeNode root) {
        if (root != null) {
            inorderRecursive(root.left);
            System.out.print(root.val + " ");
            inorderRecursive(root.right);
        }
    }
}
