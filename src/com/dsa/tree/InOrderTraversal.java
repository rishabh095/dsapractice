package com.dsa.tree;

import java.util.Stack;

public class InOrderTraversal {
    public static void main(String[] args) {
        TreeNode root=new TreeNode(5);
        root.left=new TreeNode(3);
        root.right=new TreeNode(7);
        root.left.left=new TreeNode(2);
        root.left.right=new TreeNode(4);
        root.left.left.left=new TreeNode(1);
        root.right.right=new TreeNode(8);
        root.right.left=new TreeNode(6);
        root.right.right.right=new TreeNode(9);
        printInOderRecursive(root);
        System.out.println();
        printInOderIterative(root);
    }

    private static void printInOderIterative(TreeNode root) {
        Stack<TreeNode> stack=new Stack<>();
        TreeNode curr=root;
        while(curr!=null || !stack.isEmpty()){
            while(curr !=null){
                stack.push(curr);
                curr=curr.left;
            }
            curr= stack.pop();
            System.out.print(curr.val+" ");
            curr=curr.right;
        }
    }

    private static void printInOderRecursive(TreeNode root) {
        if(root !=null) {
            printInOderRecursive(root.left);
            System.out.print(root.val+" ");
            printInOderRecursive(root.right);
        }
    }
}
