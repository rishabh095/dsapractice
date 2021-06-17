package datastructure450.string;

// https://www.geeksforgeeks.org/minimum-number-of-bracket-reversals-needed-to-make-an-expression-balanced/

import java.util.Stack;

public class MinimumNumberOfBracketReversalsNeededToMakeExpressionBalanced {
    public static void main(String[] args) {
        String expression = "}}{{";
        System.out.println(countMinReversalsBetterSolution(expression));
        System.out.println(countMinReversals(expression));
    }

    // O(n) time complexity and O(1) space complexity
    private static int countMinReversalsBetterSolution(String expression) {
        int n = expression.length();
        int left = 0, right = 0;
        for (int i = 0; i < n; i++) {
            char ch = expression.charAt(i);
            if (ch == '{')
                left++;
            else {
                if (left == 0)
                    right++;
                else
                    left--;
            }
        }
        return (int) (Math.ceil((0.0 + left) / 2) + Math.ceil((0.0 + right) / 2));
    }

    // O(n) time complexity and O(n) space complexity
    private static int countMinReversals(String expression) {
        int n = expression.length();
        if (n % 2 != 0)
            return -1;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            char ch = expression.charAt(i);
            if (ch == '}' && !stack.isEmpty()) {
                if (stack.peek() == '{')
                    stack.pop();
            }
            stack.push(ch);
        }
        int remLen = stack.size();
        int i = 0;
        while (!stack.isEmpty() && stack.peek() == '{') {
            stack.pop();
            i++;
        }
        return remLen / 2 + (i % 2);
    }
}
