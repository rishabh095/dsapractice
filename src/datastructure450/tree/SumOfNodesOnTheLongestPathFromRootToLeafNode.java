package datastructure450.tree;

// https://www.geeksforgeeks.org/sum-nodes-longest-path-root-leaf-node/

public class SumOfNodesOnTheLongestPathFromRootToLeafNode {
    static int maxLen, maxSum;

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);         /*        4        */
        root.left = new TreeNode(2);         /*       / \       */
        root.right = new TreeNode(5);        /*      2   5      */
        root.left.left = new TreeNode(7);    /*     / \ / \     */
        root.left.right = new TreeNode(1);   /*    7  1 2  3    */
        root.right.left = new TreeNode(2);   /*      /          */
        root.right.right = new TreeNode(3);  /*     6           */
        root.left.right.left = new TreeNode(6);
        System.out.println(maxSumFromRootToLeaf(root));
    }

    private static int maxSumFromRootToLeaf(TreeNode root) {
        if (root == null)
            return 0;
        maxLen = 0;
        maxSum = Integer.MIN_VALUE;
        maxSumFromRootToLeafUtil(root, 0, 0);
        return maxSum;
    }

    private static void maxSumFromRootToLeafUtil(TreeNode root, int sum, int len) {

        if (root == null) {
            if (maxLen < len) {
                maxLen = len;
                maxSum = sum;
            } else if (maxLen == len && maxSum < sum)
                maxSum = sum;
            return;
        }
        maxSumFromRootToLeafUtil(root.left, sum + root.val, len + 1);
        maxSumFromRootToLeafUtil(root.right, sum + root.val, len + 1);
    }
}
