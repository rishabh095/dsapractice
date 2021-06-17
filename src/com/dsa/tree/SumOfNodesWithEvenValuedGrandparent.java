package com.dsa.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SumOfNodesWithEvenValuedGrandparent {
    static int sum;
    public static void main(String[] args) {
        sum=0;
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(7);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(7);
        root.left.left.left = new TreeNode(9);
        root.left.right.left = new TreeNode(1);
        root.left.right.right = new TreeNode(4);
        root.right.left = new TreeNode(1);
        root.right.right = new TreeNode(3);
        root.right.right.right = new TreeNode(5);
        System.out.println(printSum(root));
    }

    private static int printSum(TreeNode root){
        sumEvenGrandparent(root,null,null);
        return sum;
    }

    private static void sumEvenGrandparent(TreeNode root, TreeNode parent, TreeNode gpraent) {
        if(root ==null)
            return ;
        if(gpraent !=null && gpraent.val %2==0)
            sum+=root.val;
        if(root.left !=null)
            sumEvenGrandparent(root.left,root,parent);
        if(root.right !=null)
            sumEvenGrandparent(root.right,root,parent);
    }
}
