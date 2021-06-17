package com.dsa.tree;

import java.util.ArrayList;
import java.util.List;

public class Random2 {
    static List<Integer> pathList;

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(1);
        root.left.right.left = new TreeNode(1);
        root.right = new TreeNode(-1);
        root.right.left = new TreeNode(4);
        root.right.left.left = new TreeNode(1);
        root.right.left.right = new TreeNode(2);
        root.right.right = new TreeNode(5);
        root.right.right.right = new TreeNode(2);

        int k = 5;
        printKPath(root, k);
    }

    private static void printKPath(TreeNode root, int k) {
        pathList = new ArrayList<>();
        printKPathUtil(root, k);
    }

    private static void printKPathUtil(TreeNode root, int k) {
        if (root == null)
            return;
        pathList.add(root.val);
        printKPathUtil(root.left, k);
        printKPathUtil(root.right, k);
        int sum = 0;
        for (int i = pathList.size() - 1; i >= 0; i--) {
            sum += pathList.get(i);
            if (sum == k)
                printPath(pathList, i);
        }
        pathList.remove(pathList.size() - 1);
    }

    private static void printPath(List<Integer> pathList, int i) {
        for (int j = i; j < pathList.size(); j++)
            System.out.print(pathList.get(j) + " ");
        System.out.println();
    }
}
