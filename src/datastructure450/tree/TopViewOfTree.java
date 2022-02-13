package datastructure450.tree;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

// https://practice.geeksforgeeks.org/problems/top-view-of-binary-tree/1

public class TopViewOfTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);
        root.right.left.left = new TreeNode(7);
        root.right.left.right = new TreeNode(8);
        topView(root);
    }

    // O(n) time complexity and O(n) space complexity
    private static void topView(TreeNode root) {
        Map<Integer, Integer> map = new TreeMap<>();
        Queue<MyPair> queue = new LinkedList<>();
        queue.add(new MyPair(root, 0));
        while (!queue.isEmpty()) {
            MyPair curr = queue.poll();
            int horizontalDistance = curr.horizontalDistance;
            root = curr.node;
            if (!map.containsKey(horizontalDistance))
                map.put(horizontalDistance, root.val);
            if (root.left != null)
                queue.add(new MyPair(root.left, horizontalDistance - 1));
            if (root.right != null)
                queue.add(new MyPair(root.right, horizontalDistance + 1));
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet())
            System.out.print(entry.getValue() + " ");
    }
}