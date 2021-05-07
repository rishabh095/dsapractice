package com.dsa.flipkart;

import com.sun.deploy.panel.ITreeNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class InvertBinaryTree {
    public static void main(String[] args) {
        TreeNode root=new TreeNode(4);
        root.left=new TreeNode(2);
        root.right=new TreeNode(7);
        root.left.left=new TreeNode(1);
        root.left.right=new TreeNode(3);
        root.right.left=new TreeNode(6);
        root.right.right=new TreeNode(9);
        printTreeInLevelOrder(root);
        invertTreeItrative(root);
        System.out.println();
        printTreeInLevelOrder(root);
        System.out.println();
        invertTreeRecursive(root);
        printTreeInLevelOrder(root);

        /*int[][] arr= {{10,20},{30,200},{400,50},{30,20}};
        for(int[] a:arr)
            System.out.println(Arrays.toString(a));
        System.out.println("After sort");
        Arrays.sort(arr,(a,b)-> a[0]-a[1]);
        for(int[] a:arr)
            System.out.println(Arrays.toString(a));
        System.out.println();
        Arrays.sort(arr,(a,b)-> a[0]-a[1]-(b[0]-b[1]));
        for(int[] a:arr)
            System.out.println(Arrays.toString(a));*/
    }

    private static TreeNode invertTreeRecursive(TreeNode root) {
        if(root == null)
            return null;
        TreeNode right=invertTreeRecursive(root.right);
        TreeNode left=invertTreeRecursive(root.left);
        root.left=right;
        root.right=left;
        return root;
    }

    private static void invertTreeItrative(TreeNode root) {
        if(root == null)
            return;
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()){
            TreeNode curr=q.poll();
            TreeNode temp=curr.left;
            curr.left=curr.right;
            curr.right=temp;
            if(curr.left !=null)
                q.add(curr.left);
            if(curr.right !=null)
                q.add(curr.right);
        }
    }

    private static void printTreeInLevelOrder(TreeNode root) {
        if(root==null)
            return;
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                TreeNode curr=q.poll();
                System.out.print(curr.val+" ");
                if(curr.left !=null)
                    q.add(curr.left);
                if(curr.right !=null)
                    q.add(curr.right);
            }
        }
    }
}
