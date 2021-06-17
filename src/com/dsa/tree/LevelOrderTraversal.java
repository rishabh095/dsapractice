package com.dsa.tree;

import sun.reflect.generics.tree.Tree;

import java.util.*;

public class LevelOrderTraversal {
    static List<List<Integer>> listRec=new ArrayList<>();
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        List<List<Integer>> lists = levelOrderIterative(root);
        for(List<Integer> list:lists)
            System.out.println(list);
        levelOrderRecursive(root);
        for(List<Integer> list:listRec)
            System.out.println(list);
        Collections.reverse(listRec);
        System.out.println("Bottom up traversal print ");
        for(List<Integer> list:listRec)
            System.out.println(list);
    }

    private static void levelOrderRecursive(TreeNode root) {
        if(root ==null)
            return;
         dfs(root,0);
    }

    private static void dfs(TreeNode root, int level) {
        if(root==null)
            return;
        if(listRec.size()==level)
            listRec.add(new ArrayList<>());
        listRec.get(level).add(root.val);
        if(root.left !=null)
            dfs(root.left,level+1);
        if(root.right !=null)
            dfs(root.right,level+1);
    }

    private static List<List<Integer>> levelOrderIterative(TreeNode root) {
        if (root == null)
            return null;
        List<List<Integer>> list=new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> l=new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                root = queue.poll();
                l.add(root.val);
                if (root.left != null)
                    queue.add(root.left);
                if (root.right != null)
                    queue.add(root.right);
            }
            list.add(l);
        }
        return list;
    }
}
