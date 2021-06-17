package com.dsa.tree;

public class ValidateBST {
    public static void main(String[] args) {
        TreeNode root=new TreeNode(5);
        root.left=new TreeNode(6);
        root.right=new TreeNode(7);
        root.left.left=new TreeNode(2);
        root.left.right=new TreeNode(4);
        root.left.left.left=new TreeNode(1);
        root.right.right=new TreeNode(8);
        root.right.left=new TreeNode(6);
        root.right.right.right=new TreeNode(9);
        System.out.println(validateRecursive(root,null,null));
    }

    private static boolean validateRecursive(TreeNode root, Integer min, Integer max) {
        if(root ==null)
            return true;
        int value=root.val;
        if(min !=null && min>=value)
            return false;
        if(max !=null && max<=value)
            return false;
        return validateRecursive(root.left,min,value) && validateRecursive(root.right,value,max);
    }
}
