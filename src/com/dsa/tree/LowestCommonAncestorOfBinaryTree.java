package com.dsa.tree;

import java.util.*;

// 236. Lowest Common Ancestor of a Binary Tree
// https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
public class LowestCommonAncestorOfBinaryTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);
        root.right = new TreeNode(1);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        TreeNode p = new TreeNode(5);
        TreeNode q = new TreeNode(1);
        System.out.println(lowestCommonAncestor(root, root.left, root.right).val);
        System.out.println(lowestCommonAncestorOtherSolution(root, p, q).val);
        System.out.println(lowestCommonAncestorRecursiveSolution(root, p, q).val);
    }

    private static TreeNode lowestCommonAncestorRecursiveSolution(TreeNode root, TreeNode p, TreeNode q) {
        if(root ==null)
            return null;
        if(root.val<p.val && root.val<q.val)
            return lowestCommonAncestorRecursiveSolution(root.right,p,q);
        if(root.val>p.val && root.val>q.val)
            return lowestCommonAncestorRecursiveSolution(root.left,p,q);
        return root;
    }

    private static TreeNode lowestCommonAncestorOtherSolution(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null)
            return null;
        if(root.val==p.val || root.val==q.val)
            return root;
        TreeNode lca1=lowestCommonAncestorOtherSolution(root.left,p,q);
        TreeNode lca2=lowestCommonAncestorOtherSolution(root.right,p,q);
        if(lca1 !=null && lca2 !=null)
            return root;
        if(lca1 !=null)
            return lca1;
        else
            return lca2;
    }

    private static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Queue<TreeNode> queue = new LinkedList<>();
        Map<TreeNode, TreeNode> parent = new HashMap<>();
        parent.put(root, null);
        queue.add(root);
        while (!parent.containsKey(p) || !parent.containsKey(q)) {
             TreeNode node = queue.poll();
            if (node.left != null) {
                parent.put(node.left, node);
                queue.add(node.left);
            }
            if (node.right != null) {
                parent.put(node.right, node);
                queue.add(node.right);
            }
        }
        Set<TreeNode> ancestorSet=new HashSet<>();
        while(p != null){
            ancestorSet.add(p);
            p=parent.get(p);
        }
        while(q !=null && !ancestorSet.contains(q))
            q = parent.get(q);
        return q;
    }
}
