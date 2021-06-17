package com.dsa.tree;

// https://leetcode.com/problems/balance-a-binary-search-tree/

import java.util.ArrayList;
import java.util.List;

public class BalanceBinarySearchTree {
    static List<TreeNode> list;

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.right = new TreeNode(3);
        root.right.right.right = new TreeNode(4);
        printTree(root);
        System.out.println();

        TreeNode treeNode = balanceBST(root);
        System.out.println("Balanced Tree");
        printTree(treeNode);
    }

    private static TreeNode balanceBST(TreeNode root) {
        if (root == null)
            return null;
        list = new ArrayList<>();
        inOrder(root);
        return balanced(0, list.size() - 1);
    }

    private static TreeNode balanced(int start, int end) {
        if (start > end)
            return null;
        int mid = start + (end - start) / 2;
        TreeNode root =list.get(mid);
        root.left = balanced(start, mid - 1);
        root.right = balanced(mid + 1, end);
        return root;
    }

    private static void inOrder(TreeNode root) {
        if (root != null) {
            inOrder(root.left);
            list.add(root);
            inOrder(root.right);
        }
    }

    private static void printTree(TreeNode root) {
        if (root != null) {
            printTree(root.left);
            System.out.print(root.val + " ");
            printTree(root.right);
        }
    }
}
