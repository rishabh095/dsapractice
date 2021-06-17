package com.dsa.tree;

// https://leetcode.com/problems/binary-search-tree-to-greater-sum-tree/

import java.util.Stack;

public class BinarySearchTreeToGreaterSumTree {
    static int sum = 0;

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(1);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(2);
        root.left.right.right = new TreeNode(3);
        root.right = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.right.left = new TreeNode(5);
        root.right.right.right = new TreeNode(8);
        printTree(root);
        bstToGstRecursive(root);
        System.out.println();
        printTree(root);
        System.out.println();
        System.out.println("Through Iterative Method");
        TreeNode root1 = new TreeNode(4);
        root1.left = new TreeNode(1);
        root1.left.left = new TreeNode(0);
        root1.left.right = new TreeNode(2);
        root1.left.right.right = new TreeNode(3);
        root1.right = new TreeNode(6);
        root1.right.right = new TreeNode(7);
        root1.right.left = new TreeNode(5);
        root1.right.right.right = new TreeNode(8);
        printTree(root1);
        bstToGstIterative(root1);
        System.out.println();
        printTree(root1);
    }

    private static void bstToGstIterative(TreeNode root) {
        if (root == null)
            return;
        Stack<TreeNode> stack = new Stack<>();
        int nodeSum = 0;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.right;
            }
            root = stack.pop();
            nodeSum += root.val;
            root.val = nodeSum;
            root = root.left;
        }
    }

    private static void bstToGstRecursive(TreeNode root) {
        if (root == null)
            return;
        bstToGstRecursive(root.right);
        sum += root.val;
        root.val = sum;
        bstToGstRecursive(root.left);

    }

    private static void printTree(TreeNode root) {
        if (root != null) {
            System.out.print(root.val + " ");
            printTree(root.left);
            printTree(root.right);
        }
    }
}
