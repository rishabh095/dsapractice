package datastructure450.tree;

// https://www.geeksforgeeks.org/kth-ancestor-node-binary-tree/

import java.util.*;

public class KthAncestorOfNodeInABinaryTree {
    static int k;
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        k = 2;
        int node = 5;
        System.out.println(kthAncestorIterative(root, node, k));
        kthAncestorRecursive(root, node);
        kthAncestorIterativeOtherSolution(root, node);
    }

    private static boolean kthAncestorIterativeOtherSolution(TreeNode root, int node) {
        if(root==null)
            return false;
        if(root.val==node){
            k=k-1;
            return true;
        }else{
            boolean flag=kthAncestorIterativeOtherSolution(root.left, node);
            if(flag){
                if(k==0){
                    System.out.println(root.val);
                    return false;
                }
                k=k-1;
                return true;
            }
            boolean flag2=kthAncestorIterativeOtherSolution(root.right, node);
            if(flag2){
                if(k==0){
                    System.out.println(root.val);
                    return false;
                }
                k=k-1;
                return true;
            }
        }
        return false;
    }

    private static TreeNode kthAncestorRecursive(TreeNode root, int node) {
        if (root == null)
            return null;
        if (root.val == node || kthAncestorRecursive(root.left, node) != null ||
                kthAncestorRecursive(root.right, node) != null) {
            if (k > 0)
                k=k-1;
            else if (k == 0) {
                System.out.println("kth ancestor " + root.val);
                return null;
            }
            return root;
        }
        return null;
    }

    private static int kthAncestorIterative(TreeNode root, int node, int k) {
        int[] ancestor = new int[6];
        generatedArray(root, ancestor);
        int count = 0;
        while (node != -1) {
            node = ancestor[node];
            count++;
            if (count == k)
                break;
        }
        return node;
    }

    private static void generatedArray(TreeNode root, int[] ancestor) {
        ancestor[root.val] = -1;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            root = queue.poll();
            if (root.left != null) {
                ancestor[root.left.val] = root.val;
                queue.add(root.left);
            }
            if (root.right != null) {
                ancestor[root.right.val] = root.val;
                queue.add(root.right);
            }
        }
    }
}
