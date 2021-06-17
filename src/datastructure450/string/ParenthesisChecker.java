package datastructure450.string;

// https://practice.geeksforgeeks.org/problems/parenthesis-checker2744/1

import java.util.Stack;

public class ParenthesisChecker {
    public static void main(String[] args) {
        String str = "{([])}";
        System.out.println(parenthesisChecker(str, str.length()));
    }

    private static boolean parenthesisChecker(String str, int n) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            char ch = str.charAt(i);
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
                continue;
            }
            if (stack.isEmpty())
                return false;
            char check = stack.pop();
            switch (ch) {
                case ')':
                    if (check == '{' || check == '[')
                        return false;
                    break;
                case '}':
                    if (check == '(' || check == '[')
                        return false;
                    break;
                case ']':
                    if (check == '{' || check == '(')
                        return false;
                    break;
            }
        }
        return stack.isEmpty();
    }
}
