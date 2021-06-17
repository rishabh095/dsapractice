package com.dsa.tree;

import java.util.Stack;

public class PostOrderTraversal {
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
        printPostOderRecursive(root);
        System.out.println();
        printPostOderIterative(root);
    }

    private static void printPostOderIterative(TreeNode root) {
        if(root ==null)
            return;
        Stack<TreeNode> stack=new Stack<>();
        Stack<TreeNode> temp=new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            root=stack.pop();
            temp.push(root);
            if(root.left !=null)
                stack.push(root.left);
            if(root.right !=null)
                stack.push(root.right);
        }
        while (!temp.isEmpty())
            System.out.print(temp.pop().val+" ");
    }

    private static void printPostOderRecursive(TreeNode root) {
        if(root !=null){
            printPostOderRecursive(root.left);
            printPostOderRecursive(root.right);
            System.out.print(root.val+" ");
        }
    }
}
