package com.dsa.leetcodemaychallenge;

// https://leetcode.com/problems/longest-valid-parentheses/

import java.util.Stack;

public class LongestValidParentheses {
    public static void main(String[] args) {
        String s=")()())";//"(()";
        System.out.println(longestValidParentheses(s));
    }

    private static int longestValidParentheses(String s) {
        int count=0;
        Stack<Integer> stack=new Stack<>();
        stack.push(-1);
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='(')
                stack.push(i);
            else if(!s.isEmpty()){
                stack.pop();
                if(stack.isEmpty())
                    stack.push(i);
                else
                    count=Math.max(count,i-stack.peek());
            }
        }
        return count;
    }
}
