package com.dsa.leetcode;

import java.util.Stack;

// Basic Calculator II
// https://leetcode.com/problems/basic-calculator-ii/

public class BasicCalculatorII {
    public static void main(String[] args) {
        String s = "2*5/2";//"22*6";
        System.out.println(calculate(s));
        System.out.println(calculateEfficientSolution(s));
    }

    // O(n) time complexity and O(1) space complexity
    private static int calculateEfficientSolution(String s) {
        if (s == null || s.isEmpty())
            return 0;
        int n = s.length();
        int currentNumber = 0, lastNumber = 0, result = 0;
        char operator = '+';
        for (int i = 0; i < n; i++) {
            char currentChar = s.charAt(i);
            if (Character.isDigit(currentChar))
                currentNumber = (currentNumber * 10) + (currentChar - '0');
            if (!Character.isDigit(currentChar) && !Character.isWhitespace(currentChar)
                    || i == n - 1) {
                if (operator == '+' || operator == '-') {
                    result += lastNumber;
                    lastNumber = (operator == '+') ? currentNumber : -currentNumber;
                } else if (operator == '*')
                    lastNumber *= currentNumber;
                else if (operator == '/')
                    lastNumber /= currentNumber;
                operator = currentChar;
                currentNumber = 0;
            }
        }
        result += lastNumber;
        return result;
    }

    // O(n) time complexity and O(n) space complexity
    private static int calculate(String s) {
        if (s == null || s.isEmpty())
            return 0;
        int n = s.length();
        int currentNumber = 0;
        char operator = '+';
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            char currentChar = s.charAt(i);
            if (Character.isDigit(currentChar))
                currentNumber = (currentNumber * 10) + (currentChar - '0');
            if (!Character.isDigit(currentChar) && !Character.isWhitespace(currentChar)
                    || i == n - 1) {
                if (operator == '+')
                    stack.push(currentNumber);
                else if (operator == '-')
                    stack.push(-currentNumber);
                else if (operator == '*')
                    stack.push(stack.pop() * currentNumber);
                else if (operator == '/')
                    stack.push(stack.pop() / currentNumber);
                operator = currentChar;
                currentNumber = 0;
            }
        }
        int result = 0;
        while (!stack.isEmpty()) {
            result += stack.pop();
        }
        return result;
    }
}
