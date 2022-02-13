package datastructure450.tree;

// https://www.geeksforgeeks.org/check-if-a-given-binary-tree-is-sumtree/

public class IsSumTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(26);
        root.left = new TreeNode(10);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(6);
        root.right.right = new TreeNode(3);
        System.out.println(isSumTree(root));
    }

    // O(n) time complexity
    private static boolean isSumTree(TreeNode root) {
        if (root == null || isLeaf(root))
            return true;
        int leftSum, rightSum;
        if (isSumTree(root.left) && isSumTree(root.right)) {
            if (root.left == null)
                leftSum = 0;
            else if (isLeaf(root.left))
                leftSum = root.left.val;
            else
                leftSum = 2 * root.left.val;
            if (root.right == null)
                rightSum = 0;
            else if (isLeaf(root.right))
                rightSum = root.right.val;
            else
                rightSum = 2 * root.right.val;
            if (root.val == leftSum + rightSum)
                return true;
            else
                return false;
        }
        return false;
    }

    static boolean isLeaf(TreeNode root) {
        if (root == null)
            return false;
        if (root.left == null && root.right == null)
            return true;
        return false;
    }
}
