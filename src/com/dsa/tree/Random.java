package com.dsa.tree;

class Pair {
    int first;
    int second;

    public Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}

public class Random {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(1);
        root.left.left = new TreeNode(2);
        root.left.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.left.right.left = new TreeNode(4);
        root.left.right.right = new TreeNode(5);
        System.out.print(maxSum(root));
    }

    private static int maxSum(TreeNode root) {
        Pair pairSum = maxSumUtil(root);
        return Math.max(pairSum.first, pairSum.second);
    }

    private static Pair maxSumUtil(TreeNode root) {
        if (root == null) {
            return new Pair(0, 0);

        }
        Pair sum1 = maxSumUtil(root.left);
        Pair sum2 = maxSumUtil(root.right);
        Pair sum = new Pair(0, 0);
        sum.first = root.val + sum1.second + sum2.second;
        sum.second =  Math.max(sum1.first, sum1.second) + Math.max(sum2.first, sum2.second);

        return sum;
    }
}
