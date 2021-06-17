package com.dsa.tree;

import java.util.Stack;

public class PreOrderTraversal {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.left.left.left = new TreeNode(1);
        root.right.right = new TreeNode(8);
        root.right.left = new TreeNode(6);
        root.right.right.right = new TreeNode(9);
        printPreOderRecursive(root);
        System.out.println();
        printPreOderIterative(root);
    }

    private static void printPreOderIterative(TreeNode root) {
        if(root==null)
            return;
        Stack<TreeNode> stack=new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            root= stack.pop();
            System.out.print(root.val+" ");
            if(root.right !=null)
                stack.push(root.right);
            if(root.left !=null)
                stack.push(root.left);
        }
    }

    private static void printPreOderRecursive(TreeNode root) {
        if (root != null) {
            System.out.print(root.val + " ");
            printPreOderRecursive(root.left);
            printPreOderRecursive(root.right);
        }
    }
}
