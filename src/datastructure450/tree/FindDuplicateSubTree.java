package datastructure450.tree;

import java.util.HashMap;
import java.util.Map;

public class FindDuplicateSubTree {
    static Map<String, Integer> map;

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(2);
        root.right.left.left = new TreeNode(4);
        root.right.right = new TreeNode(4);
        printAllDuplicates(root);
    }

    // O(n) time complexity and O(n) space complexity
    private static void printAllDuplicates(TreeNode root) {
        map = new HashMap<>();
        inorder(root);
        for (Map.Entry<String, Integer> entry : map.entrySet())
            System.out.println(entry.getKey() + " " + entry.getValue());
    }

    private static String inorder(TreeNode root) {
        if (root == null)
            return "";
        StringBuilder str = new StringBuilder();
        str.append("(");
        str.append(inorder(root.left));
        str.append(root.val);
        str.append(inorder(root.right));
        str.append(")");
        if (map.get(str.toString()) != null && map.get(str.toString()) == 1)
            System.out.print(root.val + " ");
        map.put(str.toString(), map.getOrDefault(str.toString(), 0) + 1);
        return str.toString();
    }
}
