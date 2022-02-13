package datastructure450.heap;

// https://www.geeksforgeeks.org/check-if-a-given-binary-tree-is-heap/

import java.util.LinkedList;
import java.util.Queue;

public class CheckIfABinaryTreeIsHeap {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(9);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(7);
        root.left.right = new TreeNode(6);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(4);
        root.left.left.left = new TreeNode(3);
        root.left.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(1);
        System.out.println(isHeap(root));
        System.out.println(isHeapIterativeSolution(root));
    }

    private static boolean isHeapIterativeSolution(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        boolean isNull = false;
        while (!q.isEmpty()) {
            TreeNode curr = q.poll();
            if (curr.left != null) {
                if (isNull || curr.left.val >= curr.val)
                    return false;
                q.add(curr.left);
            } else
                isNull = true;
            if (curr.right != null) {
                if (isNull || curr.right.val >= curr.val)
                    return false;
                q.add(curr.right);
            } else
                isNull = true;
        }
        return true;
    }

    private static boolean isHeap(TreeNode root) {
        if (root == null)
            return true;
        int noOfNodes = countNodes(root);
        if (isCompleteTree(root, 0, noOfNodes) && isHeapUtil(root))
            return true;
        return false;
    }

    private static boolean isHeapUtil(TreeNode root) {
        if (root.left == null && root.right == null)
            return true;
        if (root.right == null) {
            if (root.val >= root.left.val)
                return true;
        } else {
            if (root.val >= root.left.val && root.val >= root.right.val)
                return isHeapUtil(root.left) && isHeapUtil(root.right);
        }
        return false;
    }

    private static boolean isCompleteTree(TreeNode root, int index, int noOfNodes) {
        if (root == null)
            return true;
        if (index >= noOfNodes)
            return false;
        return isCompleteTree(root.left, 2 * index + 1, noOfNodes) &&
                isCompleteTree(root.right, 2 * index + 2, noOfNodes);
    }

    private static int countNodes(TreeNode root) {
        if (root == null)
            return 0;
        return 1 + countNodes(root.left) + countNodes(root.right);
    }
}
