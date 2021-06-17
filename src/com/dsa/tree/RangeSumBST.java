package com.dsa.tree;

public class RangeSumBST {
    static int sum=0;
    static int sum2=0;
    public static void main(String[] args) {
        TreeNode root=new TreeNode(10);
        root.left=new TreeNode(5);
        root.left.left=new TreeNode(3);
        root.left.right=new TreeNode(7);
        root.right=new TreeNode(15);
        root.right.right=new TreeNode(18);
        System.out.println(rangeSum(root,7 ,15));
        System.out.println(rangeSumBetterSolution(root,7 ,15));
    }

    private static int rangeSumBetterSolution(TreeNode root, int low, int high) {
        if (root !=null){
            if(low<=root.val && high>=root.val)
                sum2+=root.val;
            if(root.val>=low)
                rangeSumBetterSolution(root.left,low,high);
            if(root.val<=high)
                rangeSumBetterSolution(root.right,low,high);
        }
        return sum2;
    }

    private static int rangeSum(TreeNode root, int low, int high) {
        if(root == null)
            return 0;
        rangeSum(root.left,low,high);
        if(low<=root.val && high>=root.val)
            sum+=root.val;
        rangeSum(root.right,low,high);
        return sum;
    }
}
