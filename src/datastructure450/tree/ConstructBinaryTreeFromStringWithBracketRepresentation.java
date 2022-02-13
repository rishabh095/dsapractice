package datastructure450.tree;

// https://www.geeksforgeeks.org/construct-binary-tree-string-bracket-representation/

import java.util.Stack;

public class ConstructBinaryTreeFromStringWithBracketRepresentation {
    static  int start;
    public static void main(String[] args) {
        String str = "4(2(39)(1))(6(5))";
        TreeNode root = treeFromString(str, 0, str.length() - 1);
        preOrder(root);
        System.out.println();
        start=0;
        TreeNode root1 = treeFromStringOtherSolution(str );
        preOrder(root1);
    }

    private static TreeNode treeFromStringOtherSolution(String str) {
        if(str.length()==0 || str==null)
            return null;
        if(start>=str.length())
            return null;
        int num=0;
        while(start<str.length() && Character.isDigit(str.charAt(start))){
            int digit=Character.getNumericValue(str.charAt(start));
            num =num*10+digit;
            start++;
        }
        TreeNode root=new TreeNode(num);
        if(start>=str.length())
            return root;
        if(start<str.length() && str.charAt(start)=='('){
            start++;
            root.left=treeFromStringOtherSolution(str);
        }
        if(start<str.length() && str.charAt(start)==')'){
            start++;
            return root;
        }
        if(start<str.length() && str.charAt(start)=='('){
            start++;
            root.right=treeFromStringOtherSolution(str);
        }
        if(start<str.length() && str.charAt(start)==')'){
            start++;
            return root;
        }
        return root;
    }

    // O(n^2) time complexity
    private static TreeNode treeFromString(String str, int start, int end) {
        if (start > end)
            return null;
        TreeNode root = new TreeNode(str.charAt(start )- '0');
        int index = -1;
        if (start + 1 <= end && str.charAt(start + 1) == '(')
            index = findIndex(str, start + 1, end);
        if (index != -1) {
            root.left = treeFromString(str, start + 2, index - 1);
            root.right = treeFromString(str, index + 2, end - 1);
        }
        return root;
    }

    private static int findIndex(String str, int start, int end) {
        if (start > end)
            return -1;
        Stack<Character> stack = new Stack<>();
        for (int i = start; i <= end; i++) {
            if (str.charAt(i) == '(')
                stack.push(str.charAt(i));
            else if (str.charAt(i) == ')') {
                if (stack.peek() == '(') {
                    stack.pop();
                    if (stack.isEmpty())
                        return i;
                }
            }
        }
        return -1;
    }

    private static void preOrder(TreeNode root) {
        if (root != null) {
            System.out.print(root.val + " ");
            preOrder(root.left);
            preOrder(root.right);
        }
    }
}
